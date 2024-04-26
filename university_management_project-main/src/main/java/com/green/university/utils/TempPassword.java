package com.green.university.utils;

/**
 * 임시 비밀번호 생성기
 * @author 김지현
 *
 */
public class TempPassword {
	
	private String password;
	
	public String returnTempPassword() {
		int tempPassword = 0;
		while(tempPassword < 100000) {
		 tempPassword = (int)(Math.random()*1000000);
		}
		password = tempPassword + "";
		System.out.println(password);
		return password;
	}

}
