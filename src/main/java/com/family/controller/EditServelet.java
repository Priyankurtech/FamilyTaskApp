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
@WebServlet("/editScreen")
public class EditServelet extends HttpServlet {
	private static final String query="SELECT item_name,quantity FROM grocery_list WHERE item_id=?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();	}
		try (Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/family_task", "postgres",
				"abcde");
				PreparedStatement ps=con.prepareStatement(query);){
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				rs.next();
				pw.println("<form action='editurl?id="+id+"' method='post'>");
				pw.println("<table>");
				pw.println("<tr>");
				pw.println("<td>Pizza Name</td>");
				pw.println("<td><input type='text' name='name' value='"+rs.getString(1)+"'><td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td>Quantity</td>");
				pw.println("<td><input type='text' name='quantity' value='"+rs.getString(2)+"'><td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td><input type='submit' value='Update'><td>");
				pw.println("<td><input type='reset' value='cancel'><td>");
				pw.println("</tr>");
				pw.println("</table>");
				pw.println("</form>");
				
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