package com.green.university.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.green.university.repository.model.College;
import com.green.university.utils.NumberUtil;

import lombok.Data;
/**
 * 
 * @author 박성희
 *
 */
@Data
public class CollTuitFormDto {
	@NotBlank
	private Integer collegeId;
	private String 	name;
	@NotEmpty
	private Integer amount;

	public String amountFormat() {
		return NumberUtil.numberFormat(amount);
	}
	
}
