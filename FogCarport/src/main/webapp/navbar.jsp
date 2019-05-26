<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Navigation -->
<div id="myNavBar">
    <nav class="navbar navbar-expand-lg navbar-light nav-color">

        <!-- Brand Logo / Name -->
        <a class="navbar-brand" href="FrontController?command=makeCarportForm">
            <img src="resources/fogheader.jpg" width="150" height="35" alt="fog logo image"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <!-- START navbar left float-->
            <ul class="navbar-nav mr-auto"> 

                <!-- Navbar links -->
                <!--
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?command=link&link=partslist">Stykliste </a>
                </li>
                -->
                <c:if test="${empty sessionScope.customer and empty sessionScope.employee}">
                    <li class="nav-item">
                        <a class="nav-link active" href="FrontController?command=makeCarportForm">Bestil Carport </a>
                    </li>
                </c:if>
                <c:if test="${not empty sessionScope.customer}">
                    <li class="nav-item">
                        <a class="nav-link active" href="FrontController?command=makeCarportForm">Bestil Carport </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="FrontController?command=allOrders">Se dine ordrer </a>
                    </li>
                </c:if>
                <c:if test="${not empty sessionScope.employee}">
                    <li class="nav-item">
                        <a class="nav-link active" href="FrontController?command=allOrders">Se alle ordrer </a>
                    </li>
                </c:if>
                <!-- END navbar left float-->
            </ul> 
            <!-- START navbar center float -->
            <ul class="nav navbar-nav navbar-center">
                <li id ="errormessage" class="nav-item">
                    <!-- Show errormessage to the User --> 
                    <c:if test="${not empty message}">
                        <a class="nav-link active" >  Besked: ${message} </a>
                    </c:if>
                </li>
                <!-- END navbar center float -->
            </ul>
            <!-- login button -->
            <c:if test="${empty customer && empty employee}">
                <!-- START navbar RIGHT float-->
                <ul class="nav navbar-nav navbar-right">
                    <li id="accessbutton" class="float-right"> <!-- class="nav-item" -->
                        <!-- Show log in button to the User if they are not logged in --> 
                        <form action="FrontController?command=link&link=login" method="POST"> 
                            <button type="submit" class="btn btn-outline-success btn-sm"><i class="fas fa-sign-in-alt"></i> Log ind</button>
                        </form>
                    </li>
                </ul>
                <!-- END navbar RIGHT float-->
            </c:if>
            <!-- logout button -->
            <c:if test="${not empty customer || not empty employee}">
                <!-- START navbar RIGHT float-->
                <ul class="nav navbar-nav navbar-right">
                    <!-- greeting -->
                    <c:if test="${not empty customer}">
                        <li id ="greeting" class="nav-item">
                            <a class="nav-link active" ><strong>${customer.name}</strong></a>
                        </li>
                    </c:if>
                    <c:if test="${not empty employee}">
                        <li id ="greeting" class="nav-item">
                            <a class="nav-link active" ><strong>${employee.email}</strong></a>
                        </li>
                    </c:if>
                    <li id="accessbutton" class="float-right"> <!-- class="nav-item" -->
                        <!-- Show log out button to the User if they are logged in --> 
                        <form action="FrontController?command=logOut" method="POST"> 
                            <button type="submit" class="btn btn-outline-info btn-sm"><i class="fas fa-sign-out-alt"></i> Log ud</button>
                        </form>
                    </li>
                </ul>
                <!-- END navbar RIGHT float-->
            </c:if>
        </div>

    </nav>
</div>
<!-- Navigation end -->
