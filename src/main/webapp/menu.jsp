
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<title>dataEmployee</title>
</head>
<body>
	<div class="p-5 mb-4 bg-light rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold">Employee Apps</h1>
			<%
			String userlogin = (String) session.getAttribute("user_login");
			if (userlogin != null) {
				out.println("<h1 align = center>WELCOME " + userlogin + " to EMPLOYEE APPS</h1>");
			%>
		</div>
	</div>
	<div class="row align-items-md-stretch">
		<div class="col-md-6">

			<div class="h-100 p-5 text-white bg-dark rounded-3">
				<h2>Employee List</h2>
				<a href="welcome.do">
					<button class="btn btn-outline-light" type="button">Employee
						List</button>
				</a>
			</div>
		</div>
		<div class="col-md-6">
			<div class="h-100 p-5 bg-light border rounded-3">
				<h2>Add New Employee</h2>
				<a href="new_employee_form.jsp">
					<button class="btn btn-outline-secondary" type="button">Add
						New Employee</button>
				</a>
			</div>
		</div>
	</div>
	<%
	} else {
	response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>