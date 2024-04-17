package com.sky.spring;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime regdate;

	public Member(String email, String password, 
			String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.regdate = regDateTime;
	}

	void setId(Long id) {
		this.id = id;
	}



	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

}
