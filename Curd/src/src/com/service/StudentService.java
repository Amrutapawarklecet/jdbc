package com.service;

import java.util.List;

import com.bean.StudentBean;

public interface StudentService {
	public int addUser(StudentBean studentBean);
	public void updateUser(StudentBean studentbean);
	public void deleteUser(String sid);
	public StudentBean getUserBysid(String sid);
	public List<StudentBean> getAllUser();

}
