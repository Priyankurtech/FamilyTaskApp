<%@page import="java.time.LocalDate"%>
<%@page import="com.family.*"%>
<%@page import="com.family.dao.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="alltask.css">
</head>
<body>
	<form method="post">
		<h1 class="welcome">Welcome to FamilyTask</h1>
		<%
		TaskDao dao = new TaskDao();
		String query = "select * from familyevent";
		Connection con = dao.connect_to_database();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		%>
		<table class="styled-table">

			<tr>
				<th>Task Name</th>
				<th>Task Description</th>
				<th>Task Status</th>
				<th>Event Start Date</th>
				<th>Event End date</th>
				<th>Edit Task Description</th>
				<th>Change Status</th>
				<th>Delete Task</th>
			</tr>
			<%
			while (resultSet.next()) {
				int taskid=resultSet.getInt("taskid");
				String taskname = resultSet.getString("task_name");
				String taskd = resultSet.getString("task_details");
				String status = resultSet.getString("status");
				Date startdate =resultSet.getDate("event_start_date") ;
				Date enddate =resultSet.getDate("event_end_date");
			%>
			<tr class="active-row">
				<td><%=taskname%></td>
				<td><%=taskd%></td>
				<td><%=status%></td>
				<td><%=startdate%></td>
				<td><%=enddate%></td>
				
				<td><a href="edit.jsp?id=<%=taskid%>"><button type="button" class="btn">edit</button></a></td>
				<td><a href="editstatus?id=<%=taskid%>"><button type="button" class="btn">done</button></a></td>
				<td><a href="deletestatus?id=<%=taskid%>"><button type="button" class="btn">delete</button></a></td>

			</tr>
			<%
			}
			%>
		</table>
<a href="addtask.jsp"> <button id="btnn" type="button">AddTask</button> </a>

	</form>
</body>
</html>