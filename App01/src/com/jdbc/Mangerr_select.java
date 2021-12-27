//Insert
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mangerr_select {
  
	 public static void main(String[] args) {
		 PreparedStatement ps=null;
		 Connection con=null;
		 ResultSet rs=null;
		//1.load driver
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
		 }
		 catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 //2.Establish Connection
		 try {
			 String url="jdbc:mysql://localhost:3306/java";
			 String username="root";
			 String password="Redmi@123";
			 con=DriverManager.getConnection(url,username,password);
			 if(con!=null) {
				 System.out.println("Connection established");
				 
			 }
			 else {
				 System.out.println("Error occured while establishing the connection");
				 
			 }
			//3.Create Statement
			// ps=con.prepareStatement("select * from book_table");
			 ps=con.prepareStatement("select * from book_table where sno=?");
			 ps.setInt(1, 2);
			 rs=ps.executeQuery(); 
			 
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getInt(4));
				
				 
			 }
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
		 finally {
			 try {
				 if(ps!=null) {
					 ps.close();
				 }
				 if(con!=null) {
					 con.close();
				 }
				 if(rs!=null) {
					 rs.close();
				 }
			 }
				 catch(SQLException sqle) {
					 sqle.printStackTrace();
				 }
			 }
		 System.out.println("Done");
			
		 
		 
		 
		 //4.Execute Query
	 }
}
