
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Headline --> 
<div class="d-flex justify-content-center">
    <h1>All Orders</h1>
</div>

<!-- Make sure the content is on the center of the screen. -->
<div class="d-flex justify-content-center w-100">

    <!-- Make sure the buttons are shown below each other. -->
    <div class="btn-group-vertical w-50">

        <!-- 
        For each order id: Show a button that takes you to the viewOrder page for that Order. 
        Using in-line CSS to put 2px between each button.
        -->
        <c:forEach var="id" items="${ids}"> 
            <a type="submit" class="btn btn-primary btn-lg btn-block active" style="margin-top: 2px" href="FrontController?command=viewOrder&orderid=${id}">ID: ${id}</a>
        </c:forEach>

    </div>
</div>
