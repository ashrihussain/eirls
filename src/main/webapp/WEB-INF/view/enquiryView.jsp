<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <jsp:include page="navbar.jsp"/>
  <p>Finished goods</p>
  <br><form action="login" method="Post">
<input name="userName" type="text"/><br/> 
<input name="password" type="password"/><br/>


  <select name="productId" form = "oa">
 <c:forEach items="${greeting}" var="lists">
      <option> ${lists} </option>
</c:forEach>
</select>
<br>
<p>Select Customer</P>
 <select name="name" form = "aa">
 <c:forEach items="${message}" var="item">
      <option> ${item} </option>
</c:forEach>
<input type="submit"/>
</form>
</select>
</body>
</html>