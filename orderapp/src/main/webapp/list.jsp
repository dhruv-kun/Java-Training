<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- @ taglib uri="http://www.springframework.org/tags/form" prefix="form" --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
	<h2>Product List</h2>
	<form method="post" action="cart.do">
		<table border="1">
			<tr> <th>Name</th> <th>Price</th> <th>Category</th> <th>Select</th> </tr>
			<c:forEach items="${products}" var="p"> 
				<tr>
					<td> ${p.name} </td>
					<td> ${p.price} </td>
					<td> ${p.category} </td>
					<td> <input type="checkbox" name="prds" value="${p.id}"/> </td>
				</tr>
			</c:forEach>
		</table>
		<button type="submit">Add to Cart</button>
	</form>
</body>
</html>