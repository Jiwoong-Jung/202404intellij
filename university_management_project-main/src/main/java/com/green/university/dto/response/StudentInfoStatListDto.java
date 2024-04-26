package com.green.university.dto.response;

import lombok.Data;

/**
 * 학생의 my info 탭에 표시할
 * 학적변동 리스트 받을 dto
 * @author 김지현
 *
 */
@Data
public class StudentInfoStatListDto {

	// 변동 날짜
	private String fromDate;
	// 변동 구분
	private String status;
	// 변동 세부 구분
	private String detail;
	// 승인 여부
	private String adopt;
	// 복학 예정 년도
	private Integer toYear;
	// 복학 예정 학기
	private Integer toSemester;
	
}
