<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <jsp:include page="navbar.jsp"/>
  <br><form action="login" method="Post">
  <p>Select Customer</P>
 <select name = "selection" form = "aa">
 <c:forEach items="${message}" var="item">
      <option> ${item} </option>
</c:forEach>
<br>
</select>
  <p>Finished goods</p>
  
  <p> Product name </p>
<input name="product" type="text"/><br/> 

<br>
<p> Quantity </p>
<input name="quantity" type="number"/><br/>
<br>
<input type="submit"/>

</form>

</body>
</html>