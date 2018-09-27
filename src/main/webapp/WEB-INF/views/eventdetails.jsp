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
	<h2>event details</h2>
	Name:
	<div>${event.nameOfEvent }</div>
	Type:
	<div>${event.typeOfEvent }</div>
	Host:
	<div>${event.host }</div>
	Organizer:
	<div>${event.organizer }</div>
	Start date:
	<div>${event.startDate }</div>
	End date:
	<div>${event.endDate }</div>
	Start time:
	<div>${event.startHour }</div>
	Deadline:
	<div>${event.deadline }</div>
	City:
	<div>${event.locationCity }</div>
	Address:
	<div>${event.locationAddress }</div>
	Fee:
	<div>${event.fee }</div>


	<form method="get" style="display: inline;"
		action="/bjjinfoaustria/editevent/${event.id }">
		<button type="submit">edit details</button>
	</form>
	</br>
	<div>----------------------------------------------</div>
	</br>
	<c:if test="${event.typeOfEvent=='COMPETITION'}">
		<h2>divisions</h2>
		<c:forEach items="${event.divisions }" var="division">
			<c:if test="${division != null }">
				<tr>
					<td>${division.fullNameCategory }
					<td>
				</tr>
				</br>
				<c:forEach items="${division.competitors }" var="competitor">
					<td>${competitor.user.firstName }</td>
					<td>${competitor.user.lastName }</td>
					</br>
				</c:forEach>
			</c:if>
		</c:forEach>

	</c:if>

	<c:if test="${event.typeOfEvent=='SEMINAR'}">
		<h2>list of participants</h2>
		<c:forEach items="${event.divisions.get(1).competitors }"
			var="participant">
			<tr>
				<td>${participant.user.firstName }
				<td>
				<td>${participant.user.lastName }
				<td>
			</tr>
			</br>
		</c:forEach>
	</c:if>



	<f:form action="/bjjinfoaustria/events" method="get">
		<button type="submit">back</button>
	</f:form>
</body>
</html>