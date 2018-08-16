<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register</title>
</head>
<body>
<form method="post" action="register">
<table align="centre">
<tr>
<td>fullName</td>
<td><input type="text" name="fullName"/></td>
</tr>
<tr>
<td>email</td>
<td><input type="text" name="email"/></td>
<tr>
<td>userName</td>
<td><input type="text" name="userName"/></td>
</tr>
<tr>
<td>password</td>
<td><input type="text" name="password"/></td>
</tr>
<tr>
<td><input type="submit" value="Register"/></input></td>
</tr>



</table>
</form>
<a href="login.jsp">Already registered? Login</a>
</body>

</html>