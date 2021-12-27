package com.service;

import java.util.List;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;



public class StudentServiceImpl implements StudentService{
  StudentDao sDao=null;
	@Override
	public void addUser(StudentBean studentBean) {
		sDao = new StudentDaoImpl();
		sDao.addUser(studentBean);
	}

	@Override
	public List<StudentBean> getAllUser() {
	   sDao = new StudentDaoImpl();
		return sDao.getAllUser();
		
	}

}
