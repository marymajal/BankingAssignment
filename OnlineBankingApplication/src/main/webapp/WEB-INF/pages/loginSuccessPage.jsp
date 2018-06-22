<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1 style="color:#0066CC">
Bank Login Page
</h1>
<div align="center">
       <form action="bankUserValidation" method="post" modelAttribute="bankLoginDetails">
            <tr>
				<td>customerId</td>
				<td><input type="text" name="customerID" /></td>
			</tr>
			<tr>
				<td>bankName</td>
				<select id="bankName" type="text" name="bankName">
					<option value="HDFC">HDFC</option>
					<option value="ICICI">ICICI</option>
					<option value="SBI">SBI</option>
					<option value="BANKOFBARODA">BANKOFBARODA</option>
			</tr>
			 <input type="submit" value="Submit" />
        </form>
    </div>
</center>
</body>
</html>