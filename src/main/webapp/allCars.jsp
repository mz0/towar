<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cars</title>
    </head>
    <body>
        
        <h3>All cars</h3>
        
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>

            <c:forEach items="${carList}" var='car'>
                <tr>
                    <td>
                        <c:out value="${car.id}"/>
                    </td>
                    <td>
                        <c:out value="${car.name}"/>
                    </td>
                    <td>
                        <c:out value="${car.price}"/>
                    </td>                    
                </tr>
            </c:forEach>          

        </table>

    </body>
</html>
