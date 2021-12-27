package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.UserBean;
import com.util.Dbutil;

public class UserDaoimpl implements UserDao {

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	

	@Override	public void addUser(UserBean userBean) {
		/*add user*/
		try {
			con=Dbutil. getMysqlConnection() ;
			ps=con.prepareStatement("insert into user_tb values(?,?,?,?)");
			ps.setInt(1 , userBean.getAadharno());
			ps.setString(2 ,  userBean.getUsername());
			ps.setInt(3 ,  userBean.getUsertype());
			ps.setString(4 ,  userBean.getPassword());
			int i=ps.executeUpdate();
			}catch(SQLException e) {
			e.printStackTrace();
			}
			finally {  
		     Dbutil.cleanUp(con, ps);
			}
			
			
		}
	

/*update user*/
	@Override
	public void updateUser(int aadharNo, UserBean userBean) {
		try {
			con=Dbutil.getMysqlConnection();

			ps=con.prepareStatement("update user_tb set username=? where aadharno=?");
			ps.setInt(2, userBean.getAadharno());
			ps.setString(1, userBean.getUsername());


			int i=ps.executeUpdate();
			}catch (SQLException sqle) {
			sqle.printStackTrace();
			}
			finally {
			Dbutil.cleanUp(con, ps);
			}

			}




	

//delete user
	@Override
	public void deleteUser(int aadharNo) {
		// TODO Auto-generated method stub
		
	
		try {
			con=Dbutil.getMysqlConnection();

			ps=con.prepareStatement("delete from user_tb where aadharno=?");
			ps.setInt(1, aadharNo);



			int i=ps.executeUpdate();
			}catch (SQLException sqle) {
			sqle.printStackTrace();
			}
			finally {
			Dbutil.cleanUp(con, ps);
			}

			}


//get all user
	@Override
	public UserBean getUserByaadharno(int aadharNo) {
		UserBean userbean=new UserBean();
		try {

			con=Dbutil.getMysqlConnection();

		ps=con.prepareStatement("select * from user_tb where aadharno=?");
		ps.setInt(1, aadharNo);

		rs=ps.executeQuery();
		while (rs.next()) {
		userbean.setAadharno(rs.getInt(1));
		userbean.setUsername(rs.getString(2));
		userbean.setUsertype(rs.getInt(3));
		userbean.setPassword(rs.getString(4));
		}

		}catch (SQLException sqle) {
		sqle.printStackTrace();
		}
		finally {
		Dbutil.cleanUp(con, ps);
		}

		return userbean;
		}

	@Override
	public List<UserBean> getAllUser() {
		   
			List<UserBean> user=new ArrayList<UserBean>();
			ResultSet rs=null;
			try {
				con=Dbutil.getMysqlConnection();
			ps=con.prepareStatement("select * from user_tb");
			rs=ps.executeQuery();

			rs=ps.executeQuery();
			while (rs.next()) {
			UserBean userbean=new UserBean();
			userbean.setAadharno(rs.getInt(1));
			userbean.setUsername(rs.getString(2));
			userbean.setUsertype(rs.getInt(3));
			userbean.setPassword(rs.getString(4));
			user.add(userbean);
			}

			}catch (SQLException sqle) {
			sqle.printStackTrace();
			}
			finally {
			Dbutil.cleanUp(con, ps);
			}
			return user;
			}
}