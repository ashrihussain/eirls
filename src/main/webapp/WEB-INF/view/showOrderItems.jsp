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
<form action="/cancelOrderItem" method="post">
 <input type="hidden" name="myField" id="myField" value="" />
<table border="2">

		<th>Order Number</th>
		<th>Client Name</th>
		<th>Product Name</th>
		<th>Quantity</th> 
		<th>Placed Date</th>
		<th>Status</th>
		

		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.getEnq().getOrder_id()}</td>
				<td>${emp.getEnq().getClient_name()}</td>
				<td>${emp.getProduct_name()}</td>
				<td>${emp.getProduct_quantity()}</td> 

				<td>${emp.getEnq().getDate_placed()}</td>
				<td>${emp.getProduct_status()}</td>
				
				<td><a href="/cancelOrderItem"> <button type="submit" class="button" value="${emp.getOrderitems_id()}" onclick="senddata(this)" name="cancel"> Cancel </button></a> </td>
			</tr>
		</c:forEach>
	</table>
	</form>
	</div>
	 <script>
          function senddata(e){
              
             document.getElementById('myField').value= e.value; 
              
              
          }
          
          
          
          
          </script>
</body>
</html>