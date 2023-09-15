<%@page import="Entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee Information</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <%! Employee emp;%>
<% emp=(Employee)request.getAttribute("emp"); %>
<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h5 class="text-center text-primary mb-4">Edit Employee Information</h5>
            <form action="UpdateData" method="post">
                <div class="form-group">
                    <label for="id">ID</label>
                    <input type="text" class="form-control" id="id" name="id" value="<%=emp.getId() %>" readonly>
                </div>
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="<%=emp.getFirstname() %>">
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="<%=emp.getLastname() %>">
                </div>
                <div class="form-group">
                    <label for="userName">UserName</label>
                    <input type="text" class="form-control" id="userName" name="userName" value="<%=emp.getUsername() %>" >
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" value="<%=emp.getPassword() %>" >
                </div>
                
  <% if(emp.isIsadmin()){%>              
                <div class="form-group">
						<label for="isAdmin">Is Admin:</label> <input type="radio"
							id="isAdmin" name="isAdmin" value="true" checked disabled> <label
							for="notAdmin"> Not Admin:</label> <input type="radio"
							id="isAdmin" name="isAdmin" value="false" disabled>
					</div><%}else{ %>
					<div class="form-group">
						<label for="isAdmin">Is Admin:</label> <input type="radio"
							id="isAdmin" name="isAdmin" value="true" > <label
							for="notAdmin"> Not Admin:</label> <input type="radio"
							id="isAdmin" name="isAdmin" value="false" checked>
					</div>
					<%} %>
                <div class="form-group">
                    <label for="salary">Salary</label>
                    <input <%if(emp.isIsadmin()){ %>readonly<% }%> type="text" class="form-control" id="salary" name="salary" value="<%=emp.getSalary()%>" >
                </div>
                <button type="submit" class="btn btn-primary btn-block">Save Changes</button>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
