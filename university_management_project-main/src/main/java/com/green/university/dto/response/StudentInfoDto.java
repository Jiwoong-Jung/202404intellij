package com.green.university.dto.response;

import java.sql.Date;

import lombok.Data;

@Data
public class StudentInfoDto {

	private Integer id;
	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private Integer deptId;
	private Integer grade;
	private Integer semester;
	private Date entranceDate;
	private Date graduationDate;
	private String deptName;
	private String collegeName;
}
