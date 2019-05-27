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
          action="/clientShowHistory" modelAttribute="clientmodel">
<table>
               <tr>
               <td><form:label path = "id">Select Client ID</form:label></td>
               <td>
                  <form:select path = "id">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${userList}" />
                  </form:select>     	
               </td>
            </tr>   	  
                  
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

</body>
</html>