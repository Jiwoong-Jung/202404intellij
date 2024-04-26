package com.green.university.dto;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author 서영
 *
 */

@Data
public class BreakAppFormDto {
	
	private Integer studentId;
	private Integer studentGrade;
	private Integer fromYear;
	private Integer fromSemester;
	@NotNull
	private Integer toYear;
	@NotNull
	private Integer toSemester;
	@NotNull
	private String type;
	
}
