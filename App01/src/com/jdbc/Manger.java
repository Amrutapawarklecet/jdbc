//Insert
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Manger {
  
	 public static void main(String[] args) {
		 PreparedStatement ps=null;
		 Connection con=null;
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
			 ps=con.prepareStatement("insert into book_table values(?,?,?,?)");
			 ps.setInt(1,2);
			 ps.setString(2, "Easy Spring");
			 ps.setString(3, "Vignesh");
			 ps.setInt(4, 1200);
			 int i=ps.executeUpdate();
			 System.out.println(i);
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
			 }
				 catch(SQLException sqle) {
					 sqle.printStackTrace();
				 }
			 }
		 System.out.println("Done");
			
		 
		 
		 
		 //4.Execute Query
	 }
}
