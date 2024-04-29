package com.example.springedu.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Meeting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name="meetingdate")
	private LocalDateTime  meetingDate;	
}
