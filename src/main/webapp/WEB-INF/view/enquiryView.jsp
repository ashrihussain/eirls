<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <jsp:include page="navbar.jsp"/>

  <p>Select Customer</P>
 <select name="name" form = "aa">
 <c:forEach items="${message}" var="item">
      <option> ${item} </option>
</c:forEach>
<input type="submit"/>
</select>
<br>
  <p>Finished goods</p>
  <br><form action="login" method="Post">
  <p> Product name </p>
<input name="product" type="text"/><br/> 
<p> quantity </p>
<input name="quantity" type="password"/><br/>
<br>

</form>

</body>
</html>