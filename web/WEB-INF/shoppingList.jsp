<%-- 
    Document   : shoppingList
    Created on : 26-Feb-2023, 1:04:40 PM
    Author     : Swift
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${username}</p>
        <p><a href="ShoppingList?action=logout">Logout</a></p>

        <form action="" method="POST">
            <h2>Add Item</h2>
            <input type="text" name="item">
            <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>

        <form action="" method="POST">
            <ul>
                <c:forEach var="item" items="${list}">
                    <li><input type="radio" name="item" value="${item}">${item}</li>
                    </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>