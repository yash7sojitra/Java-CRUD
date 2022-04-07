<%@page import="com.crud.empDAO"%>
<%@page import="com.crud.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Employee</h1>
<%
	String sid = request.getParameter("id");
	int id = Integer.parseInt(sid);
	Emp e = empDAO.getEmployeeById(id);
%>
	<form action="EditServlet2" method="post">
	<table>
	<tr><td></td><td><input type='hidden' name='id' value="<%=e.getId() %>"/></td></tr>
	<tr><td>Name:</td><td><input type="text" name="name" value="<%= e.getName() %>"></td></tr>
	<tr><td>Password:</td><td><input type="password" name="password" value="<%= e.getPassword() %>"></td></tr>
	<tr><td>Email:</td><td><input type="text" name="email" value="<%= e.getEmail() %>"></td></tr>
	<tr><td>Country:</td><td>
		<select name="country">
		<option>India</option>
		<option>USA</option>
		<option>UK</option>
		<option>Other</option>
		</select>
	</td></tr>
	<tr><td colspan="2"><input type="submit" value="Edit & Save"></td></tr>
	</table>
	</form>
	<br>
</body>
</html>