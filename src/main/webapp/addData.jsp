<%@page import="Entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>addData</title>
</head>
<body>
 
  <% Employee e = (Employee)session.getAttribute("emp"); 
  		if(!e.isIsadmin()){
  			response.sendRedirect("login.jsp");
  		}
  
	  %>
<div class="container">
    <h2>Add Data</h2>
    <form action="addData" method="post">
        
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" required>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" required>
        </div>
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="isAdmin">Is Admin:</label>
            <input type="radio" id="isAdmin" name="isAdmin" value="true">
            <label for="notAdmin"> Not Admin:</label>
            <input type="radio" id="isAdmin" name="isAdmin" value="false">
        </div>
        <div class="form-group">
            <label for="salary">Salary:</label>
            <input type="number" class="form-control" id="salary" name="salary" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
