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
	<h3>${event.status }</h3>
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

	<c:if test="${event.status == 'DRAFT' }">
		<form method="get" style="display: inline;"
			action="/bjjinfoaustria/editevent/${event.id }">
			<button type="submit">edit details</button>
		</form>
	</c:if>
	</br>
	<div>----------------------------------------------</div>
	</br>
	<c:if test="${event.status == 'DRAFT' }">
		<f:form action="/bjjinfoaustria/editdivisions/${event.id }"
			method="get">
			<button type="submit">edit divisions</button>

		</f:form>
	</c:if>
	<c:if test="${event.status == 'SUBMITTED' }">
		<f:form action="/bjjinfoaustria/createbrackets/${event.id}"
			method="get">
			<button type="submit">create brackets</button>
		</f:form>
	</c:if>
	<f:form action="/bjjinfoaustria/displaybrackets/${event.id}"
		method="get">
		<button type="submit">display brackets</button>
	</f:form>
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
		<c:forEach items="${event.divisions }" var="division">
			<c:forEach items="${division.competitors }" var="participant">
				<c:if test="${participant != null }">
					<tr>
						<td>${participant.user.firstName }</td>
						<td>${participant.user.lastName }</td>
						<td>${participant.user.email }</td>
						<td>${participant.status }</td>					
						<f:form action="/bjjinfoaustria/activateuserinevent/${participant.id }"
							method="get">
							<button type="submit">accept participant</button>
						</f:form>
					</tr>
				</c:if>
				</br>
			</c:forEach>
		</c:forEach>
	</c:if>



	<f:form action="/bjjinfoaustria/events" method="get">
		<button type="submit">back</button>
	</f:form>
</body>
</html>