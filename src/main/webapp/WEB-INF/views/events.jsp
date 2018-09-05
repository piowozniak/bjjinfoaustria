<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>BJJ INFO AUSTRIA</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
</style>
</head>
<body>
	<h2>events</h2>
	<c:forEach items="${events }" var="event">
		<tr>
			<td >${event.nameOfEvent }</td>
			<f:select path="typeOfEvent" items="typeOfEvents"/>
			<td >${event.host }</td>
			<td >${event.organisator }</td>
			<td >${event.startDate }</td>
			<td >${event.endDate }</td>
			<td >${event.startHour }</td>
			<td >${event.deadLine }</td>
			<td >${event.locationCity }</td>
			<td >${event.locationAddress }</td>
			<td >${event.fee }</td>
			
		</tr>
	
	
	</c:forEach>
	<form method="get" action="/bjjinfoaustria/createevent">
		<button type="submit">add event</button>
	</form>


</body>
</html>
