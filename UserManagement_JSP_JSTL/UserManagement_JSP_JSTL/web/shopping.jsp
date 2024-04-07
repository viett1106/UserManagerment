<%-- 
    Document   : shopping
    Created on : Feb 28, 2023, 11:22:32 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shopping page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Welcome to Viet's Mobile</div>
        <form action="MainController" method="POST">
            <select name="cmbPhone">
                <option value="P01-iPhone 12-14">iPhone 12</option>
                <option value="P02-iPhone 13-15">iPhone 13</option>
                <option value="P03-iPhone 14-16">iPhone 14</option>
                <option value="P04-iPhone 15-17">iPhone 15</option>
                <option value="P05-iPhone 16-20">iPhone 16</option>
            </select>
            <select name="cmbQuantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="10">10</option>
            </select>
            <input type="submit" name="action" value="Add"/>
            <input type="submit" name="action" value="View"/>
        </form>
        ${requestScope.MESSAGE}
    </body>
</html>
