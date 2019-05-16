<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>place Order</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <jsp:include page="navbar.jsp"/>
 <form:form method="POST"
          action="/returns" modelAttribute="enquiryplace">
             <table>
                <tr>
                    <td><form:label path="orderid">Order ID</form:label></td>
                    <td><form:input path="orderid"/></td>
                </tr>
                <tr>
                    <td><form:label path="id">Item ID</form:label></td>
                    <td><form:input path="id"/></td>
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
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>