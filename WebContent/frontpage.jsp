<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unsw.comp9321.*"%>
<jsp:useBean id="cart" class="edu.unsw.comp9321.Frontpage"
	scope="session" />
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
<%@ include file="header.html"%>
</head>
<body style="background-color: white;">
		<form action="F
		rontpage" method="post">
			<input align="left" type="hidden" name="home"> <input
				type="submit" name="action" value="Home">
		</form>
		<div align="right" class="container-fluid">
			<img src="images/Bibliography.jpg" class="img-responsive" width="250"
				height="250">
		</div>
		<center>
			<form action="Frontpage" method="post">
				<table>
					<tr>
						<td><input type="text" name="searchString" size="50"></td>
						<td><input type="hidden" name="action" value="search"></td>
						<td><input type="submit" name="search" value="Search"></td>
					</tr>
				</table>
				<a href="AdvancedSearch.jsp">Advanced</a>
			</form>
		</center>
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