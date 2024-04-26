package com.green.university.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author 서영
 * 전체 강의 조회에서 사용하는 검색 폼 dto
 */
@Data
public class AllSubjectSearchFormDto {

	private Integer subYear;
	
	private Integer semester;
	
	private Integer deptId;
	
	private String name;
	
	private Integer page;
	
}
