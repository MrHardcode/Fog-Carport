<%-- 
    Document   : index
    Created on : 11-04-2019, 22:36:17
    Author     : Asger
--%>

<%@page import="java.util.ArrayList"%>
<!--The following tag is the JSTL Expression Language tag-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    ArrayList list = new ArrayList();
    String one = "one";
    String two = "two";
    String three = "three";
    String four = "four";
    list.add(one);
    list.add(two);
    list.add(three);
    list.add(four);
    request.getSession().setAttribute("items", list);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello my man!</h1>
        <c:forEach var="item" items="${items}">
            <p>
                ${item}
            </p>
        </c:forEach>
    </body>
</html>
