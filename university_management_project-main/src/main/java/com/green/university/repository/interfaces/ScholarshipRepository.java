package com.green.university.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.university.repository.model.Scholarship;
import com.green.university.repository.model.StuSch;

/**
 * @author 서영
 *
 */

@Mapper
public interface ScholarshipRepository {

	// 학생의 특정 학기 장학금 유형에 따른 최대 지원 금액
	public Scholarship selectByStudentIdAndSemester(@Param("studentId") Integer studentId, @Param("schYear") Integer schYear, @Param("semester") Integer semester);
	
	// 학생의 이번 학기 장학금 유형 결정
	public int insertCurrentSchType(StuSch stuSch);
	
}
