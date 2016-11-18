package com.bit2016.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler /*HandlerMethod*/)
		throws Exception {
		
		//1. handler 종류 
		if( handler instanceof HandlerMethod == false ){
			return true;
		}
		
		//2. @Auth 가  붙혀 있는 없는지...
		Auth auth = ((HandlerMethod)handler).getMethodAnnotation( Auth.class );
		if( auth == null ) { // 접근 제어가 필요 없는 Handler
			return true;
		}
		
		//3. 접근 제어
		HttpSession session = request.getSession();
		if( session == null ) {
			response.sendRedirect( request.getContextPath() + SecurityConfig.SECURITY_LOGIN_PAGE );
			return false;
		}
		
		SecurityUser securityUser = (SecurityUser)session.getAttribute( SecurityConfig.SECURITY_SESSION_SCOPE_NAME );
		if( securityUser == null ) {
			response.sendRedirect( request.getContextPath() + SecurityConfig.SECURITY_LOGIN_PAGE );
				return false;
		}

		//4. 인증된 사용자
		return true;
	}
}