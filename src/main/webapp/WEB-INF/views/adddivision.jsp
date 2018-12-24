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
	<h2>divisions creator</h2>

	<!--  dodawanie do eventu  -->
	<f:form action="${contextPath }/adddivision" method="post" modelAttribute="division">
		<div>
			Id:
			<f:input path="id" disabled="true"/>
		</div>
		<div>
			Belt Category:
			<f:select  path="beltCategory" items="${ beltCategories}" />
		</div>
		<div>
			Weight Category:
			<f:select path="weightCategory" items="${ weightCategories}" />
		</div>
		<div>
			Event / competition:
			<f:input disabled="true" path="event.id" item="${event }" itemLabel="nameOfEvent" itemValue="id"/>
		</div>
		
		
		<div>
			<f:hidden path="id" />
			
		</div>
		<div>
			<f:hidden path="event.id" />
			
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		<button type="submit">submit</button>
	</f:form>
	<f:form action="${contextPath }/createcompetition" method="get">
		<button type="submit">back</button>
	</f:form>

</body>
</html>
