package com.dao;

import java.util.List;

import com.bean.StudentBean;

public interface StudentDao {
	
	public int adduser(StudentBean studentbean);
	public void deleteuser(String sid);
	public List<StudentBean> getalluser();
	public StudentBean getUserBysid(String sid);
	public void updateuser(StudentBean studentbean);
	

}
