<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<title><spring:message code="x.x.title"/></title>
</head>
<body>
<div class="container">
		<h2><spring:message code="Adresse.list.table"/></h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><spring:message code="Adresse.list.adresse"/></th>
					<th><spring:message code="Adresse.list.cp"/></th>
					<th><spring:message code="Adresse.list.ville"/></th>
					<th><spring:message code="Adresse.list.pays"/></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${adresses}" var="adresse">
					<c:url var="editUrl" value="/Adresse/edit">
						<c:param name="id">${adresse.adresse}</c:param>
					</c:url>
					<c:url var="deleteUrl" value="/Adresse/delete">
						<c:param name="id">${Adresse.adresse}</c:param>
					</c:url>
					<tr>
						<td>${Adresse.adresse}</td>
						<td>${Adresse.cp}</td>
						<td>${Adresse.ville}</td>
						<td>${Adresse.pays}</td>
						<td><a class="btn btn-primary btn-xs" href="${editUrl}"><span class="glyphicon glyphicon-pencil"></span></a><a class="btn btn-danger btn-xs" href="${deleteUrl}"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-info btn-md" href="<c:url value="/Adresse/add"/>"> <span
			class="glyphicon glyphicon-plus"></span>
		</a>
	</div>
</body>
</html>