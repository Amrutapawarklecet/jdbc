package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentBean;
import com.util.DbUtil;

public class StudentDaoImpl implements StudentDao{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	

	@Override
	public int adduser(StudentBean studentbean) {
		int i=-1;
		try
		{
			con=DbUtil.getMySQLConnection();
			ps=con.prepareStatement("insert into student_tbl values(?,?,?)");
			ps.setString(1, studentbean.getSid());
			ps.setString(2,studentbean.getSname());
			ps.setString(3,studentbean.getEmail());
			
		    i=ps.executeUpdate();
			System.out.println("From Dao :"+i);
			
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			//System.out.println("I :"+i);
			DbUtil.cleanup(con, ps);
		}
		return i;
		
		
		
	}

	@Override
	public List<StudentBean> getalluser() {
		List<StudentBean> students=new ArrayList<StudentBean>();
		try
		{
			con=DbUtil.getMySQLConnection();
			ps=con.prepareStatement("select * from student_tbl");
			rs=ps.executeQuery();
			while(rs.next())
			{
				StudentBean studentbean=new StudentBean();
				studentbean.setSid(rs.getString(1));
				studentbean.setSname(rs.getString(2));
				studentbean.setEmail(rs.getString(3));
				students.add(studentbean);
			}
			
			
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			
			DbUtil.cleanup(rs, con, ps);
		}
		
		
		return students;
	}

	@Override
	public void deleteuser(String sid) {
		try
		{
			con=DbUtil.getMySQLConnection();
			ps=con.prepareStatement("delete from student_tbl where sid=?");
			ps.setString(1, sid);
			ps.executeUpdate();
			
			
			
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			
			DbUtil.cleanup(con, ps);
		}
		
		
		
	}

	@Override
	public StudentBean getUserBysid(String sid) {
		StudentBean studentbean=new StudentBean();
		try
		{
			
			con=DbUtil.getMySQLConnection();
			ps=con.prepareStatement("select * from student_tbl where sid=?");
			ps.setString(1, sid);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				
				studentbean.setSid(rs.getString(1));
				studentbean.setSname(rs.getString(2));
				studentbean.setEmail(rs.getString(3));
				
			}
			
			
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			
			DbUtil.cleanup(rs, con, ps);
		}
		
		
		return studentbean;
		
		
	}

	@Override
	public void updateuser(StudentBean studentbean) {
		int rowupdated;
		
		try {
		con=DbUtil.getMySQLConnection();
		ps=con.prepareStatement("update student_tbl set sname=?, email=? where sid=?");
		ps.setString(1,studentbean.getSname());
		ps.setString(2,studentbean.getEmail());
		ps.setString(3,studentbean.getSid());
		rowupdated=ps.executeUpdate();
		}
		
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			
			DbUtil.cleanup(rs, con, ps);
		}
		
		
		
	}

	

}
