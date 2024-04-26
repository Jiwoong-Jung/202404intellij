package com.green.university.utils;

import java.text.DecimalFormat;

// 숫자형 타입 관련 유틸
public class NumberUtil {
	
	/**
	 * @author 서영
	 * 숫자를 1,000,000와 같은 형태로 변환함
	 * 메서드 오버로딩
	 */
	public static String numberFormat(Long number) {
		
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(number);
	}
	
	public static String numberFormat(Integer number) {
		
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(number);
	}
	
}
