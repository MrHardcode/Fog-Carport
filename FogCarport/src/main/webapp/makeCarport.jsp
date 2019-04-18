<%-- 
    Document   : makeCarport
    Created on : 12-04-2019, 16:39:35
--%>

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
      <li class="nav-item active">
        <a class="nav-link" href="makeCarport.jsp">Lav Carport <span class="sr-only">(current)</span></a>
      </li>
    </ul>
  </div>
</nav>
<!-- Navigation end -->

    <div class="d-flex justify-content-center" >
        <!-- Form start -->
        <form action="FrontController" method="post" id="carport-form">
            
            <!-- Hidden input: &command=simpleorder -->
            <input type="hidden" name="command" value="simpleorder">
            
            <h1>Bestil Carport</h1>

            <!-- Height -->
            <div class="form-group">
                <label for="InputHeight">Højde i cm</label>
                <input type="number"class="form-control" id="input-height" placeholder="Indtast højde" name="height">
                <p hidden class="text-error-color text-error-size">Højde skal være mellem 200cm og 300cm</p>
            </div>

            <!-- Length -->
            <div class="form-group">
                <label for="InputLength">Længde i cm</label>
                <input type="number" class="form-control" id="input-length" placeholder="Indtast længde" name="length">
                <p hidden class="text-error-color text-error-size">Længde skal være mellem 240cm og 720cm</p>
            </div>

            <!-- Width -->
            <div class="form-group">
                <label for="InputWidth">Bredde i cm</label>
                <input type="number" class="form-control" id="input-width" placeholder="Indtast bredde" name="width">
                <p hidden class="text-error-color text-error-size">Bredde skal være mellem 240cm og 720cm</p>
            </div>

            <!-- Checkbox -->
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="check-skur" name="shed" value="y">
                <label class="form-check-label" for="CheckSkur">Vælg Skur</label>
            </div>

            <!-- Button to submit -->
            <button type="submit" class="btn btn-primary" id="submit-btn" style="margin-top: 5px;">Bestil Carport</button>
            
        </form>
        <!-- Form end -->
    </div>

<jsp:include page='/footer.jsp'></jsp:include>
