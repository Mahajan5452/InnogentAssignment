<%@page import="java.util.List"%>
<%@page import="Entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

 <%! Employee emp;%>
 
 <%!List<Employee>list; %>
 
  <% 
  if(session==null){
	  response.sendRedirect("login.jsp");
  }
  emp=(Employee)session.getAttribute("emp"); 
    list= (List<Employee> )session.getAttribute("list");
  if(emp.isIsadmin())
  {
  %>
  <h1 align="center">Hi  <%=emp.getFirstname() %> </h1>
	 <div>
	 <table  class="table table-striped-columns">
	 <thead>
      <tr>
      <th>id</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>username</th>
        <th>isadmin</th>
        <th>salary</th>
      </tr>
    </thead>
	     <tbody>
           <%for(int i=0;i<list.size();i++){%>
           <tr>
           <td><%=list.get(i).getId() %></td>
           <td><%=list.get(i).getFirstname() %></td>
           <td><%=list.get(i).getLastname() %></td>
           <td><%=list.get(i).getUsername() %></td>
           <td><%=list.get(i).isIsadmin() %></td>
           <td><%=list.get(i).getSalary() %></td>
              
          <td><a class="btn btn-primary" href="UpdateData?id=<%=list.get(i).getId() %>" role="button" >update</a></td>
          <td>
                           
                            <% if (!list.get(i).isIsadmin()) { %>
                                <a class="btn btn-danger href="DeleteClt?id=<%= list.get(i).getId()%>" role="button">delete</a>
                            <% }else{ %>
                            <button type="button" class="btn btn-danger" data-toggle="modal"
		                     data-target="#staticBackdrop">delete</button>
                            <%} %>
                        </td>

           </tr>
           <%} %>
           <a class="btn btn-success" href="addData.jsp" role="button">Add Data</a>
           <div align="right">
           <a class="btn btn-danger" href="logoutClt" role="button">Logout</a>
           </div>
    </tbody>
	 </table>
	 <div class="modal fade" id="staticBackdrop" data-backdrop="static"
		data-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel"><h5>Warning</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Employeee canNot be deleted
			</div>
				
		</div>
	 </div>
  <% }else {%>
  <div class="container mt-4">
    <div class="row">
        <div class="col-md-6">
            <div class="card bg-light">
                <div class="card-body">
                    <h5 class="card-title text-primary">Employee Information</h5>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">First Name: <span class="text-success"><%=emp.getFirstname() %></span></li>
                        <li class="list-group-item">Last Name: <span class="text-success"><%=emp.getLastname() %></span></li>
                        <li class="list-group-item">User Name: <span class="text-success"><%=emp.getUsername() %></span></li>
                        <li class="list-group-item">Is Admin: <span class="text-success"><%=emp.isIsadmin() %></span></li>
                        <li class="list-group-item">Salary: <span class="text-success"><%=emp.getSalary() %></span></li>
                    </ul>
                </div>
                <a href="userEdit.jsp" class="btn btn-primary" >Edit</a>
            </div>
        </div>
    </div>
</div>











  <%} %>
</body>
</html>