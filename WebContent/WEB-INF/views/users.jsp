<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<div align="center"><h2>Users List</h2>
		<table>
			<tr>
				<th width="80">First Name</th>
				<th width="120">Last Name</th>
				<th width="120">Email</th>
			</tr>
			<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td><a href="<c:url value='/edit/${user.id}'/>">Edit</a>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>