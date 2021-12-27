package com.service;

import java.util.List;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;




public class StudentServiceImpl implements StudentService{
  StudentDao sDao=null;
	@Override
	public int addUser(StudentBean studentBean) {
		sDao = new StudentDaoImpl();
		return sDao.addUser(studentBean);
	}

	@Override
	public void updateUser(StudentBean studentBean) {
		
		sDao = new StudentDaoImpl();
       sDao.updateUser(studentBean);

	}

	@Override
	public void deleteUser(String sid) {
		
		sDao = new StudentDaoImpl();
		 sDao.deleteUser(sid);
	}
	
	
	@Override
		public StudentBean getUserBysid(String sid) {
			StudentDao sdao=new StudentDaoImpl();
			return sdao.getUserBysid(sid) ;
		}
	
	@Override
	public List<StudentBean> getAllUser() {
	   sDao = new StudentDaoImpl();
		return sDao.getAllUser();
		
	}

}
