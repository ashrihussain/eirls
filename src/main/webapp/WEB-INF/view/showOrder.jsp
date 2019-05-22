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

<form action="/cancelOrder" method="post">
 <input type="hidden" name="myField" id="myField" value="" />
<table border="2">

		<th>Order Number</th>
		<th>Client Name</th>
		<%-- <th>Product Name</th> --%>
		<%-- <th>Quantity</th> --%>
		<%-- <th>Delivery Date</th> --%>
		<th>Placed Date</th>
		<th>Status</th>
		<th>Cancellation</th>

		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.getOrder_id()}</td>
				<td>${emp.getClient_name()}</td>
				<%-- <td>${emp.getProduct_name()}</td> --%>
				<%-- <td>${emp.getQuantity()}</td> --%>
			<%-- <td>${emp.getDue_date()}</td> --%>
				<td>${emp.getDate_placed()}</td>
        <td>${emp.getOrder_status()}</td>
				<td><a href="/cancelOrder"> <button type="submit" class="button" value="${emp.getOrder_id()}" onclick="senddata(this)" name="confirm"> Cancel Order </button></a> </td>
			</tr>
		</c:forEach>
	</table>
	</form>
	 <script>
          function senddata(e){
              
             document.getElementById('myField').value= e.value; 
              
              
          }
          
          
          
          
          </script>
</body>
</html>