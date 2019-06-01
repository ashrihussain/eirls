<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>place Order</title>
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
  padding: 10px 10px;
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
  <p> Invalid details entered, please try again </p>
 <form:form method="POST"
          action="/returns" modelAttribute="enquiryplace">
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
               <td><form:label path = "productname">Product</form:label></td>
               <td>
                  <form:select path = "productname">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${productList}" />
                  </form:select>     	
               </td>
            </tr>   	
                <tr>
                    <td><form:label path="quantity">Returning quantity</form:label></td>
                    <td><form:input path="quantity"/></td>
                </tr>
                 <tr>
                    <td><form:radiobutton path="returntype" value="Repair"/> Repair
                     <form:radiobutton path="returntype" value="Refund"/> Refund 
                       <form:radiobutton path="returntype" value="Exchange"/> Exchange </td>
                </tr>
                <tr>
                    <td><form:label path="description">Reason</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                 <tr>
                    <td><form:label path="location">Return Location</form:label></td>
                    <td><form:input path="location"/></td>
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