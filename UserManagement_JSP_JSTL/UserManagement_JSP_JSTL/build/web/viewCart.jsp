<%-- 
    Document   : viewCart
    Created on : Mar 3, 2023, 9:42:45 AM
    Author     : PC
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.phone.Phone"%>
<%@page import="sample.phone.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>Viet View Cart</h1>
    <c:if test="${not empty sessionScope.CART}">
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Edit</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
            <c:set var="count" value="1" />
            <c:set var="total" value="0" />
            <c:forEach items="${sessionScope.CART.cart}" var="phone">
                <c:set var="subtotal" value="${phone.value.price * phone.value.quantity}" />
                <c:set var="total" value="${total + subtotal}" />
                <form action="MainController" method="POST">
                    <tr>
                        <td>${count}</td>
                        <td>
                            <input type="text" name="id" value="${phone.value.id}" readonly=""/>
                        </td>
                        <td>${phone.value.name}</td>
                        <td>${phone.value.price} triệu</td>
                        <td>
                            <input type="number" name="quantity" value="${phone.value.quantity}" min="1"/>
                        </td>
                        <td>${subtotal} triệu</td>
                        <td>
                            <input type="submit" name="action" value="Edit"/>
                        </td>
                        <td>
                            <input type="submit" name="action" value="Remove"/>
                        </td>
                    </tr>
                </form>
                <c:set var="count" value="${count+1}" />
            </c:forEach>
            </tbody>
        </table>
        <h1>Total: ${total} Triệu</h1>
    </c:if>
    <a href="shopping.html">Add more</a>
</body>
</html>