package com.green.university.repository.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Staff {

	private Integer id;
	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private Date hireDate;
	
}
