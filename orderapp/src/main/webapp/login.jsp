<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h2>Login</h2>
	<form:form method="post" action="login.do">
		Email <input type="email" name="email" required /><br /> 
		Password <input type="password" name="pwd" required /><br />
		<button type="submit">Login</button>
	</form:form>
</body>
</html>