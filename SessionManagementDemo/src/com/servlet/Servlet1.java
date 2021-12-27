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
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 =request.getParameter("param1");
		PrintWriter out=response.getWriter();
		out.println("Parameter 1:"+param1);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='Servlet2'>");
		out.println("<input type='text' name='param2' placeholder='Parameter 2'/> ");
		out.println("<input type='hidden'  name='param1' value=''+param1+''>");
		out.println("<input type='submit' value='Call Servlet2'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		HttpSession session=request.getSession();
		session.setAttribute("p1", param1);
		
		
	}

}
