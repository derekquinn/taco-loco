<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Taco Loco | Invoice </title>
</head>
<body>
<b>Taco Loco | Invoice</b>
<br>
<br>
<table>
<tr><th>Item</th><th>Quantity</th><th>Price</th></tr>
 <c:if test = "${vegetableTacoQty > 0}">
<tr><td>Vegetable Taco</td><td>${vegetableTacoQty }</td><td>$ ${vegetablePrice }</td></tr>
</c:if>
 <c:if test = "${chickenTacoQty > 0}">
<tr><td>Chicken Taco</td><td>${chickenTacoQty }</td><td>$ ${chickenPrice }</td></tr>
</c:if>
 <c:if test = "${beefTacoQty > 0}">
<tr><td>Beef Taco</td><td>${beefTacoQty }</td><td>$ ${beefPrice }</td></tr>
</c:if>
 <c:if test = "${chorizoTacoQty > 0}">
<tr><td>Chorizo Taco</td><td>${chorizoTacoQty }</td><td>$ ${chorizoPrice}</td></tr>
</c:if>
</table>

<br>
Subtotal is $ ${subTotal}<br>
Grand Total is $ ${grandTotal}



</body>
</html>