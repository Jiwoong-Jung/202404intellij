package com.green.university.dto.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserInfoForUpdateDto {

	@NotBlank
	private String address;
	@Size(min = 11, max = 13)
	private String tel;
	@Email
	private String email;
	
}
