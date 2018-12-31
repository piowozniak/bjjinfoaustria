<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
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

	<h2>search</h2>

	<!--  wyszukiwarka  -->
		<label>State:</label>
	<form style="display: inline;" action="${contextPath }/findbyregion"
		method="get">
		<select name="regionId" id="regionId" onchange="this.form.submit()">
			<option value="">CHOOSE</option>
			<c:forEach items="${regions}" var="region">
				<option value="${region.id}">${region.name}</option>
			</c:forEach>
		</select>
	</form>
	<label>City:</label>
	<form style="display: inline;" action="${contextPath }/findbycity"
		method="get">
		<select name="cityId" id="cityId" onchange="this.form.submit()">
			<option value="">CHOOSE</option>
			<c:forEach items="${cities}" var="city">
				<option value="${city.id}">${city.name}</option>
			</c:forEach>
		</select>
	</form></br>
	<label>Name of the gym:</label>
	<f:form style="display: inline;" action="${contextPath }/gymsbyname" method="get">
		<input name="name" />
		<button type="submit">Search</button>
	</f:form>
	<f:form style="display: inline;" action="${contextPath }/search"
		method="get">
		<button type="submit">reset search</button>
	</f:form>


	<h2 >gyms</h2>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<f:form style="display: inline;" action="${contextPath }/add"
			method="get">
			<button type="submit">add gym</button>
		</f:form>
		</br>
	</sec:authorize>
	<c:forEach items="${gyms}" var="gym">
		<tr>
			<td>${gym.name}</td>
			<td>${gym.city.name}</td>

			<td>${gym.address}</td>
			<td>${gym.phoneNumber}</td>
			<td>${gym.headCoach}</td>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<f:form style="display:inline;" method="get"
					action="${contextPath }/edit/${gym.id }">
					<button type="submit">edit</button>
				</f:form>
				<f:form style="display:inline;" method="get"
					action="${contextPath }/delete/${gym.id }">
					<button type="submit">delete</button>
				</f:form>
			</sec:authorize>
			</br>
			<div>--------------------</div>
		</tr>
		</br>
	</c:forEach>
	<div>
		<a href="${contextPath }/homepage">back</a>
	</div>
</body>
</html>
