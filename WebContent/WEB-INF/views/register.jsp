<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
<style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
</style>
</head>
<body>
	<div align="center">
		<form:form action="register" method="post" commandName="userForm">
			<table>
				<tr>
					<td align="center"><h2>User Registration</h2></td>
				</tr>
				<tr>
					<td>First Name: </td>
					<td><form:input path="firstName"/></td>
					<form:errors path="firstName" cssClass="error"/><br><br>
				</tr>
				<tr>
					<td>Last Name: </td>
					<td><form:input path="lastName"/></td>
					<%-- <form:errors path="lastName"/><br><br> --%>
				</tr>
				<tr>
					<td>Email: </td>
					<td><form:input path="email"/></td>
					<%-- <form:errors path="email"/><br><br> --%>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Register"/></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>