<%-- 
    Document   : shed
    Created on : 02-05-2019, 17:24:50
    Author     : Malte
--%>

<%@page import="logic.drawings.SVGDrawingShed"%>
<%@page import="data.models.OrderModel"%>
<%
    OrderModel order = new OrderModel();
    order.setLength(7200);
    order.setWidth(7200);
    order.setShed_width(3600);
    order.setShed_length(3600);
    SVGDrawingShed draw = new SVGDrawingShed();
    String drawing = draw.getShedDrawing(order);
    request.getSession().setAttribute("drawing", drawing);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${ drawing }
    </body>
</html>
