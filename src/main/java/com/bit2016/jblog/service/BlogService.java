package com.bit2016.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.repository.PostDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.PostVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Map<String, Object> getAll(String id, Long categoryNo, Long postNo ) {
		
		BlogVo blogVo = getBlogInfo( id );
		PostVo postVo = viewPost( postNo );
		List<PostVo> listPostVo = getPostList( categoryNo );
		List<CategoryVo> listCategoryVo = getCategoryList( id );
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put( "blogId", id );
		map.put( "blog", blogVo );
		map.put( "post", postVo );
		map.put( "postList", listPostVo );
		map.put( "categoryList", listCategoryVo );
		map.put( "currentPost", postNo );
		map.put( "currentCategory", categoryNo );

		return map;
	}
	
	/*
	 *  blog 정보 관련 service
	 *   
	 */
	public BlogVo getBlogInfo( String id ) {
		return blogDao.get( id );
	}

	public void saveBolgInfo() {
	}
	
	/*
	 *  post 관련 service
	 *   
	 */
	public PostVo viewPost( Long postNo ) {
		return null;
	}
	
	public List<PostVo> getPostList( Long categoryNo ){
		return null;
	}
	
	public void savePost( PostVo postVo ) {
	}

	/*
	 * category 정보 관련 서비스
	 * 
	 */
	public List<CategoryVo> getCategoryList( String id ){
		return categoryDao.getList( id );
	}
	
}