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
	<h2>confirm</h2>

	<!--  usuwanie gym  -->
	<f:form action="/bjjinfoaustria/deleteuser" method="post" modelAttribute="user">
		<p>Are you sure you want to delete user ${user.firstName }?</p>

		<div>
			<f:hidden path="id" />
		</div>
		<button type="submit">confirm</button>
	</f:form>
	<f:form action="/bjjinfoaustria/events" method="get">
		<button type="submit">cancel</button>
	</f:form>


</body>
</html>
