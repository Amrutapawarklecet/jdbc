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



@WebServlet("/AlldataServlet")
public class AlldataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page="addUser.jsp";
		StudentService service=new StudentServiceImpl();
		List<StudentBean> studentlist=service.getAllUser();
		request.setAttribute("studentlist",studentlist);
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
