package com.bit2016.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthLogoutInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if( session != null ) {
			session.removeAttribute( SecurityConfig.SECURITY_SESSION_SCOPE_NAME );
			session.invalidate();
		}
		
		response.sendRedirect( request.getContextPath() );
		return false;
	}

}
