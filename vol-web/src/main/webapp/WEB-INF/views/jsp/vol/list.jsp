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
<title><spring:message code="vol.list.title"/></title>
</head>
<body> 

	<div class="container">
		<h2><spring:message code="vol.list.page"/></h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><spring:message code="vol.list.id"/></th>
					<th><spring:message code="vol.list.dateDepart"/></th>
					<th><spring:message code="vol.list.dateArrivee"/></th>
					<th><spring:message code="vol.list.heureDepart"/></th>
					<th><spring:message code="vol.list.heureArrivee"/></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vol}" var="vol">
					<c:url var="editUrl" value="/vol/edit">
						<c:param name="id">${vol.id}</c:param>
					</c:url>
					<c:url var="deleteUrl" value="/vol/delete">
						<c:param name="id">${vol.id}</c:param>
					</c:url>
					<tr>
						<td>${vol.id}</td>
						<td>${vol.dateDepart}</td>
						<td>${vol.dateArrivee}</td>
						<td>${vol.heureDepart}</td>
						<td>${vol.heureArrivee}</td>
						<td><a class="btn btn-primary btn-xs" href="${editUrl}"><span class="glyphicon glyphicon-pencil"></span></a> <a class="btn btn-danger btn-xs" href="${deleteUrl}"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-info btn-md" href="<c:url value="/vol/add"/>"> <span
			class="glyphicon glyphicon-plus"></span>
		</a>
	</div>
</body>
</html>