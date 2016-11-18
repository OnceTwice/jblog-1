package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insert( BlogVo blogVo ) {
		return sqlSession.insert( "blog.insert" , blogVo );
	}
	
	public BlogVo get( String id ) {
		return sqlSession.selectOne( "blog.getById" , id );
	}
}
