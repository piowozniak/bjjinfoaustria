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
	<f:form action="${contextPath }/adduser" method="post" modelAttribute="user">
		<div>
			Id:
			<f:input path="id" disabled="true"/>
		</div>
		<div>
			First name:
			<f:input path="firstName" />
		</div>
		<div>
			Last name:
			<f:input path="lastName" />
		</div>
		<div>
			Phone number:
			<f:input path="phoneNumber" />
		</div>
		<div>
			Email:
			<f:input path="email" />
		</div>
		
		<div>
			<f:hidden path="id" />
		</div>
		<button type="submit">submit</button>
	</f:form>
	<f:form action="${contextPath }/events" method="get">
		<button type="submit">back</button>
	</f:form>

</body>
</html>
