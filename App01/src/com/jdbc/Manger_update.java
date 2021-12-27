//Insert
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Manger_update {
  
	 public static void main(String[] args) {
		 Scanner scan=new Scanner(System.in);
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
			 System.out.println("Enter book title");
			String title=scan.next();
			 ps=con.prepareStatement("update book_table set title=? where title='Spring'");
			 ps.setString(1,title);
			 int rs=ps.executeUpdate();
			 if(rs>0) {
				 System.out.println("Update Sucessfully");
			 }
			 else {
				 System.out.println("Interrupted");
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
			 }
				 catch(SQLException sqle) {
					 sqle.printStackTrace();
				 }
			 }
		 System.out.println("Done");
			
		 
		 
		 
		 //4.Execute Query
	 }
}
