<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Enter car ID</title>
    </head>
    <body>
        <p>Enter car ID:</p>
        
        <form action="controller">
            
            <input type="hidden" name="action" value="viewcar">
            <label for="carId">Id:</label>
            <input id="carId" type="text" name="carId">
            <br>
            <br>
            
            <button type="submit">Submit</button>
            
        </form>
    </body>
</html>
