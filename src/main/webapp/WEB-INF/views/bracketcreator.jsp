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
	<h2>bracket creator</h2>
	<f:form action="/bjjinfoaustria/displaydivision" method="get">

		<select name="divisionId" id="divisionId">
			<c:forEach items="${divisions}" var="division">
				<option name="divisionId" value="${division.division.id}">${division.division.fullNameCategory}</option>
			</c:forEach>
		</select>
		<button type="submit">display</button>
	</f:form>
	<h2>${division.division.fullNameCategory }</h2>
	<c:forEach items="${division.ddivision.competitors}" var="competitor">
		<td>${competitor.user.firstName }</td>
		<td>${competitor.user.lastName }</td>
		</br>
	</c:forEach>


</body>
</html>
