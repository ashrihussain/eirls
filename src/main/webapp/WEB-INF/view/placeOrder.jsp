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

<form action="/confirmOrder" method="post">
 <input type="hidden" name="myField" id="myField" value="" />
<table border="2">

		<th>Order Number</th>
		<th>Client Name</th>
		<th>Product Name</th>
		<th>Quantity</th> --%>

		<th>Placed Date</th>
		<th>Status</th>
		<th>Confirmation</th>

		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.getEnq().getOrder_id()}</td>
				<td>${emp.getEnq().getClient_name()}</td>
				<td>${emp.getProduct_name()}</td>
				<td>${emp.getProduct_quantity()}</td> 

				<td>${emp.getEnq().getDate_placed()}</td>
				<td>${emp.getEnq().getOrder_status()}</td>
				<td><a href="/confirmOrder"> <button type="submit" class="button" value="${emp.getEnq().getOrder_id()}" onclick="senddata(this)" name="confirm"> Confirm </button></a> </td>
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