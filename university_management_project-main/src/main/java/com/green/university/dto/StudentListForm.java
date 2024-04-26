package com.green.university.dto;

import lombok.Data;

/**
 * 학생 리스트 보기 폼
 * @author 김지현
 *
 */
@Data
public class StudentListForm {

	private Integer deptId;
	private Integer studentId;
	private Integer page;
	
	
}
