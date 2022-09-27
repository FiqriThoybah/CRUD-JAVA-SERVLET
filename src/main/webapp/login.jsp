<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Design by foolishdeveloper.com -->
<title>Glassmorphism login Form Tutorial in html css</title>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap"
	rel="stylesheet">
<!--Stylesheet-->
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="background">
		<div class="shape"></div>
		<div class="shape"></div>
	</div>

	<form method="POST" action="login.do">
		<h3>Login Here</h3>
		<%
		String userlogin = (String) session.getAttribute("user_false");
		if (userlogin != null) {
			out.println("<h1 align = center>" + userlogin + "</h1>");
		}
		%>
		<label for="username">Username</label> <input type="text"
			placeholder="Email or Phone" id="username" name="username"> <label
			for="password">Password</label> <input type="password"
			placeholder="Password" id="password" name="password">

		<button>Log In</button>

	</form>
</body>
</html>
