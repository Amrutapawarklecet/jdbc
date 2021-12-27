package com.beans;

public class UserBean {
	private int aadharno;
	private String username;
	private int usertype;
	private String password;
	
	
	public UserBean() {
		super();
		
	}
	public UserBean(int aadharno, String username, int usertype, String password) {
		super();
		this.aadharno = aadharno;
		this.username = username;
		this.usertype = usertype;
		this.password = password;
	}
	public int getAadharno() {
		return aadharno;
	}
	public void setAadharno(int aadharno) {
		this.aadharno = aadharno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}