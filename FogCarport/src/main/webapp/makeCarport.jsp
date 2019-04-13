<%-- 
    Document   : makeCarport
    Created on : 12-04-2019, 16:39:35
    Author     : Malte
--%>

<jsp:include page='/header.jsp'></jsp:include>

    <div class="d-flex justify-content-center" >
        <!-- Form start -->
        <form action="FrontController" method="post">
            
            <!-- Hidden input: &command=Carport -->
            <input type="hidden" name="command" value="Carport">
            
            <h1>Bestil Carport</h1>

            <!-- Height -->
            <div class="form-group">
                <label for="InputHeight">Højde</label>
                <input type="number" required class="form-control" id="InputHeight" placeholder="Indtast højde">
            </div>

            <!-- Length -->
            <div class="form-group">
                <label for="InputLength">Længde</label>
                <input type="number" required class="form-control" id="InputLength" placeholder="Indtast længde">
            </div>

            <!-- Width -->
            <div class="form-group">
                <label for="InputWidth">Bredde</label>
                <input type="number" required class="form-control" id="InputWidth" placeholder="Indtast bredde">
            </div>

            <!-- Checkbox -->
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="CheckSkur">
                <label class="form-check-label" for="CheckSkur">Vælg Skur</label>
            </div>

            <!-- Button to submit -->
            <button type="submit" class="btn btn-primary">Bestil Skur</button>
            
        </form>
        <!-- Form end -->
    </div>

<jsp:include page='/footer.jsp'></jsp:include>
