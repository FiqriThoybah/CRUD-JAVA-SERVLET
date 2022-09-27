<%@page import="com.latihan.model.Employee"%>
<%@page import="java.sql.PreparedStatement"%>
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
<title>Insert title here</title>
</head>
<body>
<%
		String userlogin = (String) session.getAttribute("user_login");
	if (userlogin != null) {
	%>
	<h1 align="center">Ubah Data Karyawan</h1>
	<%
		Employee employee = (Employee) request.getAttribute("employee_data");
	%>
	<table align="center" bgcolor="white" size="80%">
		<form method="POST" action="welcome.do?id=<%=employee.getId()%>&action=update">
		<tr>
				<td><label>Name </label></td>
				<td><label>:</label></td>
				<td><input type="text" name="name"
					value="<%=employee.getName()%>" /></td>
			</tr>
			<tr>
				<td><label name="jk">Jenis Kelamin </label></td>
				<td><label>:</label></td>
				<td><select name="gender" value="<%=employee.getGender()%>">
						<option value="male">Male</option>
						<option value="female">Female</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="role">Role </label></td>
				<td><label>:</label></td>
				<td><select name="role" value="<%=employee.getRole()%>">
						<option value="QA">QA</option>
						<option value="Dev">Developer</option>
						<option value="BA">BA</option>
						<option value="PM">PM</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Age </label></td>
				<td><label>:</label></td>
				<td><input type="text" name="age"
					value="<%=employee.getAge()%>" /></td>
			</tr>
			<tr>
				<td><label>Dependent :</label></td>
				<td><label>:</label></td>
				<td><input type="text" name="dependent"
					value="<%=employee.getDependent()%>" /></td>
			</tr>
			<tr>
				<td><label>Location </label></td>
				<td><label>:</label></td>
				<td><input type="text" name="location"
					value="<%=employee.getLocation()%>" /></td>
			</tr>
			<tr>
				<td><button>Update</button>
			</tr>
			</td>
			</tr>
	</table>
	</form>
	<%
		} else {
		response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>