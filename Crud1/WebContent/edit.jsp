<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <h1>Edit User</h1><hr>
	<form action="ManagerEdit.jsp">
	<input type="text" name="sid" value="<c:out value="${studentbean.getSid()}"></c:out>"><br>
	<input type="text" name="sname" value="<c:out value="${studentbean.getSname()}"></c:out>"><br>
	<input type="text" name="email" value="<c:out value="${studentbean.getEmail()}"></c:out>"><br>
	<input type="submit" value="Edit User">
	</form>
</body>
</html>