<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<title><spring:message code="reservation.edit.title" /></title>
</head>
<body>

	<div class="container">
		<fieldset>
			<legend>
				<spring:message code="reservation.edit.form" />
			</legend>
			<form:form modelAttribute="reservation" action="save" method="post">
				<form:hidden class="form-control" path="id" />
				<form:hidden class="form-control" path="version" />
				<div class="form-group">
					<form:label path="date">
						<spring:message code="reservation.edit.date" />:</form:label>
					<form:input type="date" pattern="yyyy-MM-dd" class="form-control"
						path="date" />
					<form:errors path="date" class="help-block" />
				</div>
				<div class="form-group">
					<form:label path="numero">
						<spring:message code="reservation.edit.numero" />:</form:label>
					<form:input type="number" class="form-control" path="numero" />
					<form:errors path="numero" class="help-block" />
				</div>

				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-ok"></span>
				</button>
				<a href="<c:url value="/reservation/cancel"/>"
					class="btn btn-warning"><span
					class="glyphicon glyphicon-remove"></span></a>
			</form:form>
		</fieldset>
	</div>
</body>
</html>