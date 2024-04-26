package com.green.university.repository.model;

import lombok.Data;

@Data
public class PreStuSub {

	private Integer studentId;
	private Integer subjectId;
	
	public PreStuSub(Integer studentId, Integer subjectId) {
		this.studentId = studentId;
		this.subjectId = subjectId;
	}

	public PreStuSub() {
	}
	
}
