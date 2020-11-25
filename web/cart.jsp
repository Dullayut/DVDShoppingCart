<%-- 
    Document   : cart
    Created on : Nov 25, 2020, 12:37:27 PM
    Author     : thead
--%>

<%@page import="Model.ShoppingcartTable"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Shoppingcart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <jsp:useBean id="mov" class="Model.Shoppingcart" scope="request"/>
    <%
        List<Shoppingcart> itemList = ShoppingcartTable.findAllItem();
        Iterator<Shoppingcart> itr = itemList.iterator();
    %>
    <body>
        <center>
            <jsp:include page="main.jsp" flush="true" />
            <br>
     <h1>Shopping Cart</h1>
        <table border ="1">
            <tr>
                <th>DVD Names</th>
                <th>Rate</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Remove</th>
            </tr>
            <%
                while(itr.hasNext()) {
                    out.println("<form name=\"RemoveMovie\" action=\"RemoveMovieController\" method=\"POST\">");
                    mov = itr.next();
                    out.println("<tr>");
                    out.println("<td hidden><input type=\"number\" name=\"removeid\" value="+mov.getMovieId()+"></input></td>");
                    out.println("<td>"+ mov.getMovieId().getMovieName() + "</td>");
                    out.println("<td>"+ mov.getMovieId().getRate() + "</td>");
                    out.println("<td>"+ mov.getMovieId().getYearNo() + "</td>");
                    out.println("<td>"+ mov.getMovieId().getPrice() + "</td>");
                    out.println("<td>"+ mov.getQuantity() + "</td>");
                    out.println("<td><button type=\"submit\" name=\"removemovie\" id=\"button\">Remove</button></td>");
                    out.println("</tr>");
                    out.println("</form>");
                }
            %>
        </table>
        <br>
        <a onclick="window.location.href = '/DVDShoppingcart/CheckoutController'" value="Checkout" name="checkout" /></a>
     </center>
    </body>
</html>
