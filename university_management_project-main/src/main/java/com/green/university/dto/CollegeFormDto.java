package com.green.university.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
/**
 * 
 * @author 박성희
 *
 */
@Data
public class CollegeFormDto {
	@NotBlank
	private String name;
}
