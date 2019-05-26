<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<fmt:setLocale value="da_DK"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Show a single order -->
<div class="d-flex flex-row justify-content-between mt-5 mb-3">
    <div>
        <p>Kunde informationer</p>
        <p class="mb-0">Kundenummer: ${customer.id}</p>
        <p class="mb-0">${order.build_adress} ${order.build_zipcode}</p>
        <p class="mb-0">${customer.name}</p>
        <p class="mb-0">${customer.phone}</p>
        <p class="mb-0">${customer.email}</p>

    </div>
    <div>
        <p class="mb-0">Fog Trælast og Byggecenter</p>
        <p>Ordre information</p>
        <p class="mb-0">Medarbejdernummer: ${employee.id}</p>
        <p class="mb-0">Medarbejder kontaktmail: ${employee.email}</p>
        <p class="mb-0">Ordrenummer: ${order.id}</p>
        <p>Status: ${order.status}</p>
    </div>
</div>
<table class="table">
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
<!-- Order price and payment information--> 
<div class="d-flex flex-column pl-5 mt-5 mb-3 infoboxorderview">
    <div>
        <c:choose> 
            <c:when test="${order.status == 'Finalized'}">
                <p>Ordren er betalt: <span id="paidPrice"><fmt:formatNumber value="${order.price}" type="currency" currencySymbol=""/></span> DKK</p>
            </c:when>
            <c:otherwise>
                <p>Vejledende salgspris: <span id="suggestedretailprice"><fmt:formatNumber value="${suggestedprice}" type="currency" currencySymbol=""/></span> DKK</p>
            </c:otherwise>
        </c:choose>

        <c:if test= "${not empty priceOffer}">
            <p>Tilbudspris: <span id="priceoffer"><fmt:formatNumber value="${priceOffer}" type="currency" currencySymbol=""/></span> DKK</p>
            <c:if test= "${not empty sessionScope.employee}"> 
                <p>Dækningsgrad for tilbudspris: <span id="offerpricemargin"> </span> %</p>
            </c:if>
        </c:if>
        <c:if test= "${not empty sessionScope.employee && order.status != 'Finalized'}"> 
            <p>Dækningsgrad for vejledende salgspris: <span id="operationmargin"> </span> %</p>

            <div class="mt-4">
                <h5>Afgiv tilbud?</h5>
                <p>Indkøbspris: <span id="costprice"><fmt:formatNumber value="${costprice}" type="currency" currencySymbol=""/></span> DKK</p>
                <form method="POST" action="FrontController">
                    <input id="varpriceinput" placeholder="Ny pris" name="finalPrice" type="number" min="0">
                    <input type="hidden" name="command" value="viewOrder">  
                    <input type="hidden" name="orderid" value="${order.id}">
                    <p> Dækningsgrad: <span id="varpricemargin"></span>%</p>
                    <button type="submit" class="btn btn-outline-secondary mb-1">Send tilbud</button>
                </form>
            </div>
        </c:if>
    </div> 
</div>



<!-- Button to pay for the order -->
<c:if test="${order.status != 'Finalized'}">
    <div class="d-flex p-2">
        <form action="FrontController"  class="">
            <input type="hidden" name="command" value="payOrder">
            <input type="hidden" name="orderid" value="${order.id}">
            <!-- Pay reduced price if exists, else normal price -->
            <c:choose> 
                <c:when test="${not empty priceOffer}">
                    <input type="hidden" name="price" value="${priceOffer}">
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="price" value="${suggestedprice}">
                </c:otherwise>
            </c:choose>
            <c:if test="${not empty sessionScope.customer}">
                <button type="submit" class="btn btn-outline-secondary mb-1">Betal ordre</button>
            </c:if>
            <c:if test="${not empty sessionScope.employee}">
                <p>Ved kontant betaling eller betaling via bankoverførsel, så bekræft modtagelse af betaling</p>
                <button type="submit" class="btn btn-outline-secondary mb-1">Bekræft modtagelse af betaling</button>
            </c:if>
        </form>
    </div>
</c:if>
<!-- Button to see partslist and drawings if you've paid for the order. -->
<c:if test="${not empty sessionScope.customer}">
    <c:if test="${order.status == 'Finalized'}">
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
</c:if>
<c:if test="${not empty sessionScope.employee}">
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

