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
import com.family.dao.GroceryDao;
import com.family.dao.TaskDao;
import com.family.dto.AddTaskEvent;
import com.family.dto.CalendarTask;
import com.family.dto.Grocery;
@WebServlet("/addgrocery")
public class AddGrocery extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
			
			String taskname = req.getParameter("gname");
			String quantity =req.getParameter("gno") ;
			Grocery grocery=new Grocery();
			grocery.setGroceryName(taskname);
			grocery.setQuantity(quantity);
			GroceryDao groceryDao=new GroceryDao();
			
			try {
				groceryDao.addGrocery(grocery);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   
			
			
			
			resp.getWriter().print("<h1>Grocery Added</h1>");
			//req.getRequestDispatcher("alltask.jsp").include(req, resp);
		

	}
	
}

