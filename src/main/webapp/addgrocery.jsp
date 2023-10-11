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
		<h1>Add Grocery</h1>
		<form action="addgrocery" method="post">
			<div class="inputbox">
				<input type="text" required="required" name="gname"> <span>Grocery
					Name</span>
			</div>
			<div class="inputbox">
				<input type="text" required="required" name="gno"> <span>Grocery
					Quantity</span>
			</div>
			
			<div class="inputbox">
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>