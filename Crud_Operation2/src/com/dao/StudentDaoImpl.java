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
		public void addUser(StudentBean studentBean) {
			/*add user*/
			try {
				con=Dbutil. getMysqlConnection() ;
				ps=con.prepareStatement("insert into student_tbl values(?,?,?)");
				ps.setString(1 , studentBean.getSid());
				ps.setString(2 , studentBean.getSname());
				ps.setString(3 , studentBean.getEmail());
				
				int i=ps.executeUpdate();
				}catch(SQLException e) {
				e.printStackTrace();
				}
				finally {  
			     Dbutil.cleanUp(con, ps);
				}
				
				
			}

	@Override
	public List<StudentBean> getAllUser() {
		List<StudentBean> student=new ArrayList<StudentBean>();
		ResultSet rs=null;
		try {
			con=Dbutil.getMysqlConnection();
		ps=con.prepareStatement("select * from student_tbl");
		rs=ps.executeQuery();

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
		Dbutil.cleanUp(con, ps);
		}
		return student;
		}
	}
	

