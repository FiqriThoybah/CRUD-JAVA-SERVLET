<%@page import="com.latihan.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.latihan.model.Database"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List JSP</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<%
	String userlogin = (String) session.getAttribute("user_login");
	if (userlogin != null) {
	%>
	<h1 align="center">.: Employee List :.</h1>
	<%
	ArrayList<Employee> employeeList = (ArrayList<Employee>) request.getAttribute("employee_list");
	%>
	<a href="new_employee_form.jsp">[Add Employee]</a>
	<a href="menu.jsp">[Back]</a>
	<table align="center" class="table table-dark table-striped" size="80%">
		<tr>
			<th>NO.</th>
			<th>Name</th>
			<th>Location</th>
			<th>Role</th>
			<th>Action</th>
		</tr>
		<%
		int i = 1;
		for (Employee emp : employeeList) {
		%>
		<tr>
			<td>
				<%
				out.println(i);
				%>
			</td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getRole()%></td>
			<td><%=emp.getLocation()%></td>
			<td align="center"><a class="btn btn-primary" href="welcome.do?id=<%=emp.getId()%>" role="button">View</a>
			<a class="btn btn-danger" href="welcome.do?id=<%=emp.getId()%>&action=delete" role="button">Delete</a></td>
		</tr>
		<%
		i++;
		}
		%>

	</table>
	
	<%
	} else {
	RequestDispatcher rd = request.getRequestDispatcher("login.do");
	rd.include(request, response);
	}
	%>
</body>
</html>