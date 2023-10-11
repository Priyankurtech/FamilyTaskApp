package com.family.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.family.controller.AddTask;
import com.family.dto.AddTaskEvent;
import com.family.dto.TaskEventShow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

public class TaskDao {

	public Connection connect_to_database() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/family_task", "postgres",
				"abcde");
		if (connection == null) {
			System.out.println("not connected");
		} else {
			System.out.println("connected");
		}
		return connection;
	}

	public void create_table(Connection con, String tablename) throws SQLException {
		Statement statement = con.createStatement();
		//String query = "create table " + tablename
		//		+ "(taskid SERIAL,task_name varchar(50),task_details varchar(200),status varchar(50),event_start_date TIMESTAMP NOT NULL,event_end_date TIMESTAMP NOT NULL, primary key (taskid))";
		String query = "create table " + tablename+ "(item_id SERIAL,item_name varchar(50),quantity varchar(10),status varchar(10),primary key (item_id))";
		statement.executeUpdate(query);
	}

	public void addtask(AddTaskEvent addTaskEvent) throws ClassNotFoundException, SQLException {

		String taskname = addTaskEvent.getTaskname();
		String taskdescription = addTaskEvent.getTaskdes();
		LocalDateTime start_date = addTaskEvent.getStartdate();
		LocalDateTime end_date = addTaskEvent.getEnddate();
		Connection con = connect_to_database();
		Statement statement = con.createStatement();
		String query = String.format(
				"insert into familyevent(task_name,task_details,status,event_start_date,event_end_date) values('%s','%s','%s','%s','%s');",
				taskname, taskdescription, "not done", start_date, end_date);
		statement.executeUpdate(query);
	}
	public List getAllTask()throws ClassNotFoundException, SQLException {
        List<TaskEventShow> task=new ArrayList<TaskEventShow>();
		
		String query = "select * from familyevent";
		Connection con = connect_to_database();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			int taskid=resultSet.getInt("taskid");
			String taskname = resultSet.getString("task_name");
			String taskd = resultSet.getString("task_details");
			String status = resultSet.getString("status");
			Date startdate = resultSet.getDate("event_start_date")  ;
			Date enddate =resultSet.getDate("event_end_date") ;
			TaskEventShow addTaskEvent=new TaskEventShow();
			
			addTaskEvent.setTaskid(taskid);
			addTaskEvent.setTaskname(taskname);
			addTaskEvent.setTaskdes(taskd);
			addTaskEvent.setTstatus(status);
			addTaskEvent.setStartdate(startdate);
			addTaskEvent.setEnddate(enddate);
			task.add(addTaskEvent);
		}
		return task;
		
		
	}
}
