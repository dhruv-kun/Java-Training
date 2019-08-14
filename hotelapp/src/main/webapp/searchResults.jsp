<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<title>Hotel Search Results</title>
</head>
<body>
<h1>Hotel Search Results</h1>
<p><a id="changeSearchLink"
	href="search.do?searchString=${searchCriteria.searchString}&pageSize=${searchCriteria.pageSize}">Change
Search</a></p>
<div id="hotelResults">
<c:if test="${not empty hotelList}">
	<table class="summary">
		<thead>
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>City, State</th>
				<th>Zip</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="hotel" items="${hotelList}">
				<tr>
					<td>${hotel.name}</td>
					<td>${hotel.address}</td>
					<td>${hotel.city}, ${hotel.state}, ${hotel.country}</td>
					<td>${hotel.zip}</td>
					<td><a href="viewHotel.do?id=${hotel.id}">View Hotel</a></td>
				</tr>
			</c:forEach>
			<c:if test="${empty hotelList}">
				<tr>
					<td colspan="5">No hotels found</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<div class="buttonGroup">
	<div class="span-3"><c:if test="${searchCriteria.page > 0}">
		<a id="prevResultsLink"
			href="hotels?searchString=${searchCriteria.searchString}&pageSize=${searchCriteria.pageSize}&page=${searchCriteria.page - 1}">Previous
		Results</a>

	</c:if></div>
	<div class="span-3 append-12 last"><c:if
		test="${not empty hotelList && fn:length(hotelList) == searchCriteria.pageSize}">
		<a id="moreResultsLink"
			href="hotels?searchString=${searchCriteria.searchString}&pageSize=${searchCriteria.pageSize}&page=${searchCriteria.page + 1}">More
		Results</a>

	</c:if></div>
	</div>
</c:if></div>


</body>
</html>