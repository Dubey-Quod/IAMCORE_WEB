<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
 <head>  
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
  <title>Identity Search</title>  
 </head>  
 <h3><a href="backwelcome.html">Back</a></h3> 
 
 <body bgcolor="LightSeaGreen">  
  
		<center>
			<h2>Identity Search</h2>
			<form:form method="POST" action="find.html">  
				<table>   
					<tr>  
						<td><form:label path="uid">User ID:</form:label></td>  
						<td><form:input path="uid" value=""/></td>  
					</tr>         
				</table> 
				<input type="submit" value="Submit" size="90" style="height:30px; width:180px"/>  
			</form:form>  
		</center>
  

    
		<c:if test="${!empty identity}">  
			<center>
				<h2>Search Results</h2>  
			</center>
			
				<table align="center" border="1">  
					<tr>  
						<th>User ID</th>  
						<th>First Name</th>  
						<th>Last Name</th>  
						<th>Email</th>  
						<th>Actions on Row</th>  
					</tr>  
					<tr>  
						<td><c:out value="${identity.uid}"/></td>  
						<td><c:out value="${identity.firstName}"/></td>  
						<td><c:out value="${identity.lastName}"/></td>  
						<td><c:out value="${identity.email}"/></td>   
						<td align="center"><a href="loadedit.html?uid=${identity.uid} & firstName= ${identity.firstName} & lastName=${identity.lastName} & email=${identity.email}">Modify</a> | <a href="delete.html?uid=${identity.uid}">Delete</a></td>  
					</tr>  
				</table>
			
		</c:if>
	 
		<c:if test="${empty identity}"> 
			<center>
				<h2>Search Results</h2>  
			</center> 				  
				<table align="center" border="1">   
					<tr>  
					<td><c:out value="No Identity found/Identity deleted!!"/></td>  
					</tr>  
				</table>
			 
		</c:if>   
	</body>   
</html>  