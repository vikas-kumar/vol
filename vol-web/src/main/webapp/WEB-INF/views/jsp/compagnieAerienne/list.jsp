<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<title><spring:message code="compagnieAerienne.list.title"/></title>
</head>
<body> 

	<div class="container">
		<h2><spring:message code="compagnieAerienne.list.page"/></h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><spring:message code="compagnieAerienne.list.id"/></th>
					<th><spring:message code="compagnieAerienne.list.nom"/></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${compagnieaerienne}" var="ville">
					<c:url var="editUrl" value="/compagnieaerienne/edit">
						<c:param name="id">${ville.id}</c:param>
					</c:url>
					<c:url var="deleteUrl" value="/compagnieaerienne/delete">
						<c:param name="id">${ville.id}</c:param>
					</c:url>
					<tr>
						<td>${ville.id}</td>
						<td>${ville.nom}</td>
						<td><a class="btn btn-primary btn-xs" href="${editUrl}"><span class="glyphicon glyphicon-pencil"></span></a> <a class="btn btn-danger btn-xs" href="${deleteUrl}"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-info btn-md" href="<c:url value="/compagnieaerienne/add"/>"> <span
			class="glyphicon glyphicon-plus"></span>
		</a>
	</div>
</body>
</html>