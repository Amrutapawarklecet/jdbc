package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.StudentBean;
import com.util.Dbutil;

public class StudentDaoImpl implements StudentDao {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		@Override	
		public int addUser(StudentBean studentBean) {
			int i=-1;
			/*add user*/
			
			try {
				con=Dbutil. getMysqlConnection() ;
				ps=con.prepareStatement("insert into student_tbl values(?,?,?)");
				ps.setString(1 , studentBean.getSid());
				ps.setString(2 , studentBean.getSname());
				ps.setString(3 , studentBean.getEmail());
				
				 i=ps.executeUpdate();
				//System.out.println("I:"+i);
				}catch(SQLException e) {
				e.printStackTrace();
				}
				finally {  
				
			     Dbutil.cleanUp(con, ps);
				}
				return i;
				
			}
		
		/*update user*/
		@Override
		public void updateUser(StudentBean studentBean) {
			int rowupdated;
			try {
				con=Dbutil.getMysqlConnection();

				ps=con.prepareStatement("update student_tbl set sname=?,email=? where sid=?");
				ps.setString(1, studentBean.getSid());
				ps.setString(2, studentBean.getSname());
				ps.setString(3,studentBean.getEmail());
                

				rowupdated=ps.executeUpdate();
				}catch (SQLException sqle) {
				sqle.printStackTrace();
				}
				finally {
					Dbutil.cleanUp(con, ps,rs);
				}
                   
				}
		
		
		

	//delete user
		@Override
		public void deleteUser(String sid) {
			try
	        {
	            con=Dbutil.getMysqlConnection();
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
	           
	        	Dbutil.cleanUp(con, ps);
	        }
	       
		}
		
		@Override
		public StudentBean getUserBysid(String sid) {
			StudentBean studentbean=new StudentBean();
			try
			{
				
				con=Dbutil.getMysqlConnection();
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
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				
				Dbutil.cleanUp(con, ps,rs);
			}
			
			
			return studentbean;
			
			
		}
	
//get all user
	@Override
	public List<StudentBean> getAllUser() {
		List<StudentBean> student=new ArrayList<StudentBean>();
		ResultSet rs=null;
		try {
			con=Dbutil.getMysqlConnection();
		ps=con.prepareStatement("select * from student_tbl");
		rs=ps.executeQuery();
		while (rs.next()) {
		StudentBean studentbean=new StudentBean();
		studentbean.setSid(rs.getString(1));
		studentbean.setSname(rs.getString(2));
		studentbean.setEmail(rs.getString(3));
		student.add(studentbean);
		}

		}catch (SQLException sqle) {
		sqle.printStackTrace();
		}
		finally {
		Dbutil.cleanUp(con, ps,rs);
		}
		return student;
		}
	}
	

