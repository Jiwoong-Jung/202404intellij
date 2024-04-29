package com.example.springedu.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
public class Emp {
	@Id
	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private java.sql.Date  hiredate;
	private int sal;
	private Integer comm;
	private Integer deptno;
}
