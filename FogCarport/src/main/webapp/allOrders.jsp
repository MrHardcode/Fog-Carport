
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Headline --> 

<div class="d-flex flex-row mt-5">
    <div class="margintop ">
        <c:if test= "${not empty sessionScope.employee}">
            <div class="d-flex flex-column infobox">
                <p>Medarbejderoplysninger</p>
                <p class="mb-0">Medarbejdernr: ${employee.id}</p>
                <p class="mb-0">Personalemail: ${employee.email}</p>
            </div>
        </c:if>
        <c:if test= "${not empty sessionScope.customer}">
            <div class="d-flex flex-column infobox">
                <p>Kundeoplysninger</p>
                <p class="mb-0">${customer.name}</p>
                <p class="mb-0">${customer.phone}</p>
                <p class="mb-0">${customer.email}</p>
                <p class="mb-0">Kundenummer: ${customer.id}</p>
            </div>
        </c:if>
    </div>
    <div class="d-flex flex-column marginleft15">
        <h1 class="headlinecolor">Ordreoversigt</h1>
        <!-- 
        For each order id: Show a button that takes you to the viewOrder page for that Order. 
        Using in-line CSS to put 2px between each button.
        -->

        <c:forEach var="id" items="${ids}"> 
            <button type="button" class="btn btn-outline-secondary mb-1" onclick="window.location.href = 'FrontController?command=viewOrder&orderid=${id}'">Ordrenr: ${id}</button>
        </c:forEach>

    </div>
</div>