<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<!-- Basic Page Needs -->
<meta charset="utf-8">
<title>Die (as in German plural) Publishers</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Mobile Specific Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- FONT -->
<link href="//fonts.googleapis.com/css?family=Raleway:400,300,600"
	rel="stylesheet" type="text/css">

<!-- CSS -->
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/skeleton.css">

<!-- Favicon -->
<link rel="icon" type="image/png" href="images/favicon.png">

</head>
<body>
	<h2>List of Publishers</h2>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>Publisher Name</th>
					<th>Publisher e-mail</th>
					<th>Id</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${publishers}" var="publisher">
					<tr>
						<td>${publisher.pname}</td>
						<td>${publisher.pemail}</td>
						<td><a
							href="<c:url value='/edit-${publisher.publisherId}-publisher' />">${publisher.publisherId}</a></td>
						<td><a
							href="<c:url value='/delete-${publisher.publisherId}-publisher' />">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<span>Footer here</span>
	<br>

</body>
</html>