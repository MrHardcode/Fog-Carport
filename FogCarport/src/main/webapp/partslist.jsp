<!--The following tag is the JSTL tag-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="table table-fixed table-bordered mt-5">

    <thead class="thead-dark">
        <tr>
            <th scope="col">Antal</th>
            <th scope="col">Varenr.</th>
            <th scope="col">Beskrivelse</th>
            <th scope="col">Hjælpetekst</th>
            <th width="120" scope="col">Længde mm</th>
            <th width="115" scope="col">Bredde mm</th>
            <th width="110" scope="col">Højde mm</th> 
                <c:if test= "${not empty sessionScope.employee}"> 
                <th width="90" scope="col">Stk. pris</th> 
                </c:if>
        </tr>
    </thead>

    <tbody>
        <!-- Table Row for each Material in the Partslist. -->
        <c:forEach var="material" items="${partslistbom.billOfMaterials}">
            <tr>
                <td>${material.quantity}</td>
                <td>${material.ID}</td>
                <td>${material.description}</td>
                <td>${material.helptext}</td>
                <td>${material.length}</td>
                <td>${material.width}</td>
                <td>${material.height}</td>
                <c:if test= "${not empty sessionScope.employee}"> 
                    <td>${material.price}</td>
                </c:if>
            </tr>
        </c:forEach>
    </tbody>

</table>
<!-- END OF BOM -->

<br>
<!-- Button to go back to viewOrder -->
<div class="d-flex justify-content-center">
    <form method="POST" action="FrontController"  class="">
        <input type="hidden" name="command" value="viewOrder">   
        <input type="hidden" name="orderid" value="${ID}"> 
        <button type="submit" class="btn btn-outline-secondary mb-1">Tilbage til din valgte ordre</button>
    </form>
</div>
