<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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

	<c:if
		test="${event.status == 'DRAFT' && pageContext.request.remoteUser == event.organizer }">
		<form method="get" style="display: inline;"
			action="${contextPath }/editevent/${event.id }">
			<button type="submit">edit details</button>
		</form>
	</c:if>
	</br>
	<div>----------------------------------------------</div>
	</br>
	<c:if test="${isCloseRegistrationAvailable }">
		<div>are you sure you would like to close registration?</div>
		<f:form method="post" modelAttribute="event"
			action="${contextPath }/closeregistration/${event.id }">
			<button type="submit">confirm</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</f:form>
		<f:form method="get" action="${contextPath }/eventdetails/${event.id }">
			<button type="submit">cancel</button>
		</f:form>
	</c:if>
	<c:if
		test="${event.status == 'DRAFT' && event.typeOfEvent == 'COMPETITION' && pageContext.request.remoteUser == event.organizer }">
		<f:form action="${contextPath }/editdivisions/${event.id }"
			method="get">
			<button type="submit">edit divisions</button>

		</f:form>
	</c:if>
	<sec:authorize access="hasRole('ROLE_USER')">
		<c:if
			test="${((event.status == 'ACTIVE' && !isUserAddedToEvent && event.registrationAvailable == 'T') 
			|| (event.status == 'ACTIVE' && event.registrationAvailable == 'T' && event.registrationAvailable == 'T')) && !isCloseRegistrationAvailable}">
			<form method="get" style="display: inline;"
				action="${contextPath }/addusertoevent/${event.id }">
				<button type="submit">join ${event.typeOfEvent }</button>
			</form>
		</c:if>
		<c:if
			test="${isUserAddedToEvent && (event.typeOfEvent == 'CAMP' || event.typeOfEvent == 'SEMINAR') }">
			<form method="post" style="display: inline;"
				action="${contextPath }/removeuserfromevent/${event.id }">
				<button type="submit">leave ${event.typeOfEvent }</button>
			</form>
		</c:if>
	</sec:authorize>
	<c:if
		test="${event.status == 'ACTIVE' && event.typeOfEvent == 'COMPETITION' &&  event.registrationAvailable == 'N' && pageContext.request.remoteUser == event.organizer }">
		<f:form action="${contextPath }/createbrackets/${event.id}"
			method="get">
			<button type="submit">create brackets</button>
		</f:form>
	</c:if>
	<c:if
		test="${event.status == 'RELEASED' && event.typeOfEvent == 'COMPETITION' }">
		<f:form action="${contextPath }/displaybrackets/${event.id}"
			method="get">
			<button type="submit">display brackets</button>
		</f:form>
	</c:if>
	<c:if
		test="${event.status == 'ACTIVE' && event.registrationAvailable == 'T' && !isCloseRegistrationAvailable && pageContext.request.remoteUser == event.organizer}">
		<f:form action="${contextPath }/closeregistration" method="get">
			<button type="submit">close registration</button>
		</f:form>
	</c:if>
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
	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')">
		<c:if
			test="${event.typeOfEvent=='SEMINAR' || event.typeOfEvent == 'CAMP'}">
			<h2>list of participants</h2>
			<c:forEach items="${event.divisions }" var="division">
				<c:forEach items="${division.competitors }" var="participant">
					<c:if test="${participant != null }">
						<tr>

							<td>${participant.user.firstName }</td>
							<td>${participant.user.lastName }</td>
							<td>${participant.user.email }</td>
							<td>${participant.status }</td>
							<c:if test="${participant.status == 'SUBMITTED' }">
								<f:form style="display:inline;"
									action="${contextPath }/activateuserinevent/${participant.id }"
									method="post">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<button type="submit">accept participant</button>
								</f:form>
							</c:if>
						</tr>
					</c:if>
					</br>
				</c:forEach>
			</c:forEach>
		</c:if>
	</sec:authorize>
	<f:form action="${contextPath }/events" method="get">
		<button type="submit">back</button>
	</f:form>
</body>
</html>