<%-- 
    Document   : checkout
    Created on : Nov 25, 2020, 12:39:58 PM
    Author     : thead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
    </head>
    <body>
        <h1>Your Order Is Confirmed!</h1>
        <h1><%= "The total amount is $" + request.getAttribute("amount")%></h1>
    </body>
</html>