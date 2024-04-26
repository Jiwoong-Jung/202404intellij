package com.green.university.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * 
 * @author 박성희
 *
 */
@Data
public class SubjectFormDto {
	private Integer id;
	@NotEmpty
	@Size(min=2, max=20)
	private String name;
	@NotEmpty
	@Min(10000000)
	@Max(99999999)
	private Integer professorId;
	@Size(max = 5)
	private String roomId;
	@NotEmpty
	private Integer deptId;
	@NotEmpty
	@Size(max = 2)
	private String type;
	@NotEmpty
	private Integer subYear;
	@NotEmpty
	@Min(1)
	@Max(2)
	private Integer semester;
	@NotEmpty
	@Size(max = 1)
	private String subDay;
	@NotEmpty
	@Min(9)
	@Max(18)
	private Integer startTime;
	@NotEmpty
	@Min(9)
	@Max(18)
	private Integer endTime;
	@NotEmpty
	private Integer grades;
	@NotEmpty
	private Integer capacity;
	private Integer numOfStudent;
}
