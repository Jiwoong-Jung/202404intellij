package com.green.university.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.university.dto.response.StuSubAppDto;
import com.green.university.dto.response.StuSubDayTimeDto;
import com.green.university.dto.response.StuSubSumGradesDto;
import com.green.university.repository.model.PreStuSub;

/**
 * @author 서영
 *
 */
@Mapper
public interface PreStuSubRepository {

	// 학생의 예비 수강 신청 내역에 해당 강의가 있는지 조회
	PreStuSub selectByStudentIdAndSubjectId(@Param("studentId") Integer studentId, @Param("subjectId") Integer subjectId);
	
	// 학생의 이번 학기 전체 예비 수강 신청 내역 조회
	List<StuSubAppDto> selectListByStudentIdAndSemester(@Param("studentId") Integer studentId, @Param("subYear") Integer subYear, @Param("semester") Integer semester);
	
	// 학생의 예비 수강 신청 학점 조회
	StuSubSumGradesDto selectSumGrades(@Param("studentId") Integer studentId, @Param("subYear") Integer subYear, @Param("semester") Integer semester);
	
	// 학생의 예비 수강 신청 내역 시간표 조회
	List<StuSubDayTimeDto> selectDayTime(Integer studentId);
	
	// 예비 수강 신청 내역 추가
	int insert(@Param("studentId") Integer studentId, @Param("subjectId") Integer subjectId);
	
	// 예비 수강 신청 내역 삭제
	int delete(@Param("studentId") Integer studentId, @Param("subjectId") Integer subjectId);
	
	// 예비 수강 신청 내역에 해당 강의가 있는 학생들 조회
	List<PreStuSub> selectBySubjectId(Integer subjectId);
	
}
