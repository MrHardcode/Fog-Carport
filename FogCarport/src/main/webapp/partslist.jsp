<%-- 
    Document   : bom
    Created on : 13-04-2019, 14:23:06
    Author     : Malte
--%>

<!--The following tag is the JSTL tag-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page='/header.jsp'></jsp:include>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Fog Carport</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="partslist.jsp">Stykliste <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="makeCarport.jsp">Lav Carport </a>
      </li>
    </ul>
  </div>
</nav>
<!-- Navigation end -->

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
