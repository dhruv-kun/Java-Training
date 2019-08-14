<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>

<h1>Login</h1>

<form:form modelAttribute="booking" action="login.action"
	cssClass="inline" method="get">


	<fieldset><span class="errors span-18"> <form:errors
		path="*" /> </span>
	<table>
		<tr>
			<td><label for="user.email">Email:</label></td>
			<td><form:input id="user.email" path="user.email" /></td>
		</tr>
		<tr>
			<td><label for="user.password">password:</label></td>
			<td><form:password id="user.password" path="user.password" /></td>
		<tr>
			<td>
			<button type="submit">Login</button>
			</td>
			<td>
			<button type="submit">New User</button>
			</td>
		</tr>
		<form:hidden id="hotel.id" path="hotel.id" />
	</table>
	</fieldset>
</form:form>
</body>
</html>