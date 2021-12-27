package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.service.StudentService;
import com.service.StudentServiceImpl;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddStudentServlet");
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String email=request.getParameter("email");
		
		//add database
		StudentBean studentBean =new StudentBean(sid,sname,email);
		
		
		StudentService studentService =new StudentServiceImpl();
		studentService.addUser(studentBean);
	}

}
