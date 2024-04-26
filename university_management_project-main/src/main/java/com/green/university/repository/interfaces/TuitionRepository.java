package com.green.university.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.university.repository.model.CollTuit;
import com.green.university.repository.model.Tuition;

/**
 * @author 서영
 *
 */

@Mapper
public interface TuitionRepository {

	// 특정 학생의 등록금 내역 조회
	public List<Tuition> selectByStudentId(Integer studentId);
	
	// 특정 학생의 납부 여부에 따른 등록금 내역 조회
	public List<Tuition> selectByStudentIdAndStatus(@Param("studentId") Integer studentId, @Param("status") Boolean status);
	
	// 학생의 학과-단과대를 기준으로 등록금액 조회
	public CollTuit selectTuiAmountByStudentId(Integer studentId);
	
	// 등록금 고지서 생성
	public int insert(Tuition tuition);

	// 등록금 고지서 생성 여부 확인
	public Tuition selectByStudentIdAndSemester(@Param("studentId") Integer studentId, @Param("tuiYear") Integer tuiYear, @Param("semester") Integer semester);
	
	// 등록금 납부
	public int updateStatus(@Param("studentId") Integer studentId, @Param("tuiYear") Integer tuiYear, @Param("semester") Integer semester);
	
}