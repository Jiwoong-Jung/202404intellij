package com.green.university.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserUpdateDto {
	
	private Integer userId;
	@NotEmpty
	private String address;
	@NotBlank
	private String tel;
	@Email
	private String email;
	
}
