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
<form action="/cancelOrder" method="post">
 <input type="hidden" name="myField" id="myField" value="" />
<table class="table table-dark" border="2">

		<th>Order Number</th>
		<th>Client Name</th>
	
		<th>Placed Date</th>
		
		<th>Cancellation</th>

		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.getOrder_id()}</td>
				<td>${emp.getClient_name()}</td>
			
				<td>${emp.getDate_placed()}</td>
       
				<td><a href="/cancelOrder"> <button type="submit" class="button" value="${emp.getOrder_id()}" onclick="senddata(this)" name="cancel"> Cancel Order </button></a> </td>
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
					<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>

<script src="js/bootstrap.min.js"></script> 
</body>
</html>