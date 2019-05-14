
<div class="d-flex justify-content-center" >
    <!-- Form start -->
    <form action="FrontController" method="post" id="carport-form" accept-charset=utf-8>

        <input type="hidden" name="command" value="makeCarport">

        <h1 class="h1">Bestil Carport</h1>

        <!-- Carport Height 
        <div class="form-group">
            <label for="InputHeight">H�jde i cm</label>
            <input type="number"class="form-control" id="input-height" placeholder="Indtast h�jde" name="height">
            <p hidden class="text-error-color text-error-size">H�jde skal v�re mellem 200cm og 300cm</p>
        </div> -->

        <!-- Carport Length 
        <input type="number" class="form-control" id="input-length" placeholder="Indtast l�ngde" name="length"> -->
        <div class="form-group">
            <label for="InputLength">L�ngde i cm</label>
            <select class="form-control" id="input-length" name="length"><option selected="selected" value="">V�lg l�ngde</option>              
            </select>
            <p hidden class="text-error-color text-error-size">L�ngde skal v�re mellem 240cm og 720cm</p>
        </div>

        <!-- Carport Width 
        <input type="number" class="form-control" id="input-width" placeholder="Indtast bredde" name="width"> -->
        <div class="form-group">
            <label for="InputWidth">Bredde i cm</label>
            <select class="form-control" id="input-width" name="width"><option selected="selected" value="">V�lg bredde</option>
            </select>
            <p hidden class="text-error-color text-error-size">Bredde skal v�re mellem 240cm og 720cm</p>
        </div>
        <!-- Roof incline choice -->
        <div class="form-group">
            <label for="roofIncline">Tagh�ldning</label>
            <select class="form-control" id="roof-inclines" name="incline">
                <option selected="selected" value="">V�lg Tagh�ldning</option>
            </select>
        </div>

        <!-- Roof type dependant on roof incline-->
        <div class="form-group">
            <label for="flatRoofInput">Tagtype</label>
            <select class="form-control" id="roof-tiles" name="roof_tiles_id">
                <option selected="selected" value="">V�lg tagtype</option>
            </select>
        </div>

        <!-- Checkbox -->
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="check-skur" name="shed" value="y">
            <label class="form-check-label" for="CheckSkur">V�lg skur</label>
        </div>

        <!-- Shed menu part -->
        <div hidden id="carport-shed-div">
            <h1 class="h1">Byg skur</h1>
            <div class="form-group">
                <label for="ShedInputLength">L�ngde i cm</label>
                <select class="form-control" id="shed-length" name="shed-length"><option selected="selected" value="">V�lg l�ngde</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ShedInputWidth">Bredde i cm</label>
                <select class="form-control" id="shed-width" name="shed-width"><option selected="selected" value="">V�lg bredde</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ShedInputFloor">Gulv</label>
                <select class="form-control" id="shed-floor" name="shed-floor-id"><option selected="selected" value="">V�lg gulv</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ShedInputWall">Bekl�dning</label>
                <select class="form-control" id="shed-wall" name="shed-wall-id"><option selected="selected" value="">V�lg bekl�dning</option>
                </select>
            </div>
        </div>

        <h1 class="h1">Kunde info</h1>
        <!-- Customer info -->
        <div class="form-row">
            <div class="form-group col-md-8">
                <label for="inputAddress">Adresse</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="Adresse" name="adress" required>
            </div>
            <div class="form-group col-md-4">
                <label for="inputZip">Postnummer</label>
                <input type="number" class="form-control" id="inputZip" placeholder="Postnummer" name="zip" required>
            </div>
        </div>

        <!-- Button to submit -->
        <button type="submit" class="btn btn-primary disabled" id="submit-btn" disabled>Bestil tilbud</button>
    </form>
    <!-- Form end -->
</div>
