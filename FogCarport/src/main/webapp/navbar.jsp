<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Navigation -->
<div id="myNavBar">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">

        <!-- Brand Logo / Name -->
        <a class="navbar-brand" href="FrontController?command=link&link=homepage">
            <img src="resources/fogheader.jpg" width="150" height="35" alt="fog logo image"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <!-- Navbar links -->
                <!--
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?command=link&link=partslist">Stykliste </a>
                </li>
                -->
                <li class="nav-item">
                    <a class="nav-link active" href="FrontController?command=link&link=makeCarport">Bestil Carport </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="FrontController?command=allOrders">Se alle ordrer </a>
                </li>
                <li class="nav-item">
                    <!-- Show errormessage to the User --> 
                    <c:if test="${not empty message}">
                        <a class="nav-link active" >  Message: ${message} </a>
                        </c:if>
                </li>

            </ul>
        </div>

    </nav>
</div>
<!-- Navigation end -->
