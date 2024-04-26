package com.green.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.university.dto.ProfessorListForm;
import com.green.university.dto.SyllaBusFormDto;
import com.green.university.dto.UpdateStudentGradeDto;
import com.green.university.dto.response.ReadSyllabusDto;
import com.green.university.dto.response.StudentInfoForProfessorDto;
import com.green.university.dto.response.SubjectForProfessorDto;
import com.green.university.dto.response.SubjectPeriodForProfessorDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.interfaces.ProfessorRepository;
import com.green.university.repository.interfaces.StuSubDetailRepository;
import com.green.university.repository.interfaces.StuSubRepository;
import com.green.university.repository.interfaces.SubjectRepository;
import com.green.university.repository.interfaces.SyllaBusRepository;
import com.green.university.repository.model.Professor;
import com.green.university.repository.model.Subject;

/**
 * 
 * @author 김지현
 */
@Service
public class ProfessorService {

	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private StuSubRepository stuSubRepository;
	@Autowired
	private StuSubDetailRepository stuSubDetailRepository;
	@Autowired
	private SyllaBusRepository syllaBusRepository;
	@Autowired
	private ProfessorRepository professorRepository;

	/**
	 * 교수가 맡은 과목들의 학기 검색
	 * 
	 * @param professorId
	 * @return SubjectPeriodForProfessorDto list
	 */
	@Transactional
	public List<SubjectPeriodForProfessorDto> selectSemester(Integer id) {
		List<SubjectPeriodForProfessorDto> list = subjectRepository.selectSemester(id);
		return list;
	}

	/**
	 * 년도와 학기, 교수 id를 이용하여 해당 과목의 정보 불러오기
	 * 
	 * @param subjectPeriodForProfessorDto
	 * @return SubjectForProfessorDto list
	 */
	@Transactional
	public List<SubjectForProfessorDto> selectSubjectBySemester(
			SubjectPeriodForProfessorDto subjectPeriodForProfessorDto) {
		List<SubjectForProfessorDto> list = subjectRepository.selectSubjectBySemester(subjectPeriodForProfessorDto);

		return list;
	}

	/**
	 * 해당 과목을 듣는 학생의 세부정보 리스트로 불러오기
	 * 
	 * @param subjectId
	 * @return StudentInfoForProfessorDto list
	 */
	@Transactional
	public List<StudentInfoForProfessorDto> selectBySubjectId(Integer subjectId) {
		List<StudentInfoForProfessorDto> list = stuSubRepository.selectBySubjectId(subjectId);

		return list;
	}

	/**
	 * 과목 id로 과목 Entity 불러오기
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public Subject selectSubjectById(Integer id) {
		Subject subjectEntity = subjectRepository.selectSubjectById(id);

		return subjectEntity;
	}

	/**
	 * 출결 및 성적 기입
	 * 
	 * @param updateStudentGradeDto
	 */
	@Transactional
	public void updateGrade(UpdateStudentGradeDto updateStudentGradeDto) {

		int resultRowCount = stuSubDetailRepository.updateGrade(updateStudentGradeDto);

		if (resultRowCount != 1) {
			throw new CustomRestfullException("요청을 처리하지 못했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resultRowCount = stuSubRepository.updateGradeByStudentIdAndSubjectId(updateStudentGradeDto);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("요청을 처리하지 못했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * 강의계획서 조회
	 * 
	 * @param subjectId
	 * @return 강의계획서
	 */
	@Transactional
	public ReadSyllabusDto readSyllabus(Integer subjectId) {

		ReadSyllabusDto readSyllabusDto = subjectRepository.selectSyllabusBySubjectId(subjectId);
		System.out.println(readSyllabusDto.toString());
		return readSyllabusDto;
	}

	/**
	 * 강의 계획서 업데이트
	 * 
	 * @param syllaBusFormDto
	 */
	@Transactional
	public void updateSyllabus(SyllaBusFormDto syllaBusFormDto) {

		int resultRowCount = syllaBusRepository.updateSyllabus(syllaBusFormDto);
		if (resultRowCount != 1) {
			throw new CustomRestfullException("제출 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * @param professorListForm
	 * @return 교수 리스트 조회
	 */
	@Transactional
	public List<Professor> readProfessorList(ProfessorListForm professorListForm) {
		List<Professor> list = null;
		if (professorListForm.getProfessorId() != null) {
			list = professorRepository.selectByProfessorId(professorListForm);
		} else if (professorListForm.getDeptId() != null) {
			list = professorRepository.selectByDepartmentId(professorListForm);
		} else {
			list = professorRepository.selectProfessorList(professorListForm);
		}

		return list;
	}

	/**
	 * 
	 * @param studentListForm
	 * @return 교수 수
	 */
	@Transactional
	public Integer readProfessorAmount(ProfessorListForm professorListForm) {

		Integer amount = null;
		if (professorListForm.getDeptId() != null) {
			amount = professorRepository.selectProfessorAmountByDeptId(professorListForm.getDeptId());
		} else {
			amount = professorRepository.selectProfessorAmount();
		}

		return amount;
	}

}
