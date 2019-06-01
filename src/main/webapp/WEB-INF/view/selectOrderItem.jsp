<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<style>
.layout {
    height:800px;
    width:1000px;
 
    position:absolute;
    background-color:white;
}


.main{
  
    font-family: "Arial";
   font-size: 15px;
    position: relative;
   
}

button{
    margin-top:10px; 
   background-color: plum;
  color: white;
  padding: 14px 25px;
  text-align: center; 
  text-decoration: none;
  display: inline-block;
}

button:hover{
     background-color:plum;
     color:white;
     transition:0.5s;
   
}

.main input{
    height:30px;
        width:100px;
        border:3px solid purple;
        border-radius:3px;
        color:black;
  
}

</style>
<body>
  <jsp:include page="navbar.jsp"/>


 <div class="layout">
            <div class="main">

<p> Enter details to place enquiry</p>
<form:form method="POST"
          action="/showOrderItems" modelAttribute="deliverymodel">
<table>
               <tr>
               <td><form:label path = "identity">Select Order</form:label></td>
               <td>
                  <form:select path = "identity">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${confirmedOrderList}" />
                  </form:select>     	
               </td>
            </tr>   	  
                  
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</div>
</div>
</body>
</html>