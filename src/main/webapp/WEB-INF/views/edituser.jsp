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
	<h2>edit user details</h2>

	<f:form action="/bjjinfoaustria/edituserconfirmation" method="post"
		modelAttribute="user">
		<div>
			Id:
			<f:input path="id" disabled="true" />
		</div>
		<div>
			User name:
			<f:input path="userName" />
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
			Status:
			<f:input path="status" disabled="true" />
		</div>


		<div>
			<f:hidden path="id" />
		</div>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button type="submit">submit</button>
	</f:form>
	<f:form action="/bjjinfoaustria/adminpage" method="get">
		<button type="submit">back</button>
	</f:form>


</body>
</html>
