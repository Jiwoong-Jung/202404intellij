package com.green.university.dto.response;

import lombok.Data;

@Data
public class MyGradeDto {
private Integer studentId;
private Integer subYear;
private Integer semester;
private Integer sumGrades; //이수 해야할 학점
private Integer myGrades;	//내가 이수한 학점
private float average;

public String average() {
	String result = String.format("%.2f", average);
	return result;
}

}
