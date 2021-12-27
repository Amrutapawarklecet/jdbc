<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:Lightblue">
<h1>Welcome to User Portal</h1>
<hr/>
<h2>Add User</h2>
  <form action="/AddStudentServlet">
  <input type="text" name="sid" placeholder="Student Id"/><br>
  <input type="text" name="sname" placeholder="Student Name"/><br>
  <input type="text" name="email" placeholder="Email"/><br>
  <input type="submit" value="Add User"/>
  </form>
</body>
</html>