<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Car saved</title>
    </head>
    <body>
        <p>Successfully saved  <c:out value="${sessionScope.carName}"/>
        car priced <c:out value="${sessionScope.carPrice}"/></p>
    </body>
</html>
