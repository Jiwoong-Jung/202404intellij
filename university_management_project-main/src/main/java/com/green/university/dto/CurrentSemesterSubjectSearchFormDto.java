package com.green.university.dto;

import javax.validation.constraints.NotBlank;

import com.green.university.utils.Define;

import lombok.Data;

@Data
public class CurrentSemesterSubjectSearchFormDto {

	private String type;
	private Integer deptId;
	private String name;
	
	private Integer subYear = Define.CURRENT_YEAR;
	private Integer semester = Define.CURRENT_SEMESTER;
	
	private Integer page;
	
}
