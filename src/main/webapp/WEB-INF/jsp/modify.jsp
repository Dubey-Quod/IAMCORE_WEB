<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Create Identity</title>
	</head>
	<h3><a href="search.html">Back</a></h3> 
	<body bgcolor="LightSeaGreen">
		<center>
		<h2>Identity Modification</h2>
		</center>
		<center>
		<form:form method="GET" action="edit.html">  
		      <table>  
		       <tr>  
		           <td><form:label path="uid">User ID:</form:label></td>  
		           <td><form:input path="uid" value="${identity.uid}" /> *Please do not change this field!!!</td>  
		       </tr>  
		       <tr>  
		           <td><form:label path="firstName">First Name:</form:label></td>  
		           <td><form:input path="firstName" value="${identity.firstName} "/></td>  
		       </tr>  
		       <tr>  
		           <td><form:label path="lastName">Last Name:</form:label></td>  
		           <td><form:input path="lastName" value="${identity.lastName}"/></td>  
		       </tr>  
		       <tr>  
		           <td><form:label path="email">Email:</form:label></td>  
		           <td><form:input path="email" value="${identity.email}"/></td>  
		       </tr>  	           
		        <tr>  
		         <td colspan="2"><input type="submit" value="Submit" size="90"/></td>  
		        </tr>  
		   </table>   
		  </form:form>  
		</center>
		<c:if test="${!empty identity}">  
			<center>
				<h2>Identity Details Table (*updated details will display here!!)</h2>  
			</center>
			
			<table align="center" border="1">  
				<tr>  
					<th>User ID</th>  
					<th>First Name</th>  
					<th>Last Name</th>  
					<th>Email</th>  
					<th>Message</th>  
				</tr>  
				<tr>  
					<td><c:out value="${identity.uid}"/></td>  
					<td><c:out value="${identity.firstName}"/></td>  
					<td><c:out value="${identity.lastName}"/></td>  
					<td><c:out value="${identity.email}"/></td>   
					<td><c:out value="Identity details!!"/></td>   
				</tr>  
			</table>				
		</c:if>			
	</body>
</html>