package com.green.university.dto;

import lombok.Data;

@Data
public class MyEvaluationDto {

	private Integer professorId;
	private String name;
	private Integer answer1;
	private Integer answer2;
	private Integer answer3;
	private Integer answer4;
	private Integer answer5;
	private Integer answer6;
	private Integer answer7;
	private String improvements;
	
	public String answerSum() {
		 double answerSum = (double)(answer1 + answer2 + answer3 + answer4 + answer5 + answer6 + answer7) / 7;
		 String result = String.format("%.2f", answerSum);
	 return result;
	}
	
}
