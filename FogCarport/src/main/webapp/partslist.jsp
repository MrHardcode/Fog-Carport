<%-- 
    Document   : bom
    Created on : 13-04-2019, 14:23:06
    Author     : Malte
--%>

<!--The following tag is the JSTL Expression Language tag-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page='/header.jsp'></jsp:include>

    <!-- Styklisten - Bill of Materials (b.o.m.) -->

    <!-- BOM table using Expression Language and Bootstrap --> 

    <table border="3" width="2" cellspacing="2" cellpadding="2" class="table table-bordered table-hover">

        <thead class="thead-dark">
            <tr>
                <th scope="col">Beskrivelse</th>
                <th scope="col">Længde</th>
                <th scope="col">Antal</th>
                <th scope="col">Enhed</th>
                <th scope="col">Beskrivelse</th>
            </tr>
        </thead>

        <tbody>
        <c:forEach var="material" items="${bom.billOfMaterials}">
            <tr>
                <td>${material.name}</td>
                <td>${material.length}</td>
                <td>${material.quantity}</td>
                <td>${material.unit}</td>
                <td>${material.description}</td>
            </tr>
        </c:forEach>
    </tbody>

</table>
<!-- END OF BOM -->

<jsp:include page='/footer.jsp'></jsp:include>
