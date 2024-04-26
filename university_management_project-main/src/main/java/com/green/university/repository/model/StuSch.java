package com.green.university.repository.model;

import lombok.Data;

/**
 * 학생의 학기별 장학금 유형
 */
@Data
public class StuSch {

	private Integer studentId;
	private Integer schYear;
	private Integer semester;
	private Integer schType;
	
}
