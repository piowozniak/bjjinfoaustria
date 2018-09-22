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
	<h2>competition</h2>
	<!--  dodawanie competition  -->
	<f:form action="/bjjinfoaustria/createcompetition" method="post"
		modelAttribute="event">
		<h3>${event.nameOfEvent }</h3>
		<div>
			Id:
			<f:input path="id" disabled="true" />
		</div>

		<div>
			<f:hidden path="id" />
		</div>
		<button type="submit">submit</button>

	</f:form>
	<f:form action="/bjjinfoaustria/adddivision/${event.id}"
		method="get">
		<button type="submit">add division</button>
	</f:form>
	<c:forEach items="${listOfDivisions }" var="division">
		<tr>
			<td>${division.beltCategory }</td>
			<td>${division.weightCategory }</td>
		</tr></br>
	</c:forEach>



	<f:form action="/bjjinfoaustria/events" method="get">
		<button type="submit">back</button>
	</f:form>




</body>
</html>
