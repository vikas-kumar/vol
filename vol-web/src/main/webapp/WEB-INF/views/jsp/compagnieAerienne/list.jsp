<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/style.css"/>">
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<title><spring:message code="compagnieAerienne.list.title" /></title>
</head>
<body>
	<div class="container well">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">C.R.U.D</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">C.R.U.D</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/vol-web/ville/list/"><spring:message code="nav.ville" /></a></li>
					<li><a href="/vol-web/aeroport/list/"><spring:message code="nav.aeroport" /></a></li>
					<li><a href="/vol-web/passager/list/"><spring:message code="nav.passager" /></a></li>
					<li><a href="/vol-web/compagnieaerienne/list/"><spring:message code="nav.compagnieaerienne" /><span class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/vol-web/ville/list/?lang=en">En</a></li>
					<li><a href="/vol-web/ville/list/?lang=fr">Fr</a></li>
				</ul>
			</div>
		</div>
		</nav>

		<div class="jumbotron">
			<h2>
				<spring:message code="compagnieAerienne.list.page" />
			</h2>
		</div>

		<table class="table blue-grey lighten-4">
			<thead>
				<tr>
					<th><spring:message code="compagnieAerienne.list.id" /></th>
					<th><spring:message code="compagnieAerienne.list.nom" /></th>
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
						<td><a class="btn btn-primary btn-xs" href="${editUrl}"><span
								class="glyphicon glyphicon-pencil"></span></a> <a
							class="btn btn-danger btn-xs" href="${deleteUrl}"><span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-info btn-md"
			href="<c:url value="/compagnieaerienne/add"/>"> <span
			class="glyphicon glyphicon-plus"></span>
		</a>
	</div>
</body>
</html>