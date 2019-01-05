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
	<h2>edit user details</h2>

	<f:form action="${contextPath }/edituserconfirmation" method="post"
		modelAttribute="user">
		<div>
			Id:
			<f:input path="id" disabled="true" />
		</div>
		<div>
			User name:
			<f:input path="username" />
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
		<button type="submit">save</button>
	</f:form>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<f:form action="${contextPath }/adminpage" method="get">
			<button type="submit">back to admin page</button>
		</f:form>
	</sec:authorize>
	<f:form action="${contextPath }/displayuserpage" method="get">
		<button type="submit">back to user page</button>
	</f:form>
	<div>------------</div>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h3>user roles:</h3>
		<c:forEach items="${user.roles }" var="role">
			<td>${role.name }</td>
			</br>
		</c:forEach>
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
		<f:form style="display: inline;"
			action="${contextPath }/activateuser/${user.id }" method="get">
			<button type="submit">
				<c:if test="${user.status == 'N' }">activate user</c:if>
				<c:if test="${user.status == 'A' }">deactivate user</c:if>
			</button>
		</f:form>
		<c:if test="${user.roles.size() < 2 && user.status == 'A'}">
			<f:form style="display: inline;"
				action="${contextPath }/giverole/${user.id}" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<button type="submit">give organizer role</button>
			</f:form>
		</c:if>
	</sec:authorize>

</body>
</html>
