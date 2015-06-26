<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Identity Management</title>
</head>
<body>
<h1>Identity Management</h1>
<form:form action="identity.do" method="POST" commandName="identity">
	<table>
		<tr>
			<td>User ID</td>
			<td><form:input path="uid" /></td>
		</tr>
		<tr>
			<td>First name</td>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td>Last name</td>
			<td><form:input path="lastName" /></td>
		</tr>

		<tr>
			<td>Email Id</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="write" />
				<input type="submit" name="action" value="edit" />
				<input type="submit" name="action" value="delete" />
				<input type="submit" name="action" value="Search" />
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<th>ID</th>
	<th>First name</th>
	<th>Last name</th>
	<th>email</th>
	<c:forEach items="${identityList}" var="identity">
		<tr>
			<td>${identity.uid}</td>
			<td>${identity.firstName}</td>
			<td>${identity.lastName}</td>
			<td>${identity.email}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>