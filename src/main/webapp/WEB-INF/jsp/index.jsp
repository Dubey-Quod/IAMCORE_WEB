<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
		<title>Welcome to IAM System</title>  
	</head>  
	<body bgcolor="LightSeaGreen">
		<form method="GET" action="login.html">
			<center>
				<table border="0" width="30%" cellpadding="3">
					<thead>
						<tr>
							<th colspan="2">IAM Login Page</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>User ID</td>  
							<td><input type="text" name="uid" value=""/></td>
						</tr>
						<tr>
							<td>Password</td>  
							<td><input type="password" name="password" value=""/></td>
						</tr>
						<tr>                   	
							<td><input type="submit" value="Submit" style="height:40px; width:70px"/></td>
							<td><input type="reset" value="Reset" style="height:40px; width:70px"/></td>
						</tr>
					</tbody>
				</table>
			</center>
		</form>
	</body>
</html>  