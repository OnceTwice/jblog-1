package com.bit2016.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler/*HandlerMethod*/)
		throws Exception {
		
		String userName = request.getParameter( SecurityConfig.SECURITY_USERNAME_PARAMETER );
		String password = request.getParameter( SecurityConfig.SECURITY_PASSWORD_PARAMETER );
		
		// Web Application Context 받아오기
		ApplicationContext ac =
			WebApplicationContextUtils.getWebApplicationContext( request.getServletContext() );
		// Container 안에 있는 UserService Bean(객체) 받아오기
		SecurityUserService securityUserService = ac.getBean( SecurityUserService.class );
		
		// 데이터베이스에서 해당  SecurityUser 받아오기 
		SecurityUser securityUser = securityUserService.loadSecuryUserByUserName( userName, password );
		
		// userName과  password가 일치하지 않는 경우
		if( securityUser == null ) {
			response.sendRedirect( request.getContextPath() + SecurityConfig.SECURITY_AUTH_FAIL_URL );
			return false;
		}
		
		// 인증 처리
		HttpSession session = request.getSession( true );
		session.setAttribute( SecurityConfig.SECURITY_SESSION_SCOPE_NAME, securityUser );
		
		//리다이렉트
		response.sendRedirect( request.getContextPath() );
		
		return false;
	}

}
