package com.dao;

import java.util.List;

import com.beans.UserBean;

public interface UserDao {
	public void addUser(UserBean userBean);
	public void updateUser(int aadharNo, UserBean userBean);
	public void deleteUser(int aadharNo);
	public UserBean getUserByaadharno(int aadharNo);
	public List<UserBean> getAllUser();
	
}
