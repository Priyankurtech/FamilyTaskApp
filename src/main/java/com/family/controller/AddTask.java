package com.family.controller;

import java.io.IOException;

import java.security.GeneralSecurityException;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.family.dao.TaskDao;
@WebServlet("/addtask")
public class AddTask extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String taskname = req.getParameter("taskname");
			String taskdescription = req.getParameter("taskdes");
			LocalDateTime start_date =LocalDateTime.parse(req.getParameter("startdate")) ;
			LocalDateTime end_date = LocalDateTime.parse(req.getParameter("enddate"));
			TaskDao dao = new TaskDao();
			Connection con = dao.connect_to_database();
			Statement statement = con.createStatement();
			String query = String.format("insert into familyevent(task_name,task_details,status,event_start_date,event_end_date) values('%s','%s','%s','%s','%s');",
					taskname, taskdescription, "not done",start_date,end_date);
			statement.executeUpdate(query);
			String sd=req.getParameter("startdate");
			String ed=req.getParameter("enddate");
			CalendarEventApp app=new CalendarEventApp();
			app.setNewEvent( taskname, taskdescription,sd,ed);
			resp.getWriter().print("<h1>Task Added</h1>");
			req.getRequestDispatcher("alltask.jsp").include(req, resp);
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

