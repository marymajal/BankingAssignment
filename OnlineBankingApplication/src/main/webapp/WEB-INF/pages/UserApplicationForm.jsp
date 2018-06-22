<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<link rel="stylesheet" href="WEB-INF/resources/css/addeduser.css">
<body>
    <div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="saveUserDetails" method="post" modelAttribute="bankUserDetails">
        <table>
        	<tr>
                <td>ID:</td>
                <td><form:input path="id" /></td>
            </tr>
            <tr>
                <td>FirstName:</td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td>LastName:</td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <td>CustomerID:</td>
                <td><form:input path="ssoId" /></td>
            </tr>
            <tr>
				<td>BankName</td>
				<td>
				<select id="bankName" type="text" name="bankName">
					<option value="HDFC">HDFC</option>
					<option value="ICICI">ICICI</option>
					<option value="INDUSLAND">INDUSLAND</option>
					<option value="SBI">SBI</option>
				</select>
				</td>
			</tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Submit"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>