<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
</head>
<body>
	<h2>Shopping Cart</h2>
	Welcome ${user}, <a href="login">Sign Out</a>
	<table border="1">
		<tr><th>Name</th></tr>
		<c:forEach items="${cart}" var="p">
			<tr> <td> ${p.name} </td> </tr>
		</c:forEach>	
	</table>
	<a href="products">Back to Shop</a>

</body>
</html>