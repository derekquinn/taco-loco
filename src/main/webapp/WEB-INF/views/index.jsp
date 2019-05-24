<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Taco Loco | Menu</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Item</th>
			<th>Price</th>
		</tr>

		<c:forEach var="taco" items="${ taco }">

			<tr>
				<td>${ taco.id }</td>
				<td>${ taco.description }</td>
				<td>${ taco.price }</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>