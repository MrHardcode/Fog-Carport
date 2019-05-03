<%-- 
    Document   : shed
    Created on : 02-05-2019, 17:24:50
    Author     : Malte
--%>

<%@page import="data.models.OrderModel"%>
<%
    OrderModel order = new OrderModel();
    order.setLength(7200);
    order.setWidth(7200);
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
        <svg width="${(order.length/10)}" height="${(order.width/10)}">
            <rect x="${(order.length/10)-(order.shed_length/10)}" 
                  y="${(order.width/10)-(order.shed_width/10)}" 
                  width="${order.shed_width/10}" 
                  height="${order.shed_length/10}" 
                  style="stroke:black;stroke-width:5;fill-opacity:0.1;stroke-opacity:1" />
            
            <rect x="${(order.length/10)-(order.shed_length/10)}" 
                  y="${(order.width/10)-(order.shed_width/10)}" 
                  width="15" height="15" 
                  style="stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1" />
            Sorry, your browser does not support inline SVG.  
        </svg>
    </body>
</html>
