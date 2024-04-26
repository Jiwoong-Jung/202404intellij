package com.green.university.repository.model;

import lombok.Data;

@Data
public class User {

	private Integer id;
	private String password;
	private String userRole;

}
