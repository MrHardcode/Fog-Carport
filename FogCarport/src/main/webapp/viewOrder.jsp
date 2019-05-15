<%@page import="data.models.PartslistModel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Show a single order -->
<table class="table table-hover">
    <thead>
        <tr>
            <th scope="col">Order ID</th>
            <th scope="col">Adress</th>
            <th scope="col">Zipcode</th>
            <th scope="col">Status</th>
            <th scope="col">Width</th>
            <th scope="col">Length</th>
            <th scope="col">Incline</th>
            <th scope="col">Roof Tiles</th>
            <th scope="col">Shed Width</th>
            <th scope="col">Shed Length</th>
            <th scope="col">Shed Walls</th>
            <th scope="col">Shed Floor</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${order.id}</td>
            <td>${order.build_adress}</td>
            <td>${order.build_zipcode}</td>
            <td>${order.status}</td>
            <td>${order.width}mm.</td>
            <td>${order.length}mm.</td>
            <td>${order.incline}degrees.</td>
            <td>${tile}</td>
            <td>${order.shed_width}mm.</td>
            <td>${order.shed_length}mm.</td>
            <td>${shedwalls}</td>
            <td>${shedfloor}</td>
        </tr>
    </tbody>
</table>

<!-- Show Customer and Employee -->
<table class="table table-hover">
    <thead>
        <tr>
            <th scope="col">ID Employee</th>
            <th scope="col">Employee Name</th>
            <th scope="col">Employee Role</th>
            <th scope="col">ID Customer</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Customer Phone</th>
            <th scope="col">Customer Email</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.role}</td>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.phone}</td>
            <td>${customer.email}</td>
        </tr>
    </tbody>
</table>


<div class="d-flex justify-content-center">
    <form method="POST" action="FrontController"  class="d-flex justify-content-start">
        <input type="hidden" name="command" value="viewPartslist">      
        <input type="hidden" name="orderid" value="${order.id}"> 
        <button type="submit" class="btn btn-primary">Se Stykliste</button>
    </form>

    <form action="FrontController" class="d-flex justify-content-end" style="margin-left: 10px">
        <input type="hidden" name="command" value="viewSVG"> 
        <input type="hidden" name="orderid" value="${order.id}"> 
        <button type="submit" class="btn btn-primary">Se Tegninger</button>
    </form>
</div>