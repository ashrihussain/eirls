<!DOCTYPE HTML>
<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <jsp:include page="navbar.jsp"/>
   <form:form method="POST"
          action="/placeEnquiries" modelAttribute="enquiryplace">
<table>
                 <tr>
                    <td><form:label path="product">Product name</form:label></td>
                    <td><form:input path="product"/></td>
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
</body>
</html>