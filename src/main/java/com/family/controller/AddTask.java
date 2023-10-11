package com.family.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.family.dao.CalendarEventApp;
import com.family.dao.TaskDao;
import com.family.dto.AddTaskEvent;
import com.family.dto.CalendarTask;
@WebServlet("/addtask")
public class AddTask extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
			
			String taskname = req.getParameter("taskname");
			String taskdescription = req.getParameter("taskdes");
			LocalDateTime start_date =LocalDateTime.parse(req.getParameter("startdate")) ;
			LocalDateTime end_date = LocalDateTime.parse(req.getParameter("enddate"));
			AddTaskEvent addTaskEvent=new AddTaskEvent();
			addTaskEvent.setTaskname(taskname);
			addTaskEvent.setTaskdes(taskdescription);
			addTaskEvent.setStartdate(start_date);
			addTaskEvent.setEnddate(end_date);
			TaskDao dao=new TaskDao();
			CalendarTask calendar=new CalendarTask();
			String sd=req.getParameter("startdate");
      		String ed=req.getParameter("enddate");
			calendar.setTaskname(taskname);
			calendar.setTaskdes(taskdescription);
			calendar.setStartdate(sd);
			calendar.setEnddate(ed);
			CalendarEventApp app=new CalendarEventApp();
			try {
				dao.addtask(addTaskEvent);
				app.setNewEvent(calendar);
			} catch (ClassNotFoundException | SQLException | GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			resp.getWriter().print("<h1>Task Added</h1>");
			req.getRequestDispatcher("alltask.jsp").include(req, resp);
		

	}
	
}

