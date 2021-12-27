package com.service;

import java.util.List;

import com.bean.StudentBean;

public interface StudentService {
	public void addUser(StudentBean studentBean);
	public List<StudentBean> getAllUser();
}

