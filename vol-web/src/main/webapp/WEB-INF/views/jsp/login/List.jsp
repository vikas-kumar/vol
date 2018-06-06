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
		<h2><spring:message code="login.list.table"/></h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><spring:message code="login.list.id"/></th>
					<th><spring:message code="login.list.login"/></th>
					<th><spring:message code="login.list.mdp"/></th>
					<th><spring:message code="login.list.admin"/></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${logins}" var="login">
					<c:url var="editUrl" value="/login/edit">
						<c:param name="id">${eleve.id}</c:param>
					</c:url>
					<c:url var="deleteUrl" value="/login/delete">
						<c:param name="id">${login.id}</c:param>
					</c:url>
					<tr>
						<td>${login.id}</td>
						<td>${login.login}</td>
						<td>${login.mdp}</td>
						<td>${login.admin}</td>
						<td><a class="btn btn-primary btn-xs" href="${editUrl}"><span class="glyphicon glyphicon-pencil"></span></a><a class="btn btn-danger btn-xs" href="${deleteUrl}"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-info btn-md" href="<c:url value="/login/add"/>"> <span
			class="glyphicon glyphicon-plus"></span>
		</a>
	</div>
</body>
</html>