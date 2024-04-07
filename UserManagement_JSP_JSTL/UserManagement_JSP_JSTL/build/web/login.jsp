<%-- 
    Document   : login
    Created on : Feb 7, 2023, 9:45:53 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" required=""/></br>
            Password <input type="password" name="password" required=""/></br>
            <input type="submit" name="action" value="Login" />
            <input type="reset" value="Reset"/>
        </form>
        ${requestScope.ERROR}
        </br>
        <a href="shopping.html">Shopping</a>
    </body>
</html>
