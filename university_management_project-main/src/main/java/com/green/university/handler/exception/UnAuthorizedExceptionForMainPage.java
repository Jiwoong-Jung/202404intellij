package com.green.university.handler.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UnAuthorizedExceptionForMainPage extends RuntimeException {

	private HttpStatus status;
	private String path;

	public UnAuthorizedExceptionForMainPage(HttpStatus status, String path) {
		
		this.status = status;
		this.path = path;
		
	}
	
}
