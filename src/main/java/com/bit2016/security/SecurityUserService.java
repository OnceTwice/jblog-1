package com.bit2016.security;

public interface SecurityUserService {
	SecurityUser loadSecuryUserByUserName( String userName, String password );
}
