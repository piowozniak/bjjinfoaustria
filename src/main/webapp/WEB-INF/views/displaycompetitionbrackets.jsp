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
	<h2>brackets</h2>
	<f:form action="/bjjinfoaustria/displaydivisionincompetition"
		method="get">

		<select name="divisionId" id="divisionId">
			<c:forEach items="${listOfDivisions}" var="division">
				<option name="divisionId" value="${division.division.id}">${division.division.fullNameCategory}</option>
			</c:forEach>
		</select>
		<button type="submit">display</button>
	</f:form>
	<c:forEach items="${division.rounds }"  var="round" varStatus="roundIndex">
		<div style="">
		<h3>round ${roundIndex.index }</h3>
			<c:forEach items="${round.fightsInRound }" var="fight"
				varStatus="fightIndex">
				<h3>fight ${fightIndex.count }</h3>
				<c:forEach items="${fight.competitors }" var="competitor"
					varStatus="competitorIndex">
					<td>${competitor.user.firstName }</td>
					<td>${competitor.user.lastName }</td>
					</br>
				</c:forEach>
				<div>----------------------</div>
				<div>----------------------</div>
			</c:forEach>
		</div>
	</c:forEach>



	</div>
	<f:form action="/bjjinfoaustria/eventdetails/${event.id }" method="get">
		<button type="submit">back</button>
	</f:form>

</body>
</html>
