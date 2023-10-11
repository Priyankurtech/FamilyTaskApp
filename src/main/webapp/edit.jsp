
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
<title>Insert title here</title>
<link rel="stylesheet" href="edit.css">
</head>
<body>

	<div class="center">
		<h1>Edit Task</h1>
		<%int id=Integer.parseInt(request.getParameter("id"));
		
		System.out.println(id);
		%>
		<form action="edittask" method="post">
		    <input type="hidden" value="<%=id%>" name="taskid">
			<div class="inputbox">
				<input type="text" required="required" name="taskname"> <span>Task
					Name</span>
			</div>
			<div class="inputbox">
				<input type="text" required="required" name="taskdes"> <span>Task
					Description</span>
			</div>
			<div class="inputbox">
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>