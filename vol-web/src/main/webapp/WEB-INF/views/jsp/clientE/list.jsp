<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<title><spring:message code="clientE.list.title"/></title>
</head>
<body>
<div class="container">
		<h2><spring:message code="clientE.list.table"/></h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><spring:message code="clientE.list.id"/></th>
					<th><spring:message code="clientE.list.nom"/></th>
					<th><spring:message code="clientE.list.prenom"/></th>
					<th><spring:message code="clientE.list.numeroTel"/></th>
					<th><spring:message code="clientE.list.numeroFax"/></th>
					<th><spring:message code="clientE.list.email"/></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clients}" var="clientE">
					<c:url var="editUrl" value="/clientE/edit">
						<c:param name="id">${client.id}</c:param>
					</c:url>
					<c:url var="deleteUrl" value="/clientE/delete">
						<c:param name="id">${client.id}</c:param>
					</c:url>
					<tr>
						<td>${client.id}</td>
						<td>${client.nom}</td>
						<td>${clientEI.prenom}</td>
						<td>${client.numeroTel}</td>
						<td>${client.numeroFax}</td>
						<td>${client.email}</td>
						<td><a class="btn btn-primary btn-xs" href="${editUrl}"><span class="glyphicon glyphicon-pencil"></span></a><a class="btn btn-danger btn-xs" href="${deleteUrl}"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-info btn-md" href="<c:url value="/clientE/add"/>"> <span
			class="glyphicon glyphicon-plus"></span>
		</a>
	</div>
</body>
</html>