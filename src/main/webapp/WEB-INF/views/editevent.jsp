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
	<h2>edit event</h2>
	<c:if test="${!displayDraftOrSubmitField }">

		<f:form action="${contextPath }/editevent" method="post"
			modelAttribute="event">
			<div>
				Id:
				<f:input path="id" disabled="true" />
			</div>
			<div>
				Event name:
				<f:input path="nameOfEvent" />
			</div>
			<div>
				Organizer:
				<f:input disabled = "true" path="organizer" />
			</div>
			<div>
				Host:
				<f:input path="host" />
			</div>
			<div>
				Type of event:
				<f:input path="typeOfEvent" disabled="true" />
			</div>

		Start date:
		<div>
				<f:input path="startDate" />
			</div>
		End date:
		<f:input path="endDate" />
			<div>
				<div>
					Start hour:
					<f:input path="startHour" />
				</div>
				<div>
					Deadline:
					<f:input path="deadline" />
				</div>
				<div>
					City:
					<f:input path="locationCity" />
				</div>
				<div>
					Address:
					<f:input path="locationAddress" />
				</div>
				<div>
					Fee:
					<f:input path="fee" />
				</div>
				<div>
					<f:hidden path="id" />
				</div>
				<div>
					<f:hidden path="typeOfEvent" />
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<button type="submit">save details</button>
		</f:form>
		</br>

		<c:if test="${event.typeOfEvent == 'COMPETITION' }">
			<h3>list of divisions</h3>
			<c:forEach items="${temporaryListOfDivisions }" var="division">
				<c:if test="${division != null}">
					<td>${division.fullNameCategory }</td>

				</c:if>
			</c:forEach>
		</c:if>
	</c:if>
	<c:if test="${displayDraftOrSubmitField }">
		<div>would you like to save as draft or submit? (if you submit
			you will be no longer able to edit)</div>
		<f:form method="post" action="${contextPath }/editconfirmation/SUBMITTED">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">submit</button>
		</f:form>
		<f:form method="post" action="${contextPath }/editconfirmation/DRAFT">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">save as draft</button>
		</f:form>
	</c:if>

	<f:form action="${contextPath }/events" method="get">
		<button type="submit">cancel</button>
	</f:form>




</body>
</html>
