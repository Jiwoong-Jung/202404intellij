package com.green.university.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.green.university.dto.response.PrincipalDto;
import com.green.university.handler.exception.UnAuthorizedException;
import com.green.university.utils.Define;

/**
 * 세션값 검사해서 userRole이 staff인지 확인하는 인터셉터
 * 
 * @author 김지현
 */
@Component
public class UserRoleAuthIntercepterForStaff implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		if (!"staff".equals(principal.getUserRole())) {
			throw new UnAuthorizedException("접근 권한이 없습니다. 관리자 전용 페이지", HttpStatus.UNAUTHORIZED, "/");
		}
		return true;
	}

}