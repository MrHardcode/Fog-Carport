
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="d-flex justify-content-center">
    <h1>All Orders</h1>
</div>

<div class="d-flex justify-content-center w-100">
    <div class="btn-group-vertical w-50">
        <c:forEach var="id" items="${ids}">
            <a type="submit" class="btn btn-primary btn-lg btn-block active" style="margin-top: 2px" href="FrontController?command=viewOrder&orderid=${id}">ID: ${id}</a>
        </c:forEach>
    </div>
</div>
