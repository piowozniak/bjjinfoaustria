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
	<h2>events</h2>
	<f:form action="${contextPath }/displayevents" method="get">
		<!-- <label for="camps_id">Camps</label>
		<input id="camps_id" type="checkbox" name="displayCamps" />
		<input type="checkbox" name="displaySeminars" />
		<input type="checkbox" name="displayCompetitions" />-->
		<c:forEach items="${displayEvents}" var="displayEvent"
			varStatus="count">
			<label for="${count.count }">${displayEvent }</label>
			<input id="${count.count }" type="checkbox" value="${displayEvent }"
				name="${displayEvent }s" />
		</c:forEach>

		<button type="submit">display</button>
	</f:form>
	<c:forEach items="${events }" var="event">
		<tr>
			<td>${event.nameOfEvent }</td>
			<td>${event.typeOfEvent }</td>
			<td>${event.status }</td>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<c:if test="${event.status != 'DRAFT' }">
					<form method="post" style="display: inline;"
						action="${contextPath }/activateordeactivateevent/${event.id }">
						<button type="submit">
							<c:if
								test="${event.status == 'SUBMITTED' || event.status == 'NONACTIVE'}">						
						activate event
					</c:if>
							<c:if test="${event.status == 'ACTIVE' }">
						deactivate event
					</c:if>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</button>
					</form>
				</c:if>
			</sec:authorize>
			<c:if test="${event.status == 'ACTIVE'}">
				<form method="get" style="display: inline;"
					action="${contextPath }/addusertoevent/${event.id }">
					<button type="submit">add user to event</button>
				</form>
			</c:if>


			<form method="get" style="display: inline;"
				action="${contextPath }/eventdetails/${event.id }">
				<button type="submit">details</button>
			</form>

		</tr>
		</br>

		<div>----------------------------------------------</div>
		</br>
	</c:forEach>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')">
		<form method="get" action="${contextPath }/createevent">
			<button type="submit">add event</button>
		</form>
	</sec:authorize>
	<form method="get" action="${contextPath }/homepage">
		<button type="submit">back</button>
	</form>



</body>
</html>
