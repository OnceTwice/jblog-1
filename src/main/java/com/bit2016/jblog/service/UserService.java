package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.exception.UserServiceException;
import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.SecurityUser;
import com.bit2016.security.SecurityUserService;

@Service
public class UserService implements SecurityUserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;	
	
	public void join( UserVo userVo ) throws UserServiceException {
		boolean result = false;
		
		//1. 회원정보 저장
		result = userDao.insert( userVo ) == 1;
		if( result == false ) {
			throw new UserServiceException( "fail to save user's singup information" );
		}
		Long userNo = userVo.getNo();
		
		//2. 블로그 생성
		BlogVo blogVo = new BlogVo();
		blogVo.setUserNo(userNo);
		blogVo.setTitle( userVo.getName() + "의 jblog" );
		blogVo.setLogo( "default-logo.jpg" );
		
		result = blogDao.insert( blogVo ) == 1;
		if( result == false ) {
			throw new UserServiceException( "fail to create user's blog" );
		}
		
		//3. 기본 카테고리 등록
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setName( "미분류" );
		categoryVo.setUserNo(userNo);
		categoryVo.setDescription( "" );
		result = categoryDao.insert( categoryVo ) == 1;
		if( result == false ) {
			throw new UserServiceException( "fail to register default category of blog" );
		}
	}
	
	public boolean idExists( String id ){
		return userDao.get( id ) != null;
	}

	@Override
	public SecurityUser loadSecuryUserByUserName(String userName, String password) {
		return userDao.get( new UserVo( userName, password ) );
	}
}