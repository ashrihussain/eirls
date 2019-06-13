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
    width:1000px; 
    position:absolute;
    background-color:white;
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

.main{
  
    font-family: "Arial";
   font-size: 15px;
    position: relative; 
    border-radius: 10px;

 }

body {
     
background-color:white;
  
}
.layout {
    margin-left: 500px;
    margin-top: 100px;
}

tr {
border-bottom: 1px solid
}

button:hover{
     background-color:plum;
     color:white;
     transition:0.5s;
   
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
  width: 100px;
  height: 40px;
  background-color: purple;
  color: white;
  padding: 14px 20px; 
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: white;
  color: purple;
  border: purple;
  transition: 0.8s;
  opacity: 1
  
}
 

</style>

<body>
  <jsp:include page="navbar.jsp"/>
  <div class = "body">
   <div class="layout">
            <div class="main">
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
               <br>
            </tr>   	  
                 <tr>
               <td><form:label path = "productname">Product</form:label></td>
               <td>
                  <form:select path = "productname">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${productList}" />
                  </form:select>     	
               </td>
                <br>
            </tr>   	
                <tr>
                    <td><form:label path="quantity">Returning quantity</form:label></td>
                    <td><form:input path="quantity"/></td>
                </tr>
                 <br>
                 <tr>
                    <td><form:radiobutton path="returntype" value="Repair"/> Repair
                     <form:radiobutton path="returntype" value="Refund"/> Refund 
                       <form:radiobutton path="returntype" value="Exchange"/> Exchange </td>
                </tr>
                 <br>
                <tr>
                    <td><form:label path="description">Reason</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                 <br>
                 <tr>
                    <td><form:label path="location">Return Location</form:label></td>
                    <td><form:input path="location"/></td>
                </tr>
                <br>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
        </div>
        </div>
        </div>
</body>
</html>