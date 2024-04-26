package com.green.university.utils;

import java.sql.Date;

// 날짜형 타입 관련 유틸
public class DateUtil {

	/**
	 * @author 서영
	 * 날짜를 yyyy년 mm월 dd일과 같은 형태로 변환함
	 */
	public static String dateFormat(Date date) {
		
		String result = String.format("%tY년 %tm월 %td일", date, date, date);
		
		return result;
	}
	
	
}
