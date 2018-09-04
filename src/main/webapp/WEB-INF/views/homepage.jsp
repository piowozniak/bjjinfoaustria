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
	<h2>hello</h2>
	<!-- lista wszystkich -->
	<f:form method="delete" action="/bookstore/delete">
	<c:forEach items="${gyms}" var="gym">
		<div>
			<tr>
				<td>${gym.name}</td>
				<td>${gym.city}</td>
				<td>${gym.region}</td>
				<td>${gym.address}</td>
				<td>${gym.phoneNumber}</td>
				<td>${gym.headCoach}</td>			
								
			</tr>
		</div>
	</c:forEach>
	</f:form>
	<a href="/bookstore/search">search gyms</a></br>
	<a href="/bookstore/add">add</a>
	<f:form action="/bookstore/add" method="get">
		<button type="submit">add</button>
	</f:form>
</body>
</html>
