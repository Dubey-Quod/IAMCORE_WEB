<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<h3><a href="logout.html">Disconnect</a></h3> 
<body bgcolor="LightSeaGreen">
<center>
<h2>Welcome to IAM System</h2>
</center>
        <form method="GET" action="add.html">
            <center>
            <table border="0" width="30%" cellpadding="3">
                <tbody>                    
                    <tr>
                        <td><input type="submit" value="Create Identity" style="height:50px; width:400px"/></td>
                    </tr>                   
                </tbody>
            </table>
            </center>
        </form>
        
        <form method="GET" action="search.html">
            <center>
            <table border="0" width="30%" cellpadding="3">               
                <tbody>                   
                    <tr>
                        <td><input type="submit" value="Search Identity" style="height:50px; width:400px"/></td>
                    </tr>                    
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>