package com.validation.practice;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =resp.getWriter();
		
		resp.setContentType("text/html");
		
		HttpSession into = req.getSession(false);
		
		if(into != null) {
			String userFromSession =(String)into.getAttribute("email");
			 
			if(userFromSession!=null) {
				out.println("User Exist "+userFromSession);
				out.print("<a href='logout'>Logout</a>");
			}
		}
		else {
			out.println("Kindly login first");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
