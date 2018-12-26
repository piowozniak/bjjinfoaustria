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
	<h2>confirm</h2>

	<!--  usuwanie gym  -->
	<f:form action="${contextPath}/delete" method="delete" modelAttribute="gym">
		<p>Are you sure you want to delete gym ${gym.name }?</p>
		<div>
			<input type="submit" value="confirm">
		</div>
		<div>
			<f:hidden path="id" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</f:form>
	<f:form action="${contextPath}/search" method="get">
		<button type="submit">cancel</button>
	</f:form>


</body>
</html>
