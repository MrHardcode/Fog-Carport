<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--The following tag is the JSTL Expression Language tag-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<div class="jumbotron infoboxorderview nav-color">
    <div class="d-flex justify-content-center">
        <h1 class="display-4">Bestilling gennemført!</h1>
    </div>
    <div class="d-flex justify-content-center">
        <p class="lead">Tak for din bestilling. Tryk på knappen nedenunder for at gå videre.</p>
    </div>
    <hr class="my-4">
    <!-- If logged in as customer or employee, show button to view all orders -->
    <c:if test="${not empty sessionScope.customer or not empty sessionScope.employee}">
        <div class="d-flex justify-content-center">
            <a role="button" class="btn btn-outline-secondary mb-1" href="FrontController?command=allOrders">Se dine ordrer</a>
        </div>
    </c:if>
    <!-- If not logged in, show button to go back -->
    <c:if test="${empty sessionScope.customer and empty sessionScope.employee}">
        <div class="d-flex justify-content-center">
            <a role="button" class="btn btn-outline-secondary mb-1" href="FrontController?command=makeCarportForm">Fortsæt</a>
        </div>
    </c:if>
</div>

