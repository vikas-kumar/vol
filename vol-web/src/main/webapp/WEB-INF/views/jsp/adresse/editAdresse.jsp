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
<title><spring:message code="login.edit.title"/></title>
</head> 
<body>

	<div class="container">
		<fieldset>
   			<legend><spring:message code="adresse.edit.form"/></legend>
			<form:form modelAttribute="adresse" action="save" method="post">
				<form:hidden class="form-control" path="id"/> 
				<form:hidden class="form-control" path="version"/> 
				 <div class="form-group">
				<form:label path="adresse"><spring:message code="adresse.edit.login"/>:</form:label> <form:input type="text" class="form-control" path="adresse"/>
				<form:errors path="adresse" class="help-block"/>
				 </div>
				 <div class="form-group">
				<form:label path="cp"><spring:message code="adresse.edit.mdp"/>:</form:label> <form:input type="number" class="form-control" path="cp"/>
				<form:errors path="cp" class="help-block"/>
				</div>
				 <div class="form-group">
				<form:label path="ville"><spring:message code="adresse.edit.admin"/>:</form:label> <form:input type="text" class="form-control" path="ville"/> 
				<form:errors path="ville" class="help-block"/>
				</div>
				<div class="form-group">
				<form:label path="pays"><spring:message code="adresse.edit.admin"/>:</form:label> <form:input type="text" class="form-control" path="pays"/> 
				<form:errors path="pays" class="help-block"/>
				</div>
				<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span></button>
				<a href="<c:url value="/login/cancel"/>" class="btn btn-warning"><span class="glyphicon glyphicon-remove"></span></a>
			</form:form>
		</fieldset>
	</div>
</body>
</html>