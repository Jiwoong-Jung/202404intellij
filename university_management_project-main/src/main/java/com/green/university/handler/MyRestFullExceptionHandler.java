package com.green.university.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.green.university.handler.exception.CustomPathException;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.handler.exception.UnAuthorizedException;
import com.green.university.handler.exception.UnAuthorizedExceptionForMainPage;

@RestControllerAdvice // IoC 대상 + AoP 기반
public class MyRestFullExceptionHandler {

	@ExceptionHandler(Exception.class)
	public void exception(Exception e) {
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
	}
	
//	@ExceptionHandler(BindException.class)
//	public String bindingException(BindException e) {
//		System.out.println("111111111111111111111");
//		StringBuilder sb = new StringBuilder();
//		BindingResult bindingResult = e.getBindingResult();
//		sb.append("<script>");
//		sb.append("alert('"); 
//		for (FieldError fieldError : bindingResult.getFieldErrors()) {
//			sb.append("[");
//			sb.append(fieldError.getField());
//			sb.append("](은)는 ");
//			sb.append(fieldError.getDefaultMessage());
//			sb.append(" 입력된 값: [");
//			sb.append(fieldError.getRejectedValue());
//			sb.append("]");
//        }
//		sb.append("');"); 
//		sb.append("history.back();");
//		sb.append("</script>");
//		
//		return sb.toString();
//	}

	
	// 사용자 정의 예외 클래스 활용
	@ExceptionHandler(CustomRestfullException.class)
	public String basicException(CustomRestfullException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+ e.getMessage() +"');"); 
		sb.append("history.back();");
		sb.append("</script>");
		return sb.toString();
	}
	
	@ExceptionHandler(UnAuthorizedException.class)
	public String unAuthorizedException(UnAuthorizedException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+ e.getMessage() +"');"); 
		sb.append("location.href='" + e.getPath() + "';");
		sb.append("</script>");
		return sb.toString();
	}
	
	@ExceptionHandler(UnAuthorizedExceptionForMainPage.class)
	public String unAuthorizedException(UnAuthorizedExceptionForMainPage e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("location.href='" + e.getPath() + "';");
		sb.append("</script>");
		return sb.toString();
	}
	
	/**
	 * @author 서영
	 * 경로를 지정해서 던지는 예외 클래스 활용
	 */
	@ExceptionHandler(CustomPathException.class)
	public String customPathException(CustomPathException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+ e.getMessage() +"');");
		sb.append("location.href='" + e.getPath() + "';");
		sb.append("</script>");
		return sb.toString();
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String notFoundException(NoHandlerFoundException e) {
		System.out.println(e.getMessage());
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("location.href='/error/';");
		sb.append("</script>");
		return sb.toString();
	}
	
}
