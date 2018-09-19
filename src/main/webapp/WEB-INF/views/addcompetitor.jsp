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
	<h2>join the event</h2>

	<!--  dodawanie do competitora  -->
	<f:form action="/bjjinfoaustria/addcompetitor" method="post"
		modelAttribute="eventUsers">

		<div>
			Event:
			<h3>${eventUsers.idEventu}</h3>
		</div>
		<div>
			Users:
			<f:select path="idUsera" items="${participants}"
				itemLabel="firstName" itemValue="id" />
		</div>
		<div>
			Divisions:
			<f:select path="division.id" items="${divisions}"
				itemLabel="fullNameCategory" itemValue="id" />
		</div>

		<div>
			<f:hidden path="id" />
		</div>
		<div>
			<f:hidden path="idEventu" />
		</div>
		<button type="submit">submit</button>
	</f:form>
	<f:form action="/bjjinfoaustria/events" method="get">
		<button type="submit">back</button>
	</f:form>

</body>
</html>
