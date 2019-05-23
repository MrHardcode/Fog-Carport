<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Show a single order -->
<div class="d-flex flex-row justify-content-between mt-5 mb-3">
    <div class="pl-5">
        <p>Kunde informationer</p>
        <p class="mb-0">Kundenummer: ${customer.id}</p>
        <p class="mb-0">${order.build_adress} ${order.build_zipcode}</p>
        <p class="mb-0">${customer.name}</p>
        <p class="mb-0">${customer.phone}</p>
        <p class="mb-0">${customer.email}</p>

    </div>
    <div class="pr-5">
        <p class="mb-0">Fog Trælast og Byggecenter</p>
        <p>Ordre information</p>
        <p class="mb-0">Medarbejdernummer: ${employee.id}</p>
        <p class="mb-0">Medarbejder kontaktmail: ${employee.email}</p>
        <p class="mb-0">Ordrenummer: ${order.id}</p>
        <p>Status: ${order.status}</p>
    </div>
</div>
<table class="table table-hover">
    <thead>
        <tr>
            <th class="text-center" rowspan="1" colspan="4">Carport</th>
                <c:if test= "${order.shed_width != 0}">
                <th class="text-center borderleft" rowspan="1" colspan="4">Skur</th>
                </c:if>
        </tr>
        <tr>
            <th scope="col">Bredde</th>
            <th scope="col">Længde</th>
            <th scope="col">Hældning</th>
            <th scope="col">Tagsten</th>
                <c:if test= "${order.shed_width != 0}">
                <th class="borderleft" scope="col">Bredde</th>
                <th scope="col">Længde</th>
                <th scope="col">Vægmateriale</th>
                <th scope="col">Gulvmateriale</th>
                </c:if>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${order.width}mm.</td>
            <td>${order.length}mm.</td>
            <td>${order.incline} grader</td>
            <td>${tile}</td>
            <c:if test= "${order.shed_width != 0}">
                <td>${order.shed_width}mm.</td>
                <td>${order.shed_length}mm.</td>
                <td>${shedwalls}</td>
                <td>${shedfloor}</td>
            </c:if>
        </tr>
    </tbody>
</table>
<hr>
<div class="d-flex flex-column pl-5 mt-5 mb-3">
    <div>
        <p>Vejledende salgspris: <span id="suggestedretailprice">${suggestedprice}</span> DKK</p>
        <c:if test= "${not empty priceOffer}">
            <p>Tilbudspris: <span id="priceoffer">${priceOffer}</span> DKK</p>
            <c:if test= "${not empty sessionScope.employee}"> 
                <p>Dækningsgrad for tilbudspris: <span id="offerpricemargin"> </span> %</p>
            </c:if>
        </c:if>
        <c:if test= "${not empty sessionScope.employee}"> 
            <p>Dækningsgrad for vejledende salgspris: <span id="operationmargin"> </span> %</p>
        </c:if>
    </div>  
    <c:if test= "${not empty sessionScope.employee}">
        <div class="mt-4">
            <h5>Afgiv tilbud?</h5>
            <p>Indkøbspris: <span id="costprice">${costprice} </span> DKK</p>
            <form method="POST" action="FrontController">
                <input id="varpriceinput" placeholder="Ny pris" name="finalPrice" type="number" min="0">
                <input type="hidden" name="command" value="viewOrder">  
                <input type="hidden" name="orderid" value="${order.id}">
                <p> Dækningsgrad: <span id="varpricemargin"> </span> %</p>
                <button type="submit" class="btn btn-outline-secondary mb-1">Send tilbud</button>
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
            <button type="submit" class="btn btn-outline-secondary mb-1">Betal ordre</button>
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
              <button type="submit" class="btn btn-outline-secondary mb-1">Se Stykliste</button>
          </form>

          <form method="GET" action="FrontController" class="" style="margin-left: 10px">
              <input type="hidden" name="command" value="viewSVG">  
              <input type="hidden" name="orderid" value="${order.id}"> 
              <button type="submit" class="btn btn-outline-secondary mb-1">Se Tegninger</button>
          </form>
      </div>
</c:if>

