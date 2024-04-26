package com.green.university.repository.model;

import lombok.Data;

@Data
public class Subject {
	private Integer id;
	private String name;
	private Integer professorId;
	private String roomId;
	private Integer deptId;
	private String type;
	private Integer subYear;
	private Integer semester;
	private String subDay;
	private Integer startTime;
	private Integer endTime;
	private Integer grades;
	private Integer capacity;
	private Integer numOfStudent;
}
