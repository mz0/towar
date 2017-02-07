<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Returned car</title>
    </head>
    <body>
        
        <h3>Car details</h3>
        
        <p>
            ID: <c:out value="${returnedCar.id}"/> <br>
            Name: <c:out value="${returnedCar.name}"/> <br>
            Price: <c:out value="${returnedCar.price}"/> <br>
        </p>
        
    </body>
</html>
