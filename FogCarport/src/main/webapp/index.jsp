<%-- 
    Document   : index
    Created on : 11-04-2019, 22:36:17
    Author     : Asger
--%>

<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page='/header.jsp'></jsp:include>



<h1>Hello my man!</h1>
<c:forEach var="item" items="${items}">
    <p>
        ${item}
    </p>
</c:forEach>
<jsp:include page='/footer.jsp'></jsp:include>
