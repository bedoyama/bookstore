<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<!-- Basic Page Needs -->
<meta charset="utf-8">
<title>Die Publishers</title>
<meta name="description" content="">
<meta name="audivor" content="">

<!-- Mobile Specific Metas -->
<meta name="viewport" content="widdiv=device-widdiv, initial-scale=1">

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
		<div class="row">
			<div class="three columns">Publisher Name</div>
			<div class="five columns">Publisher e-mail</div>
			<div class="one column">Id</div>
			<div class="one column"></div>
		</div>
		<c:forEach items="${publishers}" var="publisher">
			<div class="row">
				<div class="three columns">${publisher.pname}</div>
				<div class="five columns">${publisher.pemail}</div>
				<div class="one column">
					<a
						href="<c:url value='/edit-${publisher.publisherId}-publisher' />">${publisher.publisherId}</a>
				</div>
				<div class="one column">
					<a
						href="<c:url value='/delete-${publisher.publisherId}-publisher' />">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<br />
	<span>Footer here</span>
	<br>

</body>
</html>