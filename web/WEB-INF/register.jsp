<%-- 
    Document   : regster
    Created on : 26-Feb-2023, 1:04:26 PM
    Author     : Swift
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            Username: <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <br>
            <input type="submit" value="Register name">
        </form>
    </body>
</html>
