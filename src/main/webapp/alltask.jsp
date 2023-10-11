<%@page import="com.family.dto.AddTaskEvent"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.family.*"%>
<%@page import="com.family.dto.*"%>
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
	   <div id="navbar-container"></div>
<script>
    // Fetch and include the navbar HTML
    fetch('navbar.html')
        .then(response => response.text())
        .then(html => {
            document.getElementById('navbar-container').innerHTML = html;
        });
</script>
	   
		<h2 class="welcome">Welcome to FamilyTask</h2>
		<%
		TaskDao dao=new TaskDao();
		request.setAttribute("alltask",dao.getAllTask() );
		  List<TaskEventShow> task1= (List<TaskEventShow>)request.getAttribute("alltask");
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
			for(TaskEventShow event:task1){
			%>
			<tr class="active-row">
				<td><%=event.getTaskname()%></td>
				<td><%=event.getTaskdes()%></td>
				<td><%=event.getTstatus()%></td>
				<td><%=event.getStartdate()%></td>
				<td><%=event.getEnddate()%></td>
				<td><a href="edit.jsp?id=<%=event.getTaskid()%>"><button type="button" class="btn">edit</button></a></td>
				<td><a href="editstatus?id=<%=event.getTaskid()%>"><button type="button" class="btn">done</button></a></td>
				<td><a href="deletestatus?id=<%=event.getTaskid()%>"><button type="button" class="btn">delete</button></a></td>

			</tr>
			<%
			}
			%>
		</table>


	
</body>
</html>