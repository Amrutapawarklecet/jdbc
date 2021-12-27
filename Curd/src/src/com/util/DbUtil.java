package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class DbUtil {
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getMySQLConnection()
	{
		Connection con=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","Mko0!qaZ");
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static void cleanup(Connection con,PreparedStatement ps)
	{
		try
		{
			if(ps!=null)
			{
				ps.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	public static void cleanup( ResultSet rs,Connection con,PreparedStatement ps)
	{
		try
		{
			if(rs!=null)
			{
				rs.close();
			}
			if(ps!=null)
			{
				ps.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}


}
