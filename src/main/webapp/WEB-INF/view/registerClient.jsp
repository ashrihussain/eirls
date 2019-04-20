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
   <form:form method="POST"
          action="/register" modelAttribute="clientmodel">
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
                    <td><form:label path="status">Client Credit Status</form:label></td>
                    <td><form:input path="status"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>