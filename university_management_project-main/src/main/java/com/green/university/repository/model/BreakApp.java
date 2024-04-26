package com.green.university.repository.model;

import java.sql.Date;

import com.green.university.utils.DateUtil;

import lombok.Data;

/**
 * @author 서영
 * 휴학 신청 내역
 */
@Data
public class BreakApp {

	private Integer id;
	private Integer studentId;
	private Integer studentGrade;
	private Integer fromYear;
	private Integer fromSemester;
	private Integer toYear;
	private Integer toSemester;
	private String type;
	private Date appDate;
	private String status;
	
	public String appDateFormat() {
		return DateUtil.dateFormat(appDate);
	}
	
}
