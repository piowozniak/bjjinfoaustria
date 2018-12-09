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
	<h2>events</h2>

	<c:forEach items="${events }" var="event">
		<tr>
			<td>${event.nameOfEvent }</td>
			<td>${event.typeOfEvent }</td>
			<td>${event.status }</td>

			<c:if test="${event.status != 'DRAFT' }">
				<form method="post" style="display: inline;"
					action="/bjjinfoaustria/activateordeactivateevent/${event.id }">
					<button type="submit">
						<c:if
							test="${event.status == 'SUBMITTED' || event.status == 'NONACTIVE'}">						
						activate event
					</c:if>
						<c:if test="${event.status == 'ACTIVE' }">
						deactivate event
					</c:if>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</button>
				</form>
			</c:if>
			<c:if test="${event.status == 'ACTIVE'}">
				<form method="get" style="display: inline;"
					action="/bjjinfoaustria/addusertoevent/${event.id }">
					<button type="submit">join the event</button>
				</form>
			</c:if>

			<form method="get" style="display: inline;"
				action="/bjjinfoaustria/eventdetails/${event.id }">
				<button type="submit">details</button>
			</form>

		</tr>
		</br>

		<div>----------------------------------------------</div>
		</br>
	</c:forEach>
	<form method="get" action="/bjjinfoaustria/createevent">
		<button type="submit">add event</button>
	</form>
	<form method="get" action="/bjjinfoaustria/">
		<button type="submit">back</button>
	</form>



</body>
</html>
