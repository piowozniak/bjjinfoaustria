<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin page</title>
</head>
<body>
	<h2>admin page</h2>
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
	</br>
	<h3>users</h3>
	<c:if test="${displayUserConfirmation }">
		<div>confirmation</div>
		<c:choose>
			<c:when test="${user.status=='N' }">
				<p>activate user ${user.username } ?</p>
			</c:when>
			<c:otherwise>
				<p>deactivate user ${user.username } ?</p>
			</c:otherwise>
		</c:choose>
		<f:form method="post" modelAttribute="user"
			action="${contextPath }/confirmuseractivation?id=${user.id}">
			<button type="submit">confirm</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div>
				<f:hidden path="id" />
			</div>
		</f:form>
		<f:form method="get" action="${contextPath }/adminpage">
			<button type="submit">cancel</button>
		</f:form>
	</c:if>

	<c:forEach var="user" items="${allUsers }">
		<td>${user.username }</td>
		<td>${user.firstName }</td>
		<td>${user.lastName }</td>
		<td>${user.status }</td>

		<f:form style="display: inline;"
			action="${contextPath }/activateuser/${user.id }" method="get">
			<button type="submit">
				<c:if test="${user.status == 'N' }">activate user</c:if>
				<c:if test="${user.status == 'A' }">deactivate user</c:if>
			</button>
		</f:form>
		
		<f:form style="display: inline;"
			action="${contextPath }/edituser/${user.id}" method="get">
			
			<button type="submit">edit user</button>
		</f:form>
		</br>

	</c:forEach>



</body>
</html>