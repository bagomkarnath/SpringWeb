<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Register</title>
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #07AA8D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.form-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	border: 1px solid #888;
	width: 40%;
}

div.signup {
	float: right;
	padding-top: 16px;
}

.container {
	padding-top: 16px;
	padding-left: 16px;
	padding-right: 16px;
	padding-bottom: 50px;
}
</style>
</head>
<body>

	<form class="form-content" action="auth" method="post">
		<h2 align="center">Issue Tracker Login</h2>
		<div class="container">
			<label for="username"><b>Username</b></label> 
			<input type="text" placeholder="Enter Username" name="username" required> 
			<label for="password"><b>Password</b></label> 
			<input type="password" placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>
			<div class="signup">
				New User ? <a href="signup">sign up</a> here
			</div>
		</div>
	</form>
</body>
</html>