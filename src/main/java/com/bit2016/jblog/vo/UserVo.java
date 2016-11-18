package com.bit2016.jblog.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.bit2016.security.SecurityUser;

public class UserVo implements SecurityUser {
	private Long no;
	
	@Pattern( regexp="^[0-9a-z]{3,12}$" )
	private String id;
	
	@Pattern( regexp="^[0-9a-z]{4,10}$" )
	private String password;
	
	@Length( min=2, max=10 )
	private String name;
	
	private String joinDate;
	
	public UserVo() {
	}

	public UserVo( String id, String password ) {
		this.id = id;
		this.password = password;
	}
	
	public Long getNo() {
		return no;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", joinDate="
				+ joinDate + "]";
	}
}