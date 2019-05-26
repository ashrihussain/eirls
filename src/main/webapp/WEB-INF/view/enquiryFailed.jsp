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
  <p> SORRY, PRODUCT UNAVAILABLE!!! </P>
   <form:form method="POST"
          action="/placeEnquiries" modelAttribute="enquiryplace">
             <table>
                <tr>
                    <td><form:label path="productname">Product Name</form:label></td>
                    <td><form:input path="productname"/></td>
                </tr>
                <tr>
                    <td><form:label path="quantity">Quantity</form:label></td>
                    <td><form:input path="quantity"/></td>
                </tr>
                 <tr>
                    <td><form:radiobutton path="returntype" value="Finished Good"/> Finished Good
                     <form:radiobutton path="returntype" value="Raw Material"/> Raw Material 
                      </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

        <button> <a href="/enquiry">Continue</a> </button>
</body>
</html>