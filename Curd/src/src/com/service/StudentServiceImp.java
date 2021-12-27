package com.service;

import java.util.List;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

public class StudentServiceImp implements StudentService {

	
	public int adduser(StudentBean studentbean) {
		StudentDao sdao=new StudentDaoImpl();
		return sdao.adduser(studentbean);
		
	}

	
	public List<StudentBean> getalluser() {
		StudentDao sdao=new StudentDaoImpl();
		return sdao.getalluser();
	}


	
	public void deleteuser(String sid) {
		StudentDao sdao=new StudentDaoImpl();
		sdao.deleteuser(sid);
		
	}


	//@Override
	public StudentBean getUserBysid(String sid) {
		StudentDao sdao=new StudentDaoImpl();
		return sdao.getUserBysid(sid) ;
	}


	@Override
	public void updateuser(StudentBean studentbean ) {
		StudentDao sdao=new StudentDaoImpl();
		sdao.updateuser(studentbean);
		
		
	}


	
	
}
