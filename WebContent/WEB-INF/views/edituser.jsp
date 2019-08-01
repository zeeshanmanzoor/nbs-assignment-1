<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
</head>
<body>
	<div align="center">
		<form:form action="edituser" method="post" commandName="userForm">
			<table>
				<tr>
					<td align="center"><h2>Edit User</h2></td>
				</tr>
				<tr>
				<td>
					<form:hidden path="id" />
				</td> 
				</tr>
				<tr>
					<td>First Name: </td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name: </td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Edit"/></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>