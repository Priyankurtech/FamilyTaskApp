<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="navbar.css">
</head>
<body>
    <div class="navbar">
        <div class="logo">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Google_Tasks_2021.svg/640px-Google_Tasks_2021.svg.png" alt="Logo">
        </div>
        <div class="menu-items">
            <a href="alltask.jsp">TaskHome</a>
            <a href="allgrocery.jsp">Grocery List</a>
            <a href="addtask.jsp">Add Task</a>
            <a href="addgrocery.jsp">Add Grocery</a>
        </div>
        <div class="user-info">
            <%-- Check if the user is logged in --%>
            <%
                String username = (String) session.getAttribute("username");
                if (username != null && !username.isEmpty()) {
            %>
                    <span id="username">UserName: <%= username %></span>
            <%
                }
            %>
        </div>
        <div class="dropdown">
    <button class="dropbtn" type="button">Menu</button>
    <div class="dropdown-content">
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="logout.jsp">Logout</a></li>
            <li><a href="signup.jsp">Signup</a></li>
        </ul>
    </div>
</div>

    </div>
</body>
</html>
