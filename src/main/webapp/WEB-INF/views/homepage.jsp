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
	<h2>hello</h2>
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

	<f:form action="/bjjinfoaustria/search" method="get">
		<button type="submit">search</button>
	</f:form>
	<f:form action="/bjjinfoaustria/add" method="get">
		<button type="submit">add</button>
	</f:form>
	<f:form action="/bjjinfoaustria/events" method="get">
		<button type="submit">events</button>
	</f:form>
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
</body>
</html>
