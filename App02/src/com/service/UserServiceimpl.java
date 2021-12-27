package com.service;

import java.util.List;

import com.beans.UserBean;
import com.dao.UserDao;
import com.dao.UserDaoimpl;

public class UserServiceimpl implements UserService{
	UserDao userDao=null;

	@Override
	public void addUser(UserBean userBean) {
		// TODO Auto-generated method stub
		userDao = new UserDaoimpl();
		userDao.addUser(userBean);
	}

	@Override
	public void updateUser(int aadharNo, UserBean userBean) {
		
		userDao = new UserDaoimpl();
		userDao.updateUser(aadharNo, userBean);


	}

	@Override
	public void deleteUser(int aadharNo) {
		
		userDao = new UserDaoimpl();
		userDao.deleteUser(aadharNo);
	}
	@Override
	public UserBean getUserByaadharno(int aadharNo) {
		userDao = new UserDaoimpl();
		return userDao.getUserByaadharno(aadharNo);
		
	}

	@Override
	public List<UserBean> getAllUser() {
		userDao = new UserDaoimpl();
		return userDao.getAllUser();


	
	}
	
}