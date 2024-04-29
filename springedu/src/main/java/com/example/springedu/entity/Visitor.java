package com.example.springedu.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@CreationTimestamp
	@Column(name = "writedate")
	private java.sql.Date writeDate;
	private String memo;	
}
