package com.green.university.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.green.university.repository.model.College;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author 박성희
 *
 */
@Data
public class DepartmentFormDto {
	private Integer id;
	@NotNull
	@NotBlank
	@NotEmpty
	private String name;
	@NotNull
	private Integer collegeId;
	private String collegeName;
}
