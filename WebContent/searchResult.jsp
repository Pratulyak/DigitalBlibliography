<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unsw.comp9321.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Digital Bibliography</title>
	<jsp:include page="pageHeader.jsp">
	<jsp:param name= "home" value= " class=\"active\""/>	
	<jsp:param name = "cart" value=""/>
	</jsp:include>
</head>
<body>
	<div class="container">
		<form action='Frontpage' method="POST">
			<input type="submit" value="Back to Search" /> <input type="hidden"
				name="action" value="home" />
		</form>
	</div>
	
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>Year</th>
					<th>Add to Cart</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>