package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("AddStudentServlet");
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String email=request.getParameter("email");
		
		//add database
		StudentBean studentBean =new StudentBean(sid,sname,email);
		
		//add student
		int result=-1;
		StudentService studentService =new StudentServiceImpl();
		if(sid!=null)
		{
		    result=studentService.addUser(studentBean);
		}
		String page="addUser.jsp";
		String msg="Student Addded Successfully";
		if(result==-1) {
			//page="error.jsp";
			msg="Error Ocurred! Student Not Added";
		}
		//adding request to response (key,value)
		request.setAttribute("msg",msg);
		
		
		
		//Get all user
		List<StudentBean> studentList=studentService.getAllUser();
		request.setAttribute("studentList",studentList);
		
		//request.setAttribute("sb",studentBean);
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request,response);
		
		
	}

}
