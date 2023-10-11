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

@WebServlet("/grocery")
public class GroceryServlet extends HttpServlet {
	private static final String query="SELECT item_id,item_name,quantity FROM grocery_list";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();	}
		try (Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/family_task", "postgres",
				"abcde");
				PreparedStatement ps=con.prepareStatement(query);){
				ResultSet rs=ps.executeQuery();
				pw.println("<table border='1px' height='300px' width='500px' style='border-collapse:collapse;'>");
				pw.println("<tr>");
				pw.println("<th>item_name</th>");
				pw.println("<th>quantity</th>");
				pw.println("<th>update</th>");
				pw.println("<th>Delete</th>");
				pw.println("</tr>");
				
				while(rs.next())
				{
					pw.println("<tr>");
					pw.println("<td>"+rs.getString(2)+"</td>");
					pw.println("<td>"+rs.getString(3)+"</td>");
					pw.println("<td><a style=\"text-decoration: none;\" href='editScreen?id="+rs.getInt(1)+"'>update</a></td>");
					pw.println("<td><a style=\"text-decoration: none;\" href='deleteurl?id="+rs.getInt(1)+"'>Delete</a></td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
				}catch(SQLException se){
			se.printStackTrace();
			pw.println("<h3>"+se.getMessage()+"</h3>");}
		catch(Exception e){
			e.printStackTrace();
			pw.println("<h3>"+e.getMessage()+"</h3>");}
		pw.println("<button><a style=\"text-decoration: none;\" href=\"home.jsp\">Home</a></button>");
		}

	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);	
		}

}