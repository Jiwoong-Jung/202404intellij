package com.sky._sb0423.spring;

import lombok.ToString;

@ToString
public class AuthInfo {

	private Long id;
	private String email;
	private String name;

	public AuthInfo(Long id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

}
