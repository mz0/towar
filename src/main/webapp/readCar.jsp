<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Enter car details</title>
    </head>
    <body>
        <p>Enter car details:</p>
        
        <form action="controller?action=savecar" method="post">
            
            <label for="carName">Name:</label>
            <input id="carName" type="text" name="carName">
            <br><br>
            
            <label for="carPrice">Price</label>
            <input id ="carPrice" type="text" name="carPrice">
            <br><br>
            
            <button type="submit">Submit</button>
            
        </form>
        
    </body>
</html>
