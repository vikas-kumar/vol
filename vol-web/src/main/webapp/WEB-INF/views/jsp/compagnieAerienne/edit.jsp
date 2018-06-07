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
<link rel="stylesheet" href="<c:url value="/css/style.css"/>">
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<title><spring:message code="compagnieAerienne.edit.title" /></title>
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
						<li><a href="/vol-web/ville/list/"><spring:message
									code="nav.ville" /></a></li>
						<li><a href="/vol-web/aeroport/list/"><spring:message
									code="nav.aeroport" /></a></li>
						<li><a href="/vol-web/passager/list/"><spring:message
									code="nav.passager" /></a></li>
						<li class="active"><a href="/vol-web/compagnieaerienne/list/"><spring:message code="nav.compagnieaerienne" /><span class="sr-only">(current)</span></a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/vol-web/compagnieaerienne/list/?lang=en">En</a></li>
						<li><a href="/vol-web/compagnieaerienne/list/?lang=fr">Fr</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="jumbotron">
			<legend>
				<spring:message code="compagnieAerienne.edit.form" />
			</legend>
		</div>
		<fieldset>
			<form:form modelAttribute="compagnieaerienne" action="save"
				method="post">
				<form:hidden class="form-control" path="id" />
				<form:hidden class="form-control" path="version" />
				<div class="form-group">
					<form:label path="nom">
						<spring:message code="compagnieAerienne.edit.nom" />:</form:label>
					<form:input type="text" class="form-control" path="nom" />
					<form:errors path="nom" class="help-block" />
				</div>

				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-ok"></span>
				</button>
				<a href="<c:url value="/compagnieaerienne/cancel"/>"
					class="btn btn-warning"><span
					class="glyphicon glyphicon-remove"></span></a>
			</form:form>
		</fieldset>
	</div>
</body>
</html>