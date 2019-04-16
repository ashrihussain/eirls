<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>place Order</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <jsp:include page="navbar.jsp"/>

<form:form method="POST"
          action="/confirmOrder" modelAttribute= "model">
<table border="2">

		<th>Order Number</th>
		<th>Client Name</th>
		<th>Product Name</th>
		<th>Quantity</th>
		<th>Delivery Date</th>
		<th>Placed Date</th>
		<th>Confirmation</th>

		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.getOrder_id()}</td>
				<td>${emp.getClient_name()}</td>
				<td>${emp.getProduct_name()}</td>
				<td>${emp.getQuantity()}</td>
				<td>${emp.getDue_date()}</td>
				<td>${emp.getDate_placed()}</td>
				<td> <form:input type="submit" value= "${emp.getOrder_id()}" path = "orderid"/></td>
			</tr>
		</c:forEach>
	</table>
 </form:form>
</body>
</html>