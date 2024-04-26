package com.green.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.university.dto.response.StuSubAppDto;
import com.green.university.dto.response.StuSubDayTimeDto;
import com.green.university.dto.response.StuSubSumGradesDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.interfaces.PreStuSubRepository;
import com.green.university.repository.interfaces.StuSubDetailRepository;
import com.green.university.repository.interfaces.StuSubRepository;
import com.green.university.repository.interfaces.SubjectRepository;
import com.green.university.repository.model.PreStuSub;
import com.green.university.repository.model.StuSub;
import com.green.university.repository.model.Subject;
import com.green.university.utils.Define;
import com.green.university.utils.StuSubUtil;

/**
 * @author 서영
 *
 */
@Service
public class StuSubService {

	@Autowired
	private StuSubRepository stuSubRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private PreStuSubRepository preStuSubRepository;

	@Autowired
	private StuSubDetailRepository stuSubDetailRepository;

	// 학생의 수강신청 내역에 해당 강의가 존재하는지 확인
	public StuSub readStuSub(Integer studentId, Integer subjectId) {

		StuSub stuSubEntity = stuSubRepository.selectByStudentIdAndSubjectId(studentId, subjectId);

		return stuSubEntity;
	}

	// 학생의 해당 학기 수강신청 내역 조회
	public List<StuSubAppDto> readStuSubList(Integer studentId) {

		List<StuSubAppDto> stuSubList = stuSubRepository.selectListByStudentIdAndSemester(studentId,
				Define.CURRENT_YEAR, Define.CURRENT_SEMESTER);

		return stuSubList;
	}

	// 학생의 수강신청 내역 추가
	@Transactional
	public void createStuSub(Integer studentId, Integer subjectId) {

		// 신청 대상 과목 정보
		Subject targetSubject = subjectRepository.selectSubjectById(subjectId);

		// 신청 대상 과목의 정원이 다 찼다면 신청 불가
		if (targetSubject.getNumOfStudent() >= targetSubject.getCapacity()) {
			throw new CustomRestfullException("정원이 초과되었습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// 현재 총 신청 학점
		StuSubSumGradesDto stuSubSumGradesDto = stuSubRepository.selectSumGrades(studentId, Define.CURRENT_YEAR,
				Define.CURRENT_SEMESTER);

		// 최대 수강 가능 학점을 넘지 않는지 확인
		StuSubUtil.checkSumGrades(targetSubject, stuSubSumGradesDto);

		// 해당 학생의 예비 수강 신청 내역 시간표
		List<StuSubDayTimeDto> dayTimeList = stuSubRepository.selectDayTime(studentId, Define.CURRENT_YEAR,
				Define.CURRENT_SEMESTER);

		// 현재 학생의 시간표와 겹치지 않는지 확인
		StuSubUtil.checkDayTime(targetSubject, dayTimeList);

		// 수강신청 내역 추가
		int resultRowCount = stuSubRepository.insert(studentId, subjectId);

		// 수강 상세 내역에도 데이터 추가
		StuSub stuSub = stuSubRepository.selectByStudentIdAndSubjectId(studentId, subjectId);
		stuSubDetailRepository.insert(stuSub.getId(), studentId, subjectId);

		// 해당 강의 현재인원 +1
		subjectService.updatePlusNumOfStudent(subjectId);

		if (resultRowCount != 1) {
			throw new CustomRestfullException("수강신청이 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// 학생의 수강신청 내역 삭제
	@Transactional
	public void deleteStuSub(Integer studentId, Integer subjectId) {

		// 수강신청 내역 삭제
		int resultRowCount = stuSubRepository.delete(studentId, subjectId);

		// 해당 강의 현재인원 -1
		subjectService.updateMinusNumOfStudent(subjectId);

		if (resultRowCount != 1) {
			throw new CustomRestfullException("예비 수강신청 취소가 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 예비 수강 신청 기간 -> 수강 신청 기간 변경 시 로직
	@Transactional
	public void createStuSubByPreStuSub() {

		// 1. 정원 >= 신청인원인 강의
		List<Integer> idList1 = subjectRepository.selectIdByLessNumOfStudent();

		for (Integer subjectId : idList1) {

			// 예비 수강 신청에서 해당 강의를 신청했던 내역 가져오기
			List<PreStuSub> preAppList = preStuSubRepository.selectBySubjectId(subjectId);

			// 예비 수강 신청했던 인원들이 자동으로 수강 신청되도록
			// 해당 내역 그대로 수강 신청 추가
			for (PreStuSub pss : preAppList) {
				// 수강 신청 내역이 없다면
				if (stuSubRepository.selectByStudentIdAndSubjectId(pss.getStudentId(), pss.getSubjectId()) == null) {
					stuSubRepository.insert(pss.getStudentId(), pss.getSubjectId());

					// 수강 상세 내역에도 데이터 추가
					StuSub stuSub = stuSubRepository.selectByStudentIdAndSubjectId(pss.getStudentId(),
							pss.getSubjectId());
					stuSubDetailRepository.insert(stuSub.getId(), pss.getStudentId(), pss.getSubjectId());
				}
			}
		}

		// 2. 정원 < 신청인원인 강의
		List<Integer> idList2 = subjectRepository.selectIdByMoreNumOfStudent();

		for (Integer subjectId : idList2) {

			// 강의의 현재 인원 초기화
			subjectRepository.updateNumOfStudent(subjectId, "초기화");

		}
	}

	// 수강 신청 내역과 예비 수강 신청 내역 조인 후 조회 -> 예비 수강 신청에만 존재
	@Transactional
	public List<StuSubAppDto> readPreStuSubByStuSub(Integer studentId) {
		List<StuSubAppDto> dtoList = stuSubRepository.selectJoinListByStudentId(studentId);
		return dtoList;
	}
	
	// 점수 입력 시 F면 취득학점 0, F가 아니면 강의의 이수학점
	@Transactional
	public void updateCompleteGrade(Integer studentId, Integer subjectId, Integer completeGrade) {
		stuSubRepository.updateCompleteGradeByStudentIdAndSubjectId(studentId, subjectId, completeGrade);
	}
}
