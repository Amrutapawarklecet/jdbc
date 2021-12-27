package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbutil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		}
		catch(ClassNotFoundException e) {
		e.printStackTrace();
		}
		}
		public static Connection getMysqlConnection() {
		Connection con=null;
		try {
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","Redmi@123");
		}
		catch(SQLException e) {
		e.printStackTrace();
		}
		return con;
	}
			public static void cleanUp(Connection con,PreparedStatement ps) {
			try {
				if(ps!=null)
				ps.close();
				if(con!=null)
				con.close();

				}catch(SQLException e) {
				e.printStackTrace();
				}

			}
			public static void cleanUp(Connection con,PreparedStatement ps,ResultSet rs) {
				try {
				if (rs!=null)
				rs.close();
				if(ps!=null)
				ps.close();
				if(con!=null)
				con.close();

				}catch(SQLException e) {
				e.printStackTrace();
				}
				}
}
			


				
				
			


		


