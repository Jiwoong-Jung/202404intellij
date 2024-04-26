package com.green.university.dto.response;

import lombok.Data;

/**
 * @author 서영
 * 강의 시간표 조회 시 사용할 Dto
 * 단과대학, 학과 등을 id 대신 이름으로 쉽게 보여주기 위해 이름을 추가해서 만듦
 */
@Data
public class SubjectDto {

	// 단과대 이름
	private String collName;
	
	// 학과 id
	private Integer deptId;
	
	// 학과 이름
	private String deptName;
	
	// 과목 id
	private Integer id;
	
	// 과목 이름
	private String name;
	
	// 교수 id
	private Integer professorId;
	
	// 교수 이름
	private String professorName;
	
	// 강의실 id (==이름)
	private String roomId;
	
	// 강의 구분 (전공/교양)
	private String type;
	
	// 개설 연도
	private Integer subYear;
	
	// 개설 학기
	private Integer semester;
	
	// 요일
	private String subDay;
	
	// 강의 시작 시간
	private Integer startTime;
	
	// 강의 종료 시간
	private Integer endTime;
	
	// 이수 가능 학점
	private Integer grades;
	
	// 정원
	private Integer capacity;
	
	// 현재 인원
	private Integer numOfStudent;
	
	// 신청 여부
	private Boolean status;
	
}
