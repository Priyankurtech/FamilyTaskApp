package com.family.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.family.dao.LoginDao;



@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	

	public void doGet(HttpServletRequest req ,HttpServletResponse res) throws IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		LoginDao login = new LoginDao();
		if(login.validate(username, password)) {
			
			HttpSession ses = req.getSession();
			ses.setAttribute("username", username);
			ses.setAttribute("password", password);
			
			
			try {
				res.sendRedirect("alltask.jsp");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}else {
			try {
				pw.print("<h4 style='color:red'>Login failed incorrect username or password</h4>");
				res.sendRedirect("login.jsp");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
		
	}
	
	
}