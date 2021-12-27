<%@page import="com.service.StudentServiceImp"%>
<%@page import="com.service.StudentService"%>
<%@page import="com.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String sid=request.getParameter("sid");
	String sname=request.getParameter("sname");
	String email=request.getParameter("email");
	
	StudentBean studentbean=new StudentBean(sid,sname,email);
	StudentService service=new StudentServiceImp();
	service.updateuser(studentbean);
	response.sendRedirect("AlldataServlet");
%>

</body>
</html>