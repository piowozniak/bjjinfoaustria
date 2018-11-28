<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


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

	<h2>hello ${pageContext.request.remoteUser}</h2>

	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p>tego nie zobaczy zwykly user</p>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<p>a to tak</p>
	</sec:authorize>
	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form style="display: inline;" method="get"
			action="javascript:document.getElementById('logout').submit()">
			<button type="submit">Log out</button>
		</form>
		
		<!--  <a class="button"
			href="javascript:document.getElementById('logout').submit()">Logout</a>-->
	</c:if>
	<f:form style="display: inline;" action="/bjjinfoaustria/search" method="get">
			<button type="submit">gyms</button>
		</f:form>
		
		<f:form style="display: inline;" action="/bjjinfoaustria/events" method="get">
			<button type="submit">events</button>
		</f:form>
		<f:form style="display: inline;" action="/bjjinfoaustria/adminpage" method="get">
			<button type="submit">admin page</button>
		</f:form>
	</br>
	
	<h2>news</h2>
	<!-- lista wszystkich -->
	<f:form method="delete" action="/bjjinfoaustria/delete">
		<c:forEach items="${gyms}" var="gym">
			<div>
				<tr>
					<td>${gym.name}</td>
					<td>${gym.city}</td>
					<td>${gym.region}</td>
					<td>${gym.address}</td>
					<td>${gym.phoneNumber}</td>
					<td>${gym.headCoach}</td>

				</tr>
				</br>
				<div>--------------------</div>
		</c:forEach>
	</f:form>


	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h2>users</h2>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.firstName }</td>
				<td>${user.lastName }</td>
				<td>${user.email }</td>
				<td>${user.phoneNumber }</td>
				<form method="get" style="display: inline;"
					action="/bjjinfoaustria/deleteuser/${user.id }">
					<button type="submit">delete user</button>
				</form>
			</tr>
			</br>

		</c:forEach>
	</sec:authorize>
</body>
</html>
