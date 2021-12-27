package com.dao;

import java.util.List;

import com.bean.StudentBean;

public interface StudentDao {
   
public void addUser(StudentBean studentBean);
public List<StudentBean> getAllUser();
}