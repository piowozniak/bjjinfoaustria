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
	<h2>add event</h2>
	<!--  dodawanie event  -->
	<f:form action="${contextPath }/createevent" method="post"
		modelAttribute="event">
		<div>
			Id:
			<f:input path="id" disabled="true" />
		</div>
		<div>
			Organizer:
			<f:input value="${pageContext.request.remoteUser}" path="organizer" disabled="true"/>
		</div>
		<div>
			Event name:
			<f:input path="nameOfEvent" />
		</div>
		
		<div>
			Host:
			<f:input path="host" />
		</div>
		<div>
			Type of event:
			<f:select path="typeOfEvent" items="${listOfEvents}" />
		</div>

		Start date:
		<f:input path="startDate" />
		<div></div>
		End date:
		<f:input path="endDate" />
		<div>
			<div>
				Start hour:
				<f:input path="startHour" />
			</div>
			<div>
				Deadline:
				<f:input path="deadline" />
			</div>
			<div>
				City:
				<f:input path="locationCity" />
			</div>
			<div>
				Address:
				<f:input path="locationAddress" />
			</div>
			<div>
				Fee:
				<f:input path="fee" />
			</div>
			<div>
				<f:hidden path="id" />
			</div>
			<button type="submit">submit</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
	</f:form>
	<f:form action="${contextPath }/events" method="get">
		<button type="submit">cancel</button>
	</f:form>
</body>
</html>
