
package com.family.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.family.dao.TaskDao;
import com.family.dto.AddTaskEvent;
import com.family.dto.TaskEventShow;


@WebServlet("/alltask")
public class ShowTask extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TaskDao dao=new TaskDao();
		
//		try {		
//			req.setAttribute("alltask",dao.getAllTask() );
			req.getRequestDispatcher("alltask.jsp").forward(req, resp);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
  


