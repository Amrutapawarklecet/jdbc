<%@page import="com.service.StudentServiceImpl"%>
<%@page import="com.service.StudentService"%>
<%@page import="com.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	StudentService service=new StudentServiceImpl();
	service.updateUser(studentbean);
	response.sendRedirect("AlldataServlet");
%>

</body>
</html>