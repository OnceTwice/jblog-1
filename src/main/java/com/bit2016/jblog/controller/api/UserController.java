package com.bit2016.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.jblog.dto.JSONResult;
import com.bit2016.jblog.service.UserService;

@Controller( "userAPIController" )
@RequestMapping( "/api/user" )
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping( "/checkid" )
	public Object checkId( @RequestParam( value="id", required=true, defaultValue="" ) String id ) {
		return JSONResult.success( userService.idExists( id ) ? "exist" : "not exist" );
	}
}
