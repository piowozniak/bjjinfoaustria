<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user page</title>
</head>
<body>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form style="display: inline;" method="get"
			action="javascript:document.getElementById('logout').submit()">
			<button type="submit">Log out</button>
		</form>

		<!--  <a class="button"
			href="javascript:document.getElementById('logout').submit()">Logout</a>-->
	</c:if>
	<f:form style="display: inline;" action="${contextPath }/homepage"
		method="get">
		<button type="submit">homepage</button>
	</f:form>
	<f:form style="display: inline;" action="${contextPath }/search"
		method="get">
		<button type="submit">gyms</button>
	</f:form>
	<f:form style="display: inline;" action="${contextPath }/events"
		method="get">
		<button type="submit">events</button>
	</f:form>
	
	<h2>${pageContext.request.remoteUser}page</h2>
	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<f:form style="display:inline;" method="get"
		action="${contextPath }/displayuserdetails">
		<button type="submit">display user details</button>
	</f:form>
	<f:form style="display:inline;" method="get"
		action="${contextPath }/displayusersevents">
		<button type="submit">display your events</button>
	</f:form>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')">
		<f:form style="display:inline;" method="get"
			action="${contextPath }/displaycreatedevents">
			<button type="submit">created events</button>
		</f:form>
	</sec:authorize>


	<c:if test="${displayedUserDetails }">
		<h2>user details</h2>
		<td>${user.firstName }</td>
		<td>${user.lastName}</td>
		<td>${user.email }</td>
		<td>${user.phoneNumber }</td>
		<f:form method="get"
			action="${contextPath }/edituserdetails?id=${user.id }">
			<button type="submit">edit details</button>
		</f:form>
	</c:if>
	<c:if test="${displayedEventsList }">
		<h2>your events</h2>
		<c:forEach items="${ listOfEventsUserSignedUp}" var="event">
			<td>${event.nameOfEvent }</td>
			<td>${event.typeOfEvent }</td>
			</br>
			<td>------------------------</td>
			</br>
		</c:forEach>
	</c:if>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')">
		<c:if test="${displayedCreatedEvents }">
			<h2>your created events</h2>
			<c:forEach items="${ listOfCreatedEvents}" var="event">
				<td>${event.nameOfEvent }</td>
				<td>${event.typeOfEvent }</td>
				<td>${event.status }</td>
				<form method="get" style="display: inline;"
					action="${contextPath }/eventdetails/${event.id }">
					<button type="submit">details</button>
				</form>
				</br>
				<td>-----------------------</td>
				</br>
			</c:forEach>
			<form method="get" action="${contextPath }/createevent">
				<button type="submit">add event</button>
			</form>
		</c:if>
	</sec:authorize>


</body>
</html>