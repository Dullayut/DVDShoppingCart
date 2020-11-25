<%-- 
    Document   : main
    Created on : Nov 24, 2020, 6:50:32 PM
    Author     : thead
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="Model.Moviecatalog"%>
<%@page import="Model.MoviecatalogTable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Store</title>
    </head>
    <jsp:useBean id="mov" class="Model.Moviecatalog" scope="request"/>
    <%
        List<Moviecatalog> movList = MoviecatalogTable.findAllMovie();
        Iterator<Moviecatalog> itr = movList.iterator();
    %>
    <body>
     <center>
     <h1>DVD Catalog</h1>
        <table border ="1">
            <tr>
                <th>DVD Names</th>
                <th>Rate</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>AddCart</th>
            </tr>
            <%
                while(itr.hasNext()) {
                    out.println("<form name=\"AddMovie\" action=\"AddMovieController\" method=\"POST\">");
                    mov = itr.next();
                    out.println("<tr>");
                    out.println("<td hidden><input type=\"number\" name=\"movieid\" value="+mov.getMovieId()+"></input></td>");
                    out.println("<td>"+ mov.getMovieName() + "</td>");
                    out.println("<td>"+ mov.getRate() + "</td>");
                    out.println("<td>"+ mov.getYearNo() + "</td>");
                    out.println("<td>"+ mov.getPrice() + "</td>");
                    out.println("<td>&nbsp</td>");
                    out.println("<td><button type=\"submit\" name=\"addmovie\" id=\"button\">AddToCart</button></td>");
                    out.println("</tr>");
                    out.println("</form>");
                }
            %>
        </table>
     </center>
    </body>
</html>
