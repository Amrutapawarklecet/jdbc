package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.service.StudentService;
import com.service.StudentServiceImpl;

/**
 * Servlet implementation class ViewAllStudentServlet
 */
@WebServlet("/ViewAllStudentServlet")
public class ViewAllStudentServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService=new StudentServiceImpl();
		List<StudentBean> students =studentService.getAllUser();
		StudentBean studentBean=null;
		
		//print all user in console
		for(int i=0;i<students.size();i++) {
			studentBean=students.get(i);
			System.out.println(studentBean.getSid()+" : "+studentBean.getSname()+" : "+studentBean.getEmail());
		}
		
	}

}
