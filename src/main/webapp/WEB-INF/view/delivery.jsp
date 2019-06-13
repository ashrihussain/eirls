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
    margin-left: 500px;
    margin-top: 50px;
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
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=submit] {
  width: 100%;
  background-color: purple;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: white;
  color: purple;
  transition: 0.2s;
  
}

</style>
<body>
  <jsp:include page="navbar.jsp"/>
   <div class="layout">
            <div class="main">
   <form:form method="POST"
          action="/confirmDelivery" modelAttribute="deliverymodel">
             <table>
                <tr>
               <td><form:label path = "identity">Select Order ID</form:label></td>
               <td>
                  <form:select path = "identity">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${orderList}" />
                  </form:select>     	
               </td>
            </tr>   
                <tr>
                    <td><form:label path="address">Delivery Location</form:label></td>
                    <td><form:input path="address"/></td>
                </tr>
                
                 
                <tr>
                    <td><form:radiobutton path="deliverytype" value="Post"/> Post
                     <form:radiobutton path="deliverytype" value="Courier"/> Courier 
                     </td>
                </tr>
                <tr>
               <td><form:label path = "courier">Select Courier ID</form:label></td>
               <td>
                  <form:select path = "courier">
                     <form:option value = "0" label = "Select"/>
                     <form:options items = "${courierList}" />
                  </form:select>     	
               </td>
            </tr>  
             <tr>
                    <td><form:label path="duedate">Delivery Date</form:label></td>
                    <td><form:input path="duedate"/></td>
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