package com.green.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.university.dto.EvaluationDto;
import com.green.university.dto.MyEvaluationDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.interfaces.EvaluationRepository;
import com.green.university.repository.model.Evaluation;

@Service
public class EvaluationService {

	@Autowired
	private EvaluationRepository evaluationRepository;

	@Transactional
	public void createEvanluation(EvaluationDto evaluationFormDto) {

		int resultRowcount = evaluationRepository.insert(evaluationFormDto);

		if (resultRowcount != 1) {
			throw new CustomRestfullException("강의평가 등록이 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 강의평가 조회 (학생)
	@Transactional
	public Evaluation readEvaluationByStudentIdAndSubjectId(Integer studentId) {
		Evaluation evaluation = evaluationRepository.selectEvaluation(studentId);
		return evaluation;
	}

	// 전체 강의평가 조회 (교수)
	@Transactional
	public List<MyEvaluationDto> readEvaluationByProfessorId(Integer professorId) {
		List<MyEvaluationDto> evaluation = evaluationRepository.selectMyEvaluationDtoByProfessorId(professorId);
		return evaluation;
	}

	// 과목별 강의평가 조회 (교수)
	@Transactional
	public List<MyEvaluationDto> readEvaluationByProfessorIdAndName(Integer professorId, String name) {
		List<MyEvaluationDto> evaluation = evaluationRepository.selectEvaluationDtoByprofessorIdAndName(professorId,
				name);
		return evaluation;
	}

	public List<MyEvaluationDto> readSubjectName(Integer professorId) {
		List<MyEvaluationDto> subjectName = evaluationRepository.selectEvaluationDto(professorId);
		return subjectName;
	}
}
