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
<title><spring:message code="clientM.edit.title"/></title>
</head> 
<body>

	<div class="container">
		<fieldset>
   			<legend><spring:message code="clientM.edit.form"/></legend>
			<form:form modelAttribute="clientM" action="save" method="post">
				<form:hidden class="form-control" path="id"/> 
				<form:hidden class="form-control" path="version"/> 
				 <div class="form-group">
				<form:label path="nom"><spring:message code="clientM.edit.nom"/>:</form:label> <form:input type="text" class="form-control" path="nom"/>
				<form:errors path="nom" class="help-block"/>
				 </div>
				 <div class="form-group">
				<form:label path="numeroTel"><spring:message code="clientM.edit.numeroTel"/>:</form:label> <form:input type="number" class="form-control" path="numeroTel"/>
				<form:errors path="numeroTel" class="help-block"/>
				</div>
				 <div class="form-group">
				<form:label path="numeroFax"><spring:message code="clientM.edit.numeroFax"/>:</form:label> <form:input type="number" class="form-control" path="numeroFax"/> 
				<form:errors path="numeroFax" class="help-block"/>
				</div>
				<div class="form-group">
				<form:label path="email"><spring:message code="clientM.edit.email"/>:</form:label> <form:input type="text" class="form-control" path="email"/> 
				<form:errors path="email" class="help-block"/>
				</div>
				<div class="form-group">
				<form:label path="siret"><spring:message code="clientM.edit.siret"/>:</form:label> <form:input type="number" class="form-control" path="siret"/> 
				<form:errors path="siret" class="help-block"/>
				</div>
				<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span></button>
				<a href="<c:url value="/clientM/cancel"/>" class="btn btn-warning"><span class="glyphicon glyphicon-remove"></span></a>
			</form:form>
		</fieldset>
	</div>
</body>
</html>