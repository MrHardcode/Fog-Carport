<%-- 
    Document   : allOrders
    Created on : 05-05-2019, 18:36:17
    Author     : Malte
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page='/header.jsp'></jsp:include>

    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Order #</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="id" items="${ids}">
            <tr>
                <td>${id}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<jsp:include page='/footer.jsp'></jsp:include>