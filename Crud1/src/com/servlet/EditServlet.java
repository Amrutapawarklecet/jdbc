package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.service.StudentService;
import com.service.StudentServiceImpl;



@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBean studentbean=new StudentBean();
		StudentService service=new StudentServiceImpl();
		String sid=request.getParameter("sid");
		studentbean=service.getUserBysid(sid);
		request.setAttribute("studentbean",studentbean);
		String page="edit.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
