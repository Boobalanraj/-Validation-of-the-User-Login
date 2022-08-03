package com.validation.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
	PrintWriter out = resp.getWriter();
	
	String email =req.getParameter("username");
    String password =req.getParameter("password");
    
 
    
    
    if(email.equalsIgnoreCase("boobalan@gmail.com") && password.equalsIgnoreCase("boobalan")) {
        //add  user in the session once the login is done
        HttpSession into=req.getSession();
        into.setAttribute("email", email);
        into.setAttribute("pass", password);
        resp.sendRedirect("dashboard");
    }
    else {
      resp.sendRedirect("index.html");
    }
   }

}
