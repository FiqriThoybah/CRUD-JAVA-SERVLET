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
	<h1 align="center">Tambah Karyawan</h1>
	<table align="center" bgcolor="white" size="80%">
		<form method="POST" action="welcome.do">
			<tr>
				<td><label>Name </label></td>
				<td><label>:</label></td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td><label name="jk">Jenis Kelamin </label></td>
				<td><label>:</label></td>
				<td><select name="gender">
						<option value="male">Male</option>
						<option value="female">Female</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="role">Role </label></td>
				<td><label>:</label></td>
				<td><select name="role">
						<option value="QA">QA</option>
						<option value="Dev">Developer</option>
						<option value="BA">BA</option>
						<option value="PM">PM</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Age </label></td>
				<td><label>:</label></td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td><label>Dependent :</label></td>
				<td><label>:</label></td>
				<td><input type="text" name="dependent" /></td>
			</tr>
			<tr>
				<td><label>Location </label></td>
				<td><label>:</label></td>
				<td><input type="text" name="location" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</form>
		</td>
		</tr>
	</table>
	<a align="center" href="menu.jsp">[Back]</a>
	<%
		} else {
		response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>