<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Banking Application</title>
</head>
<link rel="stylesheet" href="WEB-INF/resources/css/homepage.css">
<body>
<center>
<h1 style="color: #0066CC">Banking Application</h1>
<form action="validateUser" method="post" modelAttribute="bankUserDetails">
		<table style="with: 50%">
 
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>
				<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
        <input type="submit" value="Submit" />
		<h4>New Bank User To Register click <a href=newUser>here</a>
		</h4>
</body>
</center>
</html>