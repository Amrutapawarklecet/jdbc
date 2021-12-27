package com.servlet;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.service.StudentService;
import com.service.StudentServiceImp;

/**
 * Servlet implementation class ViewAllStudentServlet
 */
@WebServlet("/ViewAllStudentServlet")
public class ViewAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService studentservice=new StudentServiceImp();
		List<StudentBean> students=studentservice.getalluser();
		StudentBean studentbean=null;
		for(int i=0;i<students.size();i++)
		{
			studentbean=students.get(i);
			System.out.println(studentbean.getSid()+" "+studentbean.getSname()+" "+studentbean.getEmail());
			
		}
	}

}
