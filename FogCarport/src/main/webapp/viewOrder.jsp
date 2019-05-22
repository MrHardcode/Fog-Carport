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

<!-- Show info about the Customer and Employee who are tied to the order. -->
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
            <td>${employee.email}</td>
            <td>${employee.role}</td>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.phone}</td>
            <td>${customer.email}</td>
        </tr>
    </tbody>
</table>

<div class="card">
    <div class="card-body">
        <p>Vejledende salgspris: <span id="suggestedretailprice">${suggestedprice}</span> DKK</p>
        <c:if test= "${not empty priceOffer}">
            <p>Tilbudspris: <span id="priceoffer">${priceOffer}</span> DKK</p>
            <c:if test= "${not empty sessionScope.employee}"> 
                <p>Dækningsgrad for tilbudspris: <span id="operationmargin"> </span> %</p>
            </c:if>
        </c:if>
        <c:if test= "${not empty sessionScope.employee}"> 
            <p>Dækningsgrad for vejledende salgspris: <span id="operationmargin"> </span> %</p>
        </div>  
        <div class="card-body">
            <h5>Afgiv tilbud?</h5>
            <p>Indkøbspris: <span id="costprice">${costprice} </span> DKK</p>
            <form method="POST" action="FrontController">
                <input id="varpriceinput" placeholder="Ny pris" name="finalPrice" type="number" min="0">
                <input type="hidden" name="command" value="viewOrder">  
                <input type="hidden" name="orderid" value="${order.id}">
                <p> Dækningsgrad: <span id="varpricemargin"> </span> %</p>
                <button type="submit" class="btn btn-primary">Send tilbud</button>
            </form>
        </div>
    </c:if>
</div>




<!-- Button to pay for the order -->
<c:if test="${order.status != 'Finalized'}">
    <div class="d-flex p-2">
        <form action="FrontController"  class="">
            <input type="hidden" name="command" value="payOrder">
            <input type="hidden" name="orderid" value="${order.id}">
            <button type="submit" class="btn btn-primary">Betal ordre</button>
        </form>
    </div>
</c:if>
<!-- Button to see partslist and drawings if you've paid for the order. -->
<c:if test="${order.status != 'Awaiting' 
              && order.status != 'Processing'
              && order.status != 'Accepted'}">
      <div class="d-flex p-2 justify-content-center">
          <form method="POST" action="FrontController"  class="">
              <input type="hidden" name="command" value="viewPartslist">   
              <input type="hidden" name="orderid" value="${order.id}"> 
              <button type="submit" class="btn btn-primary">Se Stykliste</button>
          </form>

          <form method="POST" action="FrontController" class="" style="margin-left: 10px">
              <input type="hidden" name="command" value="viewSVG">  
              <input type="hidden" name="orderid" value="${order.id}"> 
              <button type="submit" class="btn btn-primary">Se Tegninger</button>
          </form>
      </div>
</c:if>

