<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	table,td{
	border:1px solid black;
	border-collapse:collapse;
	
	}
	table.center{
	margin-left:auto;
	margin-right:auto;
	}

</style>
</head>
<body  style="background-color:powderblue;">
<h1>Welcome to User portal</h1>
<hr/>


<h2>Add User</h2>


<form action="AddStudentServlet">
	<input type="text" name="sid" placeholder="Student id" / ><br>
	<input type="text" name="sname" placeholder="Student Name"/ ><br>
	<input type="text" name="email" placeholder="Email" /><br>
	<input type="submit" value="Add User" >

</form>


<!-- Read the Student List -->

		<table class="center">
			<tr>
				
				<td>Student Id</td>
				<td>Student Name</td>
				<td>Student Email</td>
				<td>Edit</td>
				<td>Delete</td>
			
	<c:forEach var="p" items="${list}">		

	<tr>
		<td><c:out value="${p.sid}"></c:out></td>
		<td><c:out value="${p.sname}"></c:out></td>
		<td><c:out value="${p.email}"></c:out> </td>
		<td><a href="EditServlet?sid=${p.sid}">Edit</a></td>
		<td><a href="DeleteStudentServlet?sid=${p.sid}">Delete</a></td>
	</tr>
    </c:forEach>

		
		</table>



</body>
</html>