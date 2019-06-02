<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>place Order</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<style>


.main{
  
    font-family: "Arial";
    height:700px;
   font-size: 25px;
    position: relative;
    top:100px;
    left:100px;
}

.main input{
    height:20px;
        width:500px;
        border:3px solid purple;
        border-radius:3px;
  
}



.main select{
      border:3px solid purple;
     border-radius:3px;
    
}

.layout {
    height:800px;
    width:1000px;
  left:15%;
    position:absolute;
    background-color:white;
}

button{
    background-color: purple;
    color:white;
    cursor:pointer;
    border: 2px groove black;
    border-radius:3px;
    font-size: 20px
}

button:hover{
     background-color:plum;
     color:white;
     transition:0.5s;
   
}

.flow {
    min-height: 700px;
    width:1000px;
  left:15%;
    position:absolute;
    background-color:white;
}

table {
 
  border-collapse: collapse;
 width: 90%;
}

th {
    height: 30px;
    
}

th, td {
    text-align: left;
    padding: 8px;
     border:2px groove purple;
}

tr{
    background-color:white;
}

th {
    background-color:purple;
    color: white;
}

.bordermain{
    left:30px;
    
    
    
}







</style>
<body>
  <jsp:include page="navbar.jsp"/>
 <div class="flow">
<table border="2">

		<th>Delivery ID</th>
		<th>Order ID</th>
		<th>Delivery Location</th>
		<th>Delivery Date</th> 
		<th>Delivery Type</th>
        <th>Courier ID</th>

        <th>Delivery Status</th>
	
	


		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.getDelivery_id()}</td>
				<td>${emp.getEq().getOrder_id()}</td>
				<td>${emp.getDelivery_location()}</td>
				<td>${emp.getDelivery_date()}</td> 
                <td>${emp.getDelivery_type()}</td>
				<td>${emp.getDel().getCourier_id()}</td>
                
				<td>${emp.getDelivery_status()}</td>
              
				
			
			</tr>
		</c:forEach>
	</table>
	</form>
	</div>
</body>
</html>