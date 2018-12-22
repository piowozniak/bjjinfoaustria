<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${contextPath}/login" class="form-signin">
		<h2 class="form-heading">Log in</h2>

		<div class="form-group ${error != null ? 'has-error' : ''}">
			<span>${message}</span> <input name="userName" type="text"
				class="form-control" placeholder="Username" autofocus="true" /> <input
				name="password" type="password" class="form-control"
				placeholder="Password" /> <span>${error}</span> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />

			<button class="btn btn-lg btn-primary btn-block" type="submit">Log
				In</button>
			<h4 class="text-center">
				<a href="${contextPath}/registration">Create an account</a>
			</h4>
		</div>

	</form>
</body>
</html>