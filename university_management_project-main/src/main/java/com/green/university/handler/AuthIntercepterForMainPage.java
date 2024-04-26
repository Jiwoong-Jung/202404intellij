package com.green.university.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.green.university.handler.exception.UnAuthorizedException;
import com.green.university.handler.exception.UnAuthorizedExceptionForMainPage;
import com.green.university.utils.Define;

/**
 * 로그인 되어있는지 세션 검사하는 intercepter
 * @author 김지현
 */
@Component
public class AuthIntercepterForMainPage implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute(Define.PRINCIPAL) == null) {
			throw new UnAuthorizedExceptionForMainPage(HttpStatus.UNAUTHORIZED, "/login");
			// return false;
		}
		return true;
	}



}