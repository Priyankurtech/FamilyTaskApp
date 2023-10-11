package com.family.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final String query="INSERT INTO grocery_list(item_name,quantity)VALUES (?,?)";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name = req.getParameter("item_name");
		String quantity = req.getParameter("quantity");
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();	}
		try (Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/family_task", "postgres",
				"abcde");
				PreparedStatement ps=con.prepareStatement(query);){
				ps.setString(1, name);
				ps.setString(1, quantity);
				int count=ps.executeUpdate();
				if(count==1)
				{
					pw.println("<h2>Added Successfully</h2>");
				}
				else
				{
					pw.println("<h2>Falied to Add</h2>");
				}
				}catch(SQLException se){
			se.printStackTrace();
			pw.println("<h3>"+se.getMessage()+"</h3>");}
		catch(Exception e){
			e.printStackTrace();
			pw.println("<h3>"+e.getMessage()+"</h3>");}
		pw.println("<button><a style=\"text-decoration: none;\" href=\"home.jsp\">Home</a></button>");
		pw.println("<button><a style=\"text-decoration: none;\" href=\"grocery\">Grocery list</a></button>");
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
