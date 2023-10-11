<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Items</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
</head>
<body>



	
	<h1><center> ADD ITEMS</center></h1>
	<form class="container" action="add">
	
  <div class="mb-3 ">
    <label  class="form-label">Item Name</label>
    <input type="text" class="form-control" id="item_name" aria-describedby="emailHelp" name="item_name" placeholder="enter item name">
  </div>
  <div class="mb-3 ">
    <label  class="form-label">Quantity</label>
    <input type="text" class="form-control" id="item_name" aria-describedby="emailHelp" name="quantity" placeholder="enter item name">
  </div>
  <button type="submit" class="btn btn-primary">ADD</button>
</form>

	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>