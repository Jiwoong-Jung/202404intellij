package com.green.university.dto.response;

import lombok.Data;

/**
 * 과목에 대한 학생의 디테일한 정보(교수 조회, 입력용)
 * @author 김지현
 */
@Data
public class StudentInfoForProfessorDto {

	private Integer id;
	private Integer studentId;
	private String studentName;
	// 학생 소속
	private String deptName;
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
	
}
