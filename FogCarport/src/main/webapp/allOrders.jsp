
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Headline --> 
<div class="d-flex flex-row mt-5">
    <div class="marginright20">
        <c:if test= "${not empty sessionScope.employee}">
            <div class="d-flex flex-column pl-5 mt-5 mb-3">
                <p>Loginoplysninger</p>
                <p class="mb-0">Medarbejdernummer: ${employee.id}</p>
                <p class="mb-0">Medarbejder kontaktmail: ${employee.email}</p>
            </div>
        </c:if>
        <c:if test= "${not empty sessionScope.customer}">
            <div class="d-flex flex-column pl-5 mt-5 mb-3">
                <p>Kundeoplysninger</p>
                <p class="mb-0">${customer.name}</p>
                <p class="mb-0">${customer.phone}</p>
                <p class="mb-0">${customer.email}</p>
                <p class="mb-0">Kundenummer: ${customer.id}</p>
            </div>
        </c:if>
    </div>
    <div class="d-flex flex-column">
            <h1>Ordreoversigt</h1>
        <!-- Make sure the content is on the center of the screen. -->

        <!-- Make sure the buttons are shown below each other. -->
        <div class="d-flex flex-column">

            <!-- 
            For each order id: Show a button that takes you to the viewOrder page for that Order. 
            Using in-line CSS to put 2px between each button.
            -->

            <c:forEach var="id" items="${ids}"> 
                <button type="button" class="btn btn-outline-secondary mb-1" onclick="window.location.href = 'FrontController?command=viewOrder&orderid=${id}'">Ordrenr: ${id}</button>
            </c:forEach>

        </div>
    </div>
</div>
