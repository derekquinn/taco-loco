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
			<th>Item Number</th>
			<th>Item</th>
			<th>Price</th>
		</tr>
		<b>Taco Loco Menu</b>
		<br>
		<br>
		<c:forEach var="tacoMenu" items="${ tacoMenu }">

			<tr>
				<td>${ tacoMenu.id }</td>
				<td>${ tacoMenu.description }</td>
				<td>${ tacoMenu.price }</td>

			</tr>

		</c:forEach>
	</table>

	<br>

	<form action = "/invoice">
		<i>Enter the quantity of each taco you would like to order.</i><br>

		<table>
			<tr>
				<td>Vegetable Taco</td>
				<td><input name="vegetableTacoQty"
					id="vegetableTacoQty" value="0" maxlength="3" pattern="^((100)|(0)|([1-9][0-9]?))$" /></td>
			<tr>
				<td>Chicken Taco</td>
				<td><input name="chickenTacoQty"
					id="chickenTacoQty" value="0" class="numberinput"maxlength="3" pattern="^((100)|(0)|([1-9][0-9]?))$" /></td>
			<tr>
				<td>Beef Taco</td>
				<td><input name="beefTacoQty" id="beefTacoQty"
					value="0" class="numberinput" maxlength="3" pattern="^((100)|(0)|([1-9][0-9]?))$"/></td>
			<tr>
				<td>Chorizo Taco</td>
				<td><input name="chorizoTacoQty"
					id="chorizoTacoQty" value="0" maxlength="3" pattern="^((100)|(0)|([1-9][0-9]?))$"/></td>
		</table>

		<input type=submit value="Place Order">
	</form>


</body>
</html>