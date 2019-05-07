<%-- 
    Document   : viewOrder
    Created on : 05-05-2019, 19:06:41
    Author     : Malte
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page='/header.jsp'></jsp:include>

<!-- Show a single order -->
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
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

<jsp:include page='/footer.jsp'></jsp:include>

