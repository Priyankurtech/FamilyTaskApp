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
    fetch('navbar.jsp')
        .then(response => response.text())
        .then(html => {
            document.getElementById('navbar-container').innerHTML = html;
        });
</script>
	   
		<h2 class="welcome">Welcome to FamilyTask</h2>
		<%
		GroceryDao dao=new GroceryDao();
		request.setAttribute("allgrocery",dao.getAllGrocery() );
		  List<Grocery> gro= (List<Grocery>)request.getAttribute("allgrocery");
		%>
		<table class="styled-table">

			<tr>
				<th>Grocery Name</th>
				<th>Quantity</th>
				<th>Status</th>
				<th>Edit Grocery Description</th>
				<th>Change Status</th>
				<th>Delete Task</th>
			</tr>
			<%
			for( Grocery event:gro){
			%>
			<tr class="active-row">
				<td><%=event.getGroceryName()%></td>
				<td><%=event.getQuantity()%></td>
				<td><%=event.getStatus()%></td>
				<td><a href="edit.jsp?id=<%=event.getGroceryid()%>"><button type="button" class="btn">edit</button></a></td>
				<td><a href="editstatus?id=<%=event.getGroceryid()%>"><button type="button" class="btn">done</button></a></td>
				<td><a href="deletestatus?id=<%=event.getGroceryid()%>"><button type="button" class="btn">delete</button></a></td>

			</tr>
			<%
			}
			%>
		</table>


	
</body>
</html>