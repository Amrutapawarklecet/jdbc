<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("uname");
    String dobirth = request.getParameter("birthdate");
    String age = request.getParameter("age");
    String bgroup = request.getParameter("bgroup");
    String address = request.getParameter("address");
    String mnumber = request.getParameter("mnumber");
    String email = request.getParameter("email");
    String gender = request.getParameter("sex");
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bbms",
            "root", "Redmi@123");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into donor(user_name, date_of_birth, age, blood_group,address,mobile_no,email,gender, regdate) values('" + user + "','" + dobirth + "','" + age + "','" + bgroup + "','" + address + "','" + mnumber + "','" + email + "','" + gender + "', CURDATE())");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("indexwelcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.jsp");
    }
%>