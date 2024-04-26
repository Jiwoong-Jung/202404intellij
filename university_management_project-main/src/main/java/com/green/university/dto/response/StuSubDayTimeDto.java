package com.green.university.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StuSubDayTimeDto {

	private Integer subjectId;
	private String subjectName;
	private String subDay;
	private Integer startTime;
	private Integer endTime;
	
	// startTime ~ endTime을 정수형 배열로 생성
	public List<Integer> timeList() {
		List<Integer> resultList = new ArrayList<>();
		
		for (int i = startTime; i <= endTime; i++) {
			resultList.add(i);
		}
		return resultList;
	}
}
