<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bookings</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="bookings" "class="section">
 	<c:set  var="today"  value="<%= new Date() %>"/>  
 	<table width="100%">
 		<tr>
 			<td>
 			Current Hotel Bookings  as on  <fmt:formatDate value="${today}" pattern="dd-MMM-yyyy"/>
 			</td>
 			<td align="right">
 				User : ${booking.user.username }
 			</td>
 		</tr>
 	</table>
	<table>
	<c:if test="${empty bookingList}">
	<tr>
		<td colspan="7">No bookings found</td>
	</tr>
	</c:if>
</table>
	<c:if test="${!empty bookingList}">
	<table class="summary">
		<thead>
			<tr>
				<th>Hotel Name</th>
				<th>Address</th>
				<th>City, State</th>
				<th>Check in Date</th>
				<th>Check out Date</th>
				<th>Confirmation Number</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="booking" items="${bookingList}">
			<tr>
				<td>${booking.hotel.name}</td>
				<td>${booking.hotel.address}</td>
				<td>${booking.hotel.city}, ${booking.hotel.state}</td>
				<td><fmt:formatDate value="${booking.checkinDate}" pattern="dd-MMM-yyyy"/></td>
				<td><fmt:formatDate value="${booking.checkoutDate}" pattern="dd-MMM-yyyy"/></td>
				<td>${booking.id}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	<div>
		<a href="search.action">Change Search</a> 
	</div>
</div>

</body>
</html>