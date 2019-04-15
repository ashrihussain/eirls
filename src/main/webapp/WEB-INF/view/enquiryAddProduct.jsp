<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <jsp:include page="navbar.jsp"/>


<p>Add Products </p>
<form:form method="POST"
          action="/addItem" modelAttribute="enquiryitemplace">
<table>
                <tr>
                    <td><form:label path="productname">Product</form:label></td>
                    <td><form:input path="productname"/></td>
                </tr>
                <tr>
                    <td><form:label path="quantity">
                     quantity</form:label></td>
                    <td><form:input path="quantity"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
                </table>
                
  </form:form>
  <br>
   <a href="/enquiry">    <button class="dropbtn">Home </button></a> 
  <br>

</body>
</html>