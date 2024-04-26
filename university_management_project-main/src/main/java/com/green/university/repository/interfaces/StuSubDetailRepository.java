package com.green.university.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.university.dto.UpdateStudentGradeDto;

/**
 * stu_sub_detail_tb DAO
 * @author 김지현
 *
 */
@Mapper
public interface StuSubDetailRepository {
	
	// 학생 성적 업데이트
	int updateGrade(UpdateStudentGradeDto updateStudentGradeDto);

	/**
	 * @author 서영
	 */
	int insert(@Param("id") Integer id, @Param("studentId") Integer studentId, @Param("subjectId") Integer subjectId);
	
}
