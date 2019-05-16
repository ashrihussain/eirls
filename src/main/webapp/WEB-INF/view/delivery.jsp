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
          action="/confirmDelivery" modelAttribute="deliverymodel">
             <table>
                <tr>
                    <td><form:label path="orderid">Order ID</form:label></td>
                    <td><form:input path="orderid"/></td>
                </tr>
                <tr>
                    <td><form:label path="address">Delivery Location</form:label></td>
                    <td><form:input path="address"/></td>
                </tr>
                 <tr>
                    <td><form:label path="duedate">Delivery Date</form:label></td>
                    <td><form:input path="duedate"/></td>
                </tr>
                <tr>
                    <td><form:radiobutton path="deliverytype" value="Shipping"/> Shipping
                     <form:radiobutton path="deliverytype" value="Courier"/> Courier 
                     </td>
                </tr>
                 <tr>
                    <td><form:label path="courierid">Courier ID</form:label></td>
                    <td><form:input path="courierid"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

        <button> <a href="/enquiry">Continue</a> </button>
</body>
</html>