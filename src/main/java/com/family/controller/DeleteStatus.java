package com.family.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.family.dao.TaskDao;


@WebServlet("/deletestatus")
public class DeleteStatus extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 try {
    		 TaskDao dao = new TaskDao();
    			String query = "select * from familyevent";
    			Connection con = dao.connect_to_database();
    			Statement statement = con.createStatement();
    			ResultSet resultSet = statement.executeQuery(query);
    			while (resultSet.next()) {
    				String newtaskname = req.getParameter("taskname");
    	 			String newtaskd = req.getParameter("taskdes");
    	 			TaskDao dao1 = new TaskDao();
    	 			Connection con1 = dao1.connect_to_database();
    	 			Statement statement1 = con1.createStatement();
    	 			int id=Integer.parseInt(req.getParameter("id"));
    	 			String query1 = String.format("delete from familyevent where taskid='%s';",id);
    	 			statement1.executeUpdate(query1);
    	 			con1.close();
    	 			
    			}
    			resp.getWriter().print("<h1>delete task done</h1>");
 			req.getRequestDispatcher("alltask.jsp").include(req, resp);
 		} catch (SQLException | ClassNotFoundException e) {

 			e.printStackTrace();
 		}
    }
}
