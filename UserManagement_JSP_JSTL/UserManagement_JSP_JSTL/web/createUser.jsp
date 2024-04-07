<%-- 
    Document   : createUser
    Created on : Feb 24, 2023, 10:55:28 AM
    Author     : PC
--%>

<%@page import="sample.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create user</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            UserError userError = (UserError)request.getAttribute("USER_ERROR");
            if(userError == null) userError = new UserError();
            String error = (String)request.getAttribute("ERROR");
            if(error == null) error="";
        %>
        <h1>Input User's Information</h1>
        <form action="MainController" method="POST">
            User ID:<input type="text" name="userID" required=""/>
            ${requestScope.USER_ERROR.userIDError}</br>
            Full Name:<input type="text" name="fullName" required=""/>
            ${requestScope.USER_ERROR.fullNameError}</br>
            Role ID:<input type="text" name="roleID" value="US" readonly=""/></br>
            Password:<input type="password" name="password" required=""/></br>
            Confirm:<input type="password" name="confirm" required=""/>
            ${requestScope.USER_ERROR.confirmError}</br>
            <input type="submit" name="action" value="Create"/></br>
            <input type="reset" value="Reset"/>
        </form>
            ${requestScope.ERROR}
    </body>
</html>
