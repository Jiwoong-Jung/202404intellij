package com.green.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.university.dto.response.GradeForScholarshipDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.interfaces.ScholarshipRepository;
import com.green.university.repository.interfaces.TuitionRepository;
import com.green.university.repository.model.BreakApp;
import com.green.university.repository.model.Scholarship;
import com.green.university.repository.model.StuSch;
import com.green.university.repository.model.StuStat;
import com.green.university.repository.model.Student;
import com.green.university.repository.model.Tuition;
import com.green.university.utils.Define;

/**
 * @author 서영
 */

@Service
public class TuitionService {

	@Autowired
	private TuitionRepository tuitionRepository;

	@Autowired
	private ScholarshipRepository scholarshipRepository;

	@Autowired
	private StuStatService stuStatService;

	@Autowired
	private BreakAppService breakAppService;

	@Autowired
	private UserService userService;

	@Autowired
	private GradeService gradeService;

	/**
	 * @param studentId (principal의 id와 동일)
	 * @return 해당 학생의 모든 등록금 납부 내역
	 */
	@Transactional
	public List<Tuition> readTuitionList(Integer studentId) {

		List<Tuition> tuitionEntityList = tuitionRepository.selectByStudentId(studentId);

		return tuitionEntityList;
	}

	/**
	 * @param studentId (principal의 id와 동일)
	 * @return 해당 학생의 납부 여부에 따른 등록금 납부 내역
	 */
	@Transactional
	public List<Tuition> readTuitionListByStatus(Integer studentId, Boolean status) {

		List<Tuition> tuitionEntityList = tuitionRepository.selectByStudentIdAndStatus(studentId, status);

		return tuitionEntityList;
	}

	/**
	 * @return 해당 학생의 현재 학기 등록금 고지서
	 */
	@Transactional
	public Tuition readByStudentIdAndSemester(Integer studentId, Integer tuiYear, Integer semester) {

		Tuition tuitionEntity = tuitionRepository.selectByStudentIdAndSemester(studentId, tuiYear, semester);

		return tuitionEntity;
	}

	/**
	 * 장학금 유형 결정
	 */
	public Integer createCurrentSchType(Integer studentId) {

		StuSch stuSch = new StuSch();
		stuSch.setStudentId(studentId);
		stuSch.setSchYear(Define.CURRENT_YEAR);
		stuSch.setSemester(Define.CURRENT_SEMESTER);

		Student studentEntity = userService.readStudent(studentId);

		// 1학년 2학기 이상의 학생이라면
		if (studentEntity.getGrade() > 1 || studentEntity.getSemester() == 2) {
			// 직전 학기 성적 평균
			// 상수로 선언해둬서 노란줄 뜨는 거니까 무시하기
			GradeForScholarshipDto gradeDto = null;
			if (Define.CURRENT_SEMESTER == 1) {
				gradeDto = gradeService.readAvgGrade(studentId, Define.CURRENT_YEAR - 1, 2);
			} else {
				gradeDto = gradeService.readAvgGrade(studentId, Define.CURRENT_YEAR, 1);
			}

			if (gradeDto == null) {
				scholarshipRepository.insertCurrentSchType(stuSch);
				return null;
			} else {
				Double avgGrade = gradeDto.getAvgGrade();
				// 평점에 따라 장학금 유형 결정
				if (avgGrade >= 4.2) {
					stuSch.setSchType(1);
				} else if (avgGrade >= 3.7) {
					stuSch.setSchType(2);
				}
			}

			// 1학년 1학기 학생이라면
		} else {
			stuSch.setSchType(2);
		}

		scholarshipRepository.insertCurrentSchType(stuSch);
		return stuSch.getSchType();
	}

	/**
	 * 등록금 고지서 생성 교직원 탭에서 사용하도록 할 것
	 * 
	 * @param studentId (principal의 id와 동일)
	 */
	@Transactional
	public int createTuition(Integer studentId) {

		// 해당 학생의 학적 상태가 '졸업' 또는 '자퇴'라면 생성하지 않음
		StuStat stuStatEntity = stuStatService.readCurrentStatus(studentId);
		if (stuStatEntity.getStatus().equals("졸업") || stuStatEntity.getStatus().equals("자퇴")) {
			return 0;
		}

		// 해당 학생이 현재 학기 휴학을 승인받은 상태라면 생성하지 않음
		List<BreakApp> breakAppList = breakAppService.readByStudentId(studentId); // 최근 순으로 정렬되어 있음
		for (BreakApp b : breakAppList) {
			// 휴학 신청이 승인된 상태일 때
			if (b.getStatus().equals("승인")) {
				// 휴학 종료 연도가 현재 연도보다 이후라면 생성하지 않음
				if (b.getToYear() > Define.CURRENT_YEAR) {
					return 0;
					// 휴학 종료 연도가 현재 연도와 같을 경우
				} else if (b.getToYear() == Define.CURRENT_YEAR) {
					// 현재 학기 == 1 && 종료 학기 == 1이면 생성하지 않음
					// 현재 학기 == 1 && 종료 학기 == 2이면 생성하지 않음
					// 현재 학기 == 2 && 종료 학기 == 1이면 생성함
					// 현재 학기 == 2 && 종료 학기 == 2이면 생성하지 않음
					if (b.getToSemester() >= Define.CURRENT_SEMESTER) {
						return 0;
					}
				}
			}
		}

		// 이미 해당 학기의 등록금 고지서가 존재한다면 생성하지 않음
		if (readByStudentIdAndSemester(studentId, Define.CURRENT_YEAR, Define.CURRENT_SEMESTER) != null) {
			return 0;
		}

		// 등록금액
		Integer tuiAmount = tuitionRepository.selectTuiAmountByStudentId(studentId).getAmount();

		// 장학금 유형 결정 + 유형 반환 (null이면 장학금 지원 대상이 아님)
		Integer schType = createCurrentSchType(studentId);

		// 장학금 유형과 최대 장학금액
		Scholarship schEntity = null;

		// 장학금액 (장학금 지원 대상이 아니면 0)
		Integer schAmount = 0;

		if (schType != null) {
			schEntity = scholarshipRepository.selectByStudentIdAndSemester(studentId, Define.CURRENT_YEAR,
					Define.CURRENT_SEMESTER);
			// 등록금액보다 최대 장학금액이 더 크다면
			if (tuiAmount < schAmount) {
				schAmount = tuiAmount;
			} else {
				schAmount = schEntity.getMaxAmount();
			}
		}

		// 등록금 고지서 생성
		Tuition tuition = new Tuition(studentId, Define.CURRENT_YEAR, Define.CURRENT_SEMESTER, tuiAmount, schType,
				schAmount);

		int resultRowCount = tuitionRepository.insert(tuition);

		// 등록금 고지서가 생성된 횟수를 출력하기 위해 반환
		return resultRowCount;
	}

	/**
	 * 등록금 납부
	 */
	@Transactional
	public void updateStatus(Integer studentId) {

		int resultRowCount = tuitionRepository.updateStatus(studentId, Define.CURRENT_YEAR, Define.CURRENT_SEMESTER);

		if (resultRowCount != 1) {
			throw new CustomRestfullException("납부 실패", HttpStatus.INTERNAL_SERVER_ERROR);
			// 납부 성공 시, 휴학 상태인 학생이라면 재학 상태로 변경
		} else {
			String status = stuStatService.readCurrentStatus(studentId).getStatus();
			if ("휴학".equals(status)) {
				stuStatService.updateStatus(studentId, "재학", "9999-01-01", null);
			}

		}
	}

}
