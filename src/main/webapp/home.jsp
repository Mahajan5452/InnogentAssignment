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
  <% emp=(Employee)session.getAttribute("emp"); 
    list= (List<Employee> )request.getAttribute("list");
  if(emp.isIsadmin())
  {
  %>
  <h1>Hi  <%=emp.getFirstname() %> </h1>
	 <div>
	 <table  class="table table-striped-columns">
	 <thead>
      <tr>
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
           
           <td><%=list.get(i).getFirstname() %></td>
           <td><%=list.get(i).getLastname() %></td>
           <td><%=list.get(i).getUsername() %></td>
           <td><%=list.get(i).isIsadmin() %></td>
           <td><%=list.get(i).getSalary() %></td>
           </tr>
           <%} %>
    </tbody>
	 </table>
	 </div>
  <% }%>
</body>
</html>