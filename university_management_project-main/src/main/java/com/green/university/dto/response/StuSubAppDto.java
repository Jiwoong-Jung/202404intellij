package com.green.university.dto.response;

import lombok.Data;

/**
 * @author 서영
 */
@Data
public class StuSubAppDto {

	private Integer studentId;
	private Integer subjectId;
	private String subjectName;
	private String professorName;
	private Integer grades;

	private String subDay;
	private Integer startTime;
	private Integer endTime;
	private Integer numOfStudent;
	private Integer capacity;
	private String roomId;
	
	private Boolean status;
	
}
