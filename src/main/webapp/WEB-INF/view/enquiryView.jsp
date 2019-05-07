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




<p> Enter details to place enquiry</p>
<form:form method="POST"
          action="/addEnquiry" modelAttribute="enquiryplace">
<table>
                <tr>
                    <td><form:label path="clientname">Client Name</form:label></td>
                    <td><form:input path="clientname"/></td>
                </tr>
                 <tr>
                    <td><form:label path="productname">Product name</form:label></td>
                    <td><form:input path="productname"/></td>
                </tr>
                <tr>
                    <td><form:label path="quantity">
                     quantity</form:label></td>
                    <td><form:input path="quantity"/></td>
                </tr>
                   <tr>
                    <td><form:label path="date">
                      Due Date</form:label></td>
                    <td><form:input path="date"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

</body>
</html>