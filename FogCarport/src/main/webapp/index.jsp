<%-- 
    Document   : index
    Created on : 11-04-2019, 22:36:17
    Author     : Asger
--%>

<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page='/header.jsp'></jsp:include>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Fog Carport</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="partslist.jsp">Stykliste </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="makeCarport.jsp">Lav Carport </a>
      </li>
    </ul>
  </div>
</nav>
<!-- Navigation end -->

    <!--Main text area, "welcome", centered -->
    <div id="mainText">
        <h2>Velkommen til Fog Quickbyg</h2>
        <h6>Vi gør dine carport drømme til virkelighed</h6>
        <br><br>
        <p>Hvordan vil du fortsætte?</p>
    </div>

    <div id="mainOptions" class="offset-md-4">

        <form id="optionOffer" action="http://localhost:8084/FogCarport/makeCarport.jsp"> <!-- /FrontController?command=simpleorder--> <!-- We redirect to .jsp instead of using the frontcontroller pattern (correctly in this case)-->
            <label>Indhent tilbud</label>
            <br>
            <a href="http://localhost:8084/FogCarport/makeCarport.jsp" class="btn btn-primary" role="button"><i class="fas fa-warehouse"></i> Fortsæt</a>
        </form>
    </div>
    <div id="mainOptions">
        <form id="optionOther" action="index.jsp">
            <label>Gør noget andet</label>
            <br>
            <a href="#" class="btn btn-primary" role="button"><i class="fas fa-question-circle"></i> Fortsæt</a>

        </form>
    </div>


<jsp:include page='/footer.jsp'></jsp:include>
