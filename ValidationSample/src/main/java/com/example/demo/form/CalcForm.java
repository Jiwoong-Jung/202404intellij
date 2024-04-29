package com.example.demo.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class CalcForm {
	@NotNull
	@Range(min = 1, max = 10)
	private Integer leftNum;

	@NotNull
	@Range(min = 1, max = 10)
	private Integer rightNum;
}