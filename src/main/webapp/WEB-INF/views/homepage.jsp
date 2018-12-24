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

	<h2>hello ${pageContext.request.remoteUser}</h2>

	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form style="display: inline;" method="get"
			action="javascript:document.getElementById('logout').submit()">
			<button type="submit">Log out</button>
		</form>

		<!--  <a class="button"
			href="javascript:document.getElementById('logout').submit()">Logout</a>-->
	</c:if>
	<f:form style="display: inline;" action="${contextPath }/search"
		method="get">
		<button type="submit">gyms</button>
	</f:form>

	<f:form style="display: inline;" action="${contextPath }/events"
		method="get">
		<button type="submit">events</button>
	</f:form>
	<f:form style="display: inline;"
		action="${contextPath }/displayuserpage" method="get">

		<button type="submit">user page</button>
	</f:form>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<f:form style="display: inline;" action="${contextPath }/adminpage"
			method="get">
			<button type="submit">admin page</button>
		</f:form>
	</sec:authorize>
	</br>

	<h2>news</h2>

</body>
</html>
