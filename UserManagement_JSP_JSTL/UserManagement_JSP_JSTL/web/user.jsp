<%-- 
    Document   : user
    Created on : Feb 7, 2023, 9:50:05 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Hello US role!</h1>
        
        User ID: ${sessionScope.LOGIN_USER.userID}</br>
        Full Name: ${sessionScope.LOGIN_USER.fullName}</br>
        Role ID: ${sessionScope.LOGIN_USER.roleID}</br>
        Password: ${sessionScope.LOGIN_USER.password}
    </body>
</html>
