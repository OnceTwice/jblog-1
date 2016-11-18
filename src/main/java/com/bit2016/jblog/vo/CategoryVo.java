package com.bit2016.jblog.vo;

public class CategoryVo {
	private Long no;
	private Long userNo;
	private String name;
	private String description;
	private String regDate;
	
	public Long getNo() {
		return no;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", userNo=" + userNo + ", name=" + name + ", description=" + description
				+ ", regDate=" + regDate + "]";
	}
}