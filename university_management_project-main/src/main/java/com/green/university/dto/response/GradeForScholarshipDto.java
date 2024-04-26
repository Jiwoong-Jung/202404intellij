package com.green.university.dto.response;

import lombok.Data;

/**
 * @author 서영
 * 장학금 유형 결정을 위한 성적을 가져오는 Dto
 */

@Data
public class GradeForScholarshipDto {

	private Integer studentId;
	private Integer subYear;
	private Integer semester;
	private Double avgGrade;
	
}
