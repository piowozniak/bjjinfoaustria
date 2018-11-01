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
	<c:forEach items="${division.rounds }" var="round"
		varStatus="roundIndex">
		<div style="display: inline-block;">
			
			<h3>round ${roundIndex.index }</h3>
			<c:if test="${!round.nextRound }">
			<c:forEach items="${round.fightsInRound }" var="fight"
				varStatus="fightIndex">
				<h3>fight ${fightIndex.count }</h3>
				<c:forEach items="${fight.competitors }" var="competitor"
					varStatus="competitorIndex">
					<td>${competitor.user.firstName }</td>
					<td>${competitor.user.lastName }</td>
					<f:form action="/bjjinfoaustria/addwinnertonextround/${competitor.id }/${fightIndex.index }/${roundIndex.index }"
						method="get">
						<button style="display:inline;"  type="submit">add winner</button>
					</f:form>
				</c:forEach>
				
				<div>----------------------</div>
				<div>----------------------</div>
			</c:forEach>
			</c:if>
			<c:if test="${round.nextRound }">
					<c:forEach items="${round.listOfWinners }" var="winner">
						 <td>${winner.user.firstName }</td>
						<td>${winner.user.lastName }</td>
						</br>
						<div>----------------------</div>
					</c:forEach>
			</c:if>
		</div>
	</c:forEach>



	</div>
	<f:form action="/bjjinfoaustria/eventdetails/${event.id }" method="get">
		<button type="submit">back</button>
	</f:form>

</body>
</html>
