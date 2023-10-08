<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="addtask.css">
</head>
<body>
	<div class="center">
		<h1>Add Task</h1>
		<form action="addtask" method="post">
			<div class="inputbox">
				<input type="text" required="required" name="taskname"> <span>Task
					Name</span>
			</div>
			<div class="inputbox">
				<input type="text" required="required" name="taskdes"> <span>Task
					Description</span>
			</div>
			<div class="inputbox">
				<input type="datetime-local" required="required" name="startdate"> <span>Start Date and Time</span>
			</div>
			<div class="inputbox">
				<input type="datetime-local" required="required" name="enddate"> <span>End Date and Time</span>
			</div>
			<div class="inputbox">
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>