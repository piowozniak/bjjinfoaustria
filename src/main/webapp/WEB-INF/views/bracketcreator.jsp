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
	<div>
		<h2>${bracket.division.fullNameCategory }</h2>
		<c:forEach items="${bracket.temporaryListOfCompetitors}"
			var="competitor" varStatus="list">
			<td>${competitor.user.firstName }</td>
			<td>${competitor.user.lastName }</td>
			<f:form style="display: inline"
				action="/bjjinfoaustria/addcompetitortobracket/${list.index }"
				method="get">
				<button type="submit">add</button>
			</f:form>

			</br>
		</c:forEach>
	</div>
	<div>

		<c:forEach items="${bracket.fights }" var="fight" varStatus="count">
			<h3>fight ${count.count }</h3>
			<c:forEach items="${fight.competitors }" var="competitor">
				<c:if test="${competitor != null }">
				<td>${competitor.user.firstName }</td>
				<td>${competitor.user.lastName }</td>
				<f:form style="display: inline"
					action="/bjjinfoaustria/removecompetitorfrombracket/${competitor.id }"
					method="get">
					<button type="submit">remove</button>
				</f:form>
				</c:if>
				</br>
			</c:forEach>
			<div>----------------------</div>
			<div>----------------------</div>
		</c:forEach>
	</div>


</body>
</html>
