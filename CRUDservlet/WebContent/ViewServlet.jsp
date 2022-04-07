<%@page import="com.crud.empDAO,com.crud.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.html">Add new Employee</a>

<h1>Employees List</h1>
<table border="1px">
	<tr><td>ID</td> 
		<td>Name</td>
		<td>Password</td>
		<td>Email</td>
		<td>Country</td>
		<td>Edit</td>
		<td>Delete</td>
	</tr>
	
	<%
		List<Emp>  list = empDAO.getAllEmployees();
		for(Emp e : list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet.jsp?id="+e.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td></tr>");
		}
	%>
</table>
</body>
</html>