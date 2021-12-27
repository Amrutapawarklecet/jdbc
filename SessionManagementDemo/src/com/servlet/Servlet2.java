package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param1=request.getParameter("param1");
		String param2=request.getParameter("param2");
		PrintWriter out=response.getWriter();
		out.println("Parameter 1:"+param1);
		out.println("Parameter 2:"+param2);
		
		HttpSession session =request.getSession();
		session.setAttribute("p2", param2);
		
		out.println("<form action='Servlet3'/>");
		out.println("<input type='submit' value='Call Servlet3'/>");
		out.println("</form>");
		/*RequestDispatcher rd=request.getRequestDispatcher("Servlet3");
		rd.forward(request, response);
		*/
		
		
	}

}
