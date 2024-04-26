package com.green.university.dto;

import lombok.Data;

/**
 * 학생 출결 및 성적 기입 폼 stu_sub_detail_tb update용
 * 
 * @author 김지현
 */
@Data
public class UpdateStudentGradeDto {
	
	private Integer studentId;
	private Integer subjectId;

	// 결석 횟수
	private Integer absent;
	// 지각 횟수
	private Integer lateness;
	// 과제 점수
	private Integer homework;
	// 중간고사 점수
	private Integer midExam;
	// 기말고사 점수
	private Integer finalExam;
	// 총합 환산 점수
	private Integer convertedMark;
	// 등급
	private String grade;

}
