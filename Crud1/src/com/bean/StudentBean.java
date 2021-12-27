package com.bean;

public class StudentBean {

	private String sid;
	private String sname;
	private String email;
	
	
	public StudentBean() {
		super();
		
	}
	public StudentBean(String sid,String sname,String email) {
		super();
		this.sid=sid;
		this.sname=sname;
		this.email=email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public String getSid() {
		return sid;
	}
	public String getSname() {
		return sname;
	}
	
	
	
}


