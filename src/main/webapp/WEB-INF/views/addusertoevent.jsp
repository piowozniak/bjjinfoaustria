<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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

	<!--  dodawanie do eventu  -->
	<f:form action="${contextPath }/addusertoevent" method="post"
		modelAttribute="eventUsersDTO">

		<div>
			Event:
			<h3>${event.nameOfEvent}</h3>
		</div>
		
		<c:if test="${event.typeOfEvent == 'COMPETITION' }">
			<div>
				Divisions:
				<f:select path="division.id" items="${divisions}"
					itemLabel="fullNameCategory" itemValue="id" />
			</div>
		</c:if>

		<div>
			<f:hidden path="id" />
		</div>
		<div>
			<f:hidden path="event.id" />
		</div>
		<div>
			<f:hidden path="event.typeOfEvent" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button type="submit">submit</button>
	</f:form>
	<f:form action="${contextPath }/events" method="get">
		<button type="submit">back</button>
	</f:form>

</body>
</html>
