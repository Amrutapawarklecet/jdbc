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
import com.service.StudentServiceImp;


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Welcome Servlet");
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String email=request.getParameter("email");
		
		// Adding Student
		int result=-1;
		StudentBean studentBean=new StudentBean(sid, sname, email);
		StudentService studentservice=new StudentServiceImp();
		if(sid!=null)
		{
			result=studentservice.adduser(studentBean);
		}
		
		String page="addUser.jsp";
		String msg="Student Added Successfully";
		if(result==-1)
		{
			//page="error.jsp";
			msg="Error occured! Student not Added";
		}
		request.setAttribute("msg", msg);
		//System.out.println(result);
		//System.out.println(msg);
		//Get all Students
		List<StudentBean>studentlist=studentservice.getalluser();
		request.setAttribute("list",studentlist );
		
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

}
