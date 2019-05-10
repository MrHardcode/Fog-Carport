<%-- 
    Document   : SVGBase
    Created on : 07-05-2019, 11:46:04
    Author     : Asger
--%>

<%@page import="com.sun.org.apache.bcel.internal.generic.AALOAD"%>
<%@page import="logic.drawings.SVGDrawingBase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.models.PartslistModel"%>
<%@page import="data.models.OrderModel"%>
<%@page import="logic.Calculations.BaseCalc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int cLength = 5000;    //cm
    int cWidth = 3500;     //cm
    //int length = 400;           //cm
    //int width = 300;            //cm
    //int widthExtra = width + 5; //cm
    //int[] postsSideOne = {80, 355, 400};
    //int[] postsSideTwo = {80, 355, 400};
    //int[] rear = {150};
    
    request.getSession().setAttribute("cLength", cLength); 
    request.getSession().setAttribute("cWidth", cWidth); 
    //request.getSession().setAttribute("length", length); 
    //request.getSession().setAttribute("widthExtra", widthExtra); 
    //request.getSession().setAttribute("width", width); 
    //request.getSession().setAttribute("postsSideOne", postsSideOne); 
    //request.getSession().setAttribute("postsSideTwo", postsSideTwo); 
    //request.getSession().setAttribute("rear", rear); 
    

    BaseCalc bc = new BaseCalc();
    OrderModel order = new OrderModel(2100, 5000, 3000);
    order.setIncline(0);
    order.setShed_length(2700);
    order.setShed_width(2000);
    PartslistModel bom = new PartslistModel();
    bom = bc.addBase(bom, order);
    ArrayList postsSideOne = bom.getPostPosSideOne();
    ArrayList postsSideTwo = bom.getPostPosSideTwo();
    ArrayList rear = bom.getPostPosRear();
    int length = order.getLength() / 10;
    int width = order.getWidth() / 10;
    request.getSession().setAttribute("postsSideOne", postsSideOne); 
    request.getSession().setAttribute("postsSideTwo", postsSideTwo); 
    request.getSession().setAttribute("rear", rear); 
    request.getSession().setAttribute("length", length); 
    request.getSession().setAttribute("width", width); 
    SVGDrawingBase SVG = new SVGDrawingBase(order, bom);
    String drawing = SVG.getBaseDrawing();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>SVG practice</title>
    </head>
    <body>

        <h1>Base drawing</h1>
<!--        <svg x="50" width="${cLength}" height="${cWidth}">
            <svg y=5>
                <rect width="${length}" height="5" y="2" stroke="#000000" stroke-width="2" fill="#FFFFFF"/>
                <rect y="${width}" width="${length}" height="5" stroke="#000000" stroke-width="2" fill="#FFFFFF"/>
                <rect x="${length}" width="5" height="${width}" stroke="#000000" stroke-width="2" fill="#FFFFFF"/>
                <c:forEach var="post" items="${postsSideOne}">
                    <rect width="7" height="7" x="${post}" y="2" stroke="#000000" stroke-width="3" fill="#FFFFFF"/>
                </c:forEach>
                <c:forEach var="post" items="${postsSideTwo}">
                    <rect width="7" height="7" x="${post}" y="${width}" stroke="#000000" stroke-width="3" fill="#FFFFFF"/>
                </c:forEach>
                <c:forEach var="post" items="${rear}">
                    <rect width="7" height="7" x="${length}" y="${post}" stroke="#000000" stroke-width="3" fill="#FFFFFF"/>
                </c:forEach>
            </svg>
        </svg> -->
                <svg width="1000" height="1000">
                <%=drawing%>
                </svg>
    </body>
</html>
