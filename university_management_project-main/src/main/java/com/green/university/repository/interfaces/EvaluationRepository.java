package com.green.university.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.university.dto.EvaluationDto;
import com.green.university.dto.MyEvaluationDto;
import com.green.university.repository.model.Evaluation;

/**
 * 
 * @author 편용림
 *
 */
@Mapper
public interface EvaluationRepository {
	
	// 강의 평가 제출 (학생)
	public int insert(EvaluationDto evaluationFormDto);
	
	// 강의평가 했는지 조회 (학생)
	public Evaluation selectEvaluation(Integer studentId);
	
	// 강의평가 조회 (교수)
	public List<MyEvaluationDto> selectMyEvaluationDtoByProfessorId(Integer professorId);
	// 과목별 강의평가 조회 (교수)
	public List<MyEvaluationDto> selectEvaluationDtoByprofessorIdAndName(@Param("professorId") Integer professorId, @Param("name") String Name);
	// 강의평가 과목 조회 (교수)
	public List<MyEvaluationDto> selectEvaluationDto(Integer professorId);
}
