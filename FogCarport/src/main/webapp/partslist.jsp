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
            <th scope="col">Hjælpe Tekst</th>
            <th scope="col">Længde i mm.</th>
            <th scope="col">Bredde i mm.</th>
            <th scope="col">Højde i mm.</th> 
            <th scope="col">Pris</th> 
        </tr>
    </thead>

    <tbody>
        <c:forEach var="material" items="${bom.billOfMaterials}">
            <tr>
                <td contenteditable='true'>${material.quantity}</td>
                <td contenteditable='true'>${material.ID}</td>
                <td contenteditable='true'>${material.description}</td>
                <td contenteditable='true'>${material.helptext}</td>
                <td contenteditable='true'>${material.length}</td>
                <td contenteditable='true'>${material.width}</td>
                <td contenteditable='true'>${material.height}</td>
                <td contenteditable='true'>${material.price}</td>
            </tr>
        </c:forEach>
    </tbody>

</table>
<!-- END OF BOM -->

Total Price: ${bom.totalprice}

<br>
<div class="d-flex justify-content-center">
    <a class="btn btn-secondary " href="FrontController?command=link&link=viewOrder">Tilbage til din valgte ordre </a>
</div>
