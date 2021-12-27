package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		
		HttpSession session=request.getSession();
		String p1=(String)session.getAttribute("p1");
		String p2=(String)session.getAttribute("p2");
		out.println("Reading from Request Object");
		out.println(request.getParameter("Param1")+" : "+request.getParameter("Param2"));
		out.println("Reading from HttpSesion Object");
		out.println(p1+" : "+p2);
		
		session.invalidate();// destory the seesion Object
		
	}

}
