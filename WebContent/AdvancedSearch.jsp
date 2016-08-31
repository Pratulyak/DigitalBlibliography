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
</head>
<body>
	<%@ include file="header.html"%>
	<form action="F
		rontpage" method="post">
		<input type="hidden" name="home"> <input type="submit"
			name="action" value="Home">
	</form>
	<center>
		<form action="control" method="POST">
			<select name="searchType">
				<option>Book</option>
				<option>Journal</option>
				<option>Date</option>
				<option>Author</option>
				<option>Venue</option>
			</select>
		</form>
		<form action='Frontpage'>
			<table>
				<tr>
					<td><input type='text'></td>
					<td><input type='submit' value='Search'></td>
				</tr>
			</table>
			<a href="AdvancedSearch.jsp">Advanced</a>
		</form>
	</center>

</body>
</html>