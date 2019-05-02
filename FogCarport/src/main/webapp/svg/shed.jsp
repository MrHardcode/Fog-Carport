<%-- 
    Document   : shed
    Created on : 02-05-2019, 17:24:50
    Author     : Malte
--%>

<%@page import="data.models.OrderModel"%>
<%
    OrderModel order = new OrderModel();
    order.setShed_width(3600);
    order.setShed_length(3600);
    request.getSession().setAttribute("order", order);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <svg width="720" height="720">
        <rect x="50" y="20" width="${order.shed_width/10}" height="${order.shed_length/10}" style="fill:blue;stroke:pink;stroke-width:5;fill-opacity:0.1;stroke-opacity:0.9" />
        </svg>
    </body>
</html>
