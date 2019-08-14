<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Form</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<h1>Booking details</h1>

<form:form modelAttribute="booking" action="placeReservation.do"
	method="get" cssClass="inline">
	<span class="errors span-18"> <form:errors path="*" /> </span>
	<table>
	 <tr>
	 <td>
	 			${booking.hotel.name }
				<address> ${booking.hotel.address} <br />
				${booking.hotel.city}  , ${booking.hotel.state},
				${booking.hotel.zip} <br />
				${booking.hotel.country}</address>
				<p>Rate: ${booking.hotel.price}</p>
	  </td>
	  <td>
	  	<fieldset>
		<table>
			<tr>
				<td><label for="booking.user.email">Email</label></td>
				<td>${booking.user.email}</td>
			</tr>

			<tr>
				<td><label for="checkinDate">Check-in Date</label></td>
				<td><form:input id="checkinDate" path="checkinDate" /></td>
			</tr>
			<tr>
				<td><label for="checkoutDate">Checkout Date</label></td>
				<td><form:input id="checkoutDate" path="checkoutDate" /></td>
			</tr>
			<form:hidden id="hotel.id" path="hotel.id" />
			<form:hidden   path="user.email" />
			<tr>
			</tr>
			<tr>
				<td colspan="2">
				<button type="submit">Place Reservation</button>
				</td>
			</tr>
		</table>
			</fieldset>
		</td>
	</table>
	
</form:form>
</body>
</html>