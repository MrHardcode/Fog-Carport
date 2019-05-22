<!--The following tag is the JSTL tag-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Styklisten - Bill of Materials (b.o.m.) -->

<!-- BOM table using JSTL, Expression Language and Bootstrap --> 
<table border="3" width="2" cellspacing="2" cellpadding="2" class="table table-bordered table-hover">

    <thead class="thead-dark">
        <tr>
            <th scope="col">Antal</th>
            <th scope="col">Vare Nummer</th>
            <th scope="col">Vare Beskrivelse</th>
            <th scope="col">Hj�lpe Tekst</th>
            <th scope="col">L�ngde i mm.</th>
            <th scope="col">Bredde i mm.</th>
            <th scope="col">H�jde i mm.</th> 
                <c:if test= "${not empty sessionScope.employee}"> 
                <th scope="col">Pris</th> 
                </c:if>
        </tr>
    </thead>

    <tbody>
        <!-- Table Row for each Material in the Partslist. -->
        <c:forEach var="material" items="${partslistbom.billOfMaterials}">
            <tr>
                <td contenteditable='true'>${material.quantity}</td>
                <td contenteditable='true'>${material.ID}</td>
                <td contenteditable='true'>${material.description}</td>
                <td contenteditable='true'>${material.helptext}</td>
                <td contenteditable='true'>${material.length}</td>
                <td contenteditable='true'>${material.width}</td>
                <td contenteditable='true'>${material.height}</td>
                <c:if test= "${not empty sessionScope.employee}"> 
                    <td contenteditable='true'>${material.price}</td>
                </c:if>
            </tr>
        </c:forEach>
    </tbody>

</table>
<!-- END OF BOM -->

<!-- show total price if employee-->
<c:if test= "${not empty sessionScope.employee}"> 
    Pris: ${partslistbom.totalprice}
</c:if>

<br>
<!-- Button to go back to viewOrder -->
<div class="d-flex justify-content-center">
    <form method="POST" action="FrontController"  class="">
        <input type="hidden" name="command" value="viewOrder">   
        <input type="hidden" name="orderid" value="${ID}"> 
        <button type="submit" class="btn btn-primary">Tilbage til din valgte ordre</button>
    </form>
</div>
