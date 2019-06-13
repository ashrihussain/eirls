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
          action="/registration" modelAttribute="clientmodel">
             <table>
                <tr>
                    <td><form:label path="name">Client Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="tradingname">Trading Name</form:label></td>
                    <td><form:input path="tradingname"/></td>
                </tr>
                 <tr>
                    <td><form:label path="age">Client Age</form:label></td>
                    <td><form:input path="age"/></td>
                </tr>
                 <tr>
                    <td><form:label path="address">Client Address</form:label></td>
                    <td><form:input path="address"/></td>
                </tr>
                <tr>
                    <td><form:label path="contact">Client Contact Number</form:label></td>
                    <td><form:input path="contact"/></td>
                </tr>
                <tr>
                    <td><form:radiobutton path="status" value="Valid"/> Valid
                     <form:radiobutton path="status" value="Invalid"/> Invalid 
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