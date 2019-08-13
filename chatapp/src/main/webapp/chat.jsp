<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Chat</title>
</head>
<body>	
		<%
			response.setHeader("refresh", "5");
		%>
		${sessionScope}
		<hr/>
		${applicationScope.Company}
		
		Welcome ${user}, to ${Company}
		<form action="ChatServlet" method="post">
			<input type="text" name="msg"  required />
			<button type="submit">Send Message</button>
		</form>
		<c:forEach items="${applicationScope.messages}" var="m">
			${m} <br />
		</c:forEach>
</body>
</html>