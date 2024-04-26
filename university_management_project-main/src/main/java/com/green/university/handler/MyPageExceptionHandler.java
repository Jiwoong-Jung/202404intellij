package com.green.university.handler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * view 렌더링 위해 ModelAndView
 * 객체를 반환하도록 기본 설정 되어있다.
 * 예외 페이지를 리턴하도록 활용 예정
 * */
@ControllerAdvice
public class MyPageExceptionHandler implements ErrorController{
	
	private static final String ERROR_PATH = "/error";
	
	@GetMapping(ERROR_PATH)
	public String error(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		// status = 404
		if(status != null && Integer.parseInt(status.toString()) == HttpStatus.NOT_FOUND.value()) {
			return "error/errorPage";
		}
		return "/";
	}
	
//	// 사용자 정의 클래스 활용
//	@ExceptionHandler(CustomPageException.class)
//	public ModelAndView handleRuntimePageException(CustomPageException e) {
//		System.out.println("dfdf~~");
//		// ModelAndView 활용 방법
//		ModelAndView modelAndView = new ModelAndView("/error/errorPage");
//		modelAndView.addObject("statusCode", HttpStatus.NOT_FOUND.value());
//		modelAndView.addObject("message", e.getMessage());
//		return modelAndView;
//	}
	
//	@ExceptionHandler(NoHandlerFoundException.class)
//	public String notFoundException(NoHandlerFoundException e) {
//		StringBuffer sb = new StringBuffer();
//		e.getMessage();
//		sb.append("<script>");
//		sb.append("location.href='/error/';");
//		sb.append("</script>");
//		return sb.toString();
//	}
	
	
//	/**
//	 * 마이바티스 제약 오류
//	 * @param e
//	 * @return 에러페이지
//	 */
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public ModelAndView dataIntegrityViolationException(DataIntegrityViolationException e) {
//		ModelAndView modelAndView = new ModelAndView("errorPage");
//		modelAndView.addObject("statusCode", HttpStatus.NOT_FOUND.value());
//		modelAndView.addObject("message", e.getMessage());
//		return modelAndView;
//	}
	
	
	
	
}
