<%-- 
    Document   : bom
    Created on : 13-04-2019, 14:23:06
    Author     : Malte
--%>

<!--The following tag is the JSTL tag-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page='/header.jsp'></jsp:include>

    <!-- Styklisten - Bill of Materials (b.o.m.) -->

    <!-- BOM table using JSTL, Expression Language and Bootstrap --> 
    <table border="3" width="2" cellspacing="2" cellpadding="2" class="table table-bordered table-hover">

        <thead class="thead-dark">
            <tr>
                <th scope="col">Antal</th>
                <th scope="col">Vare Nummer</th>
                <th scope="col">Vare Beskrivelse</th>
                <th scope="col">Hjælpe Tekst</th>
                <th scope="col">Længde</th>
                <th scope="col">Bredde</th>
                <th scope="col">Højde</th> 
            </tr>
        </thead>

        <tbody>
        <c:forEach var="material" items="${bom.billOfMaterials}">
            <tr>
                <td>${material.quantity}</td>
                <td>${material.ID}</td>
                <td>${material.description}</td>
                <td>${material.helptext}</td>
                <td>${material.length}</td>
                <td>${material.width}</td>
                <td>${material.height}</td>
            </tr>
        </c:forEach>
    </tbody>

</table>
<!-- END OF BOM -->

<jsp:include page='/footer.jsp'></jsp:include>
