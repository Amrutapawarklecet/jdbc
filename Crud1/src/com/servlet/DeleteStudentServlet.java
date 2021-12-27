package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.StudentService;
import com.service.StudentServiceImpl;



@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("sid");
		StudentService service=new StudentServiceImpl();
		service.deleteUser(sid);
		response.sendRedirect("AlldataServlet");
	}

}
