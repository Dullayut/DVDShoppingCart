<%-- 
    Document   : addresult
    Created on : Nov 25, 2020, 3:14:44 AM
    Author     : thead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1><%=request.getAttribute("rowDeleted") + "is removed from shopping cart" %></h1>
        <br>
        <jsp:include page="main.jsp" flush="true" />
        <jsp:include page="cart.jsp" flush="true" />
    </body>
</html>
