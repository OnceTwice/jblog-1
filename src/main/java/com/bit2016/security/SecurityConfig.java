package com.bit2016.security;

public class SecurityConfig {
	public static final String SECURITY_SESSION_SCOPE_NAME = "authUser";
	public static final String SECURITY_USERNAME_PARAMETER = "id";
	public static final String SECURITY_PASSWORD_PARAMETER = "password";
	
	public static final String SECURITY_LOGIN_PAGE = "/user/loginform";
	public static final String SECURITY_LOGIN_PROCESSION_URL = "/user/login";
	public static final String SECURITY_DEFAULT_TARGET_URL = "/";
	public static final String SECURITY_AUTH_FAIL_URL = "/user/loginform?result=fail";
	
	
}
