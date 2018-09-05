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
	<h2>search</h2>

		<!--  wyszukiwarka  -->
	<f:form action="/bjjinfoaustria/gymsbycity" method="get">
		<input name="name" />
		<select name="city">
		<option value="">CHOOSE</option>
			<c:forEach items="${cities}" var="city">
				<option value="${city}">${city}</option>
			</c:forEach>
		</select>
		<select name="region">
		<option value="">CHOOSE</option>
			<c:forEach items="${regions}" var="region">
				<option value="${region}">${region}</option>
			</c:forEach>
		</select>

		<button type="submit">Search</button>
	</f:form>
	<h2>gyms</h2>
	<c:forEach items="${gyms}" var="gym">
		<tr>
			<td>${gym.name}</td>
			<td>${gym.city}</td>
			<td>${gym.region}</td>
			<td>${gym.address}</td>
			<td>${gym.phoneNumber}</td>
			<td>${gym.headCoach}</td>
			<a href="/bjjinfoaustria/edit/${gym.id }">edit</a>
			<a href="/bjjinfoaustria/delete/${gym.id }">delete</a>
		</tr></br>
	</c:forEach>
<div><a href="/bjjinfoaustria/">back</a></div>
</body>
</html>
