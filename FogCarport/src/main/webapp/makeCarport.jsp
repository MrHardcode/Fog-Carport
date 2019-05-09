
<div class="d-flex justify-content-center" >
    <!-- Form start -->
    <form action="FrontController" method="post" id="carport-form" accept-charset=utf-8>

        <!-- Hidden input: &command=simpleorder -->
        <input type="hidden" name="command" value="simpleorder">

        <h1 class="h1">Bestil Carport</h1>

        <!-- Carport Height 
        <div class="form-group">
            <label for="InputHeight">Hï¿½jde i cm</label>
            <input type="number"class="form-control" id="input-height" placeholder="Indtast hï¿½jde" name="height">
            <p hidden class="text-error-color text-error-size">Hï¿½jde skal vï¿½re mellem 200cm og 300cm</p>
        </div> -->

        <!-- Carport Length 
        <input type="number" class="form-control" id="input-length" placeholder="Indtast lï¿½ngde" name="length"> -->
        <div class="form-group">
            <label for="InputLength">Længde i cm</label>
            <select class="form-control" id="input-length" name="length"><option selected="selected" value="">Vælg længde</option>              
            </select>
            <p hidden class="text-error-color text-error-size">Længde skal være mellem 240cm og 720cm</p>
        </div>

        <!-- Carport Width 
        <input type="number" class="form-control" id="input-width" placeholder="Indtast bredde" name="width"> -->
        <div class="form-group">
            <label for="InputWidth">Bredde i cm</label>
            <select class="form-control" id="input-width" name="width"><option selected="selected" value="">Vælg bredde</option>
            </select>
            <p hidden class="text-error-color text-error-size">Bredde skal være mellem 240cm og 720cm</p>
        </div>
        <!-- Roof incline choice -->
        <div class="form-group">
            <label for="roofIncline">Taghældning</label>
            <select class="form-control" id="input-length" name="incline">
                <!--<option selected="selected" value="">Vï¿½lg taghï¿½ldning</option>  -->
                <option value="0">Fladt tag</option>
                <option value="15">15&#176;</option> <!-- &#176; = degrees symbol -->
                <option value="30">30&#176;</option>
                <option value="45">45&#176;</option>
            </select>
        </div>
        
        <!-- Flat roof selected -->
        <div class="form-group">
            <label for="flatRoofInput">Tagtype</label>
            <select class="form-control" id="input-length" name="roof_tiles_id">
                <option selected="selected" value="28">Plastmo Ecolite (Blåtonet)</option>
            </select>
        </div>

        <!-- Checkbox -->
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="check-skur" name="shed" value="y">
            <label class="form-check-label" for="CheckSkur">Vï¿½lg Skur</label>
        </div>

        <!-- Shed menu part -->
        <div hidden id="carport-shed-div">
            <h1 class="h1">Byg skur</h1>
            <div class="form-group">
                <label for="ShedInputLength">Lï¿½ngde i cm</label>
                <select class="form-control" id="shed-length" name="shed-length"><option selected="selected" value="">Vï¿½lg lï¿½ngde</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ShedInputWidth">Bredde i cm</label>
                <select class="form-control" id="shed-width" name="shed-width"><option selected="selected" value="">Vï¿½lg bredde</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ShedInputFloor">Gulv</label>
                <select class="form-control" id="shed-floor" name="shed-floor-id"><option selected="selected" value="">Vï¿½lg gulv</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ShedInputWall">Beklï¿½dning</label>
                <select class="form-control" id="shed-wall" name="shed-wall-id"><option selected="selected" value="">Vï¿½lg beklï¿½dning</option>
                </select>
            </div>
        </div>

        <h1 class="h1">Kunde info</h1>
        <!-- Customer info -->
        <div class="form-row">
            <div class="form-group col-md-7">
                <label for="inputName">Navn</label>
                <input type="text" class="form-control" id="inputName" placeholder="Navn" name="name" required>
            </div>
            <div class="form-group col-md-5">
                <label for="inputPhoneNumber">Telefon</label>
                <input type="tel" class="form-control" id="inputPhoneNumber" placeholder="Telefonnummer" name="phonenumber" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail">Email</label>
            <input type="email" class="form-control" id="inputEmail" placeholder="Example@example.com" name="email" required>
        </div>
        <div class="form-row">
            <div class="form-group col-md-8">
                <label for="inputAddress">Addresse</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="Adresse" name="adress" required>
            </div>
            <div class="form-group col-md-4">
                <label for="inputZip">Post Nr.</label>
                <input type="number" class="form-control" id="inputZip" placeholder="" name="zip" required>
            </div>
        </div>

        <!-- Button to submit -->
        <button type="submit" class="btn btn-primary disabled" id="submit-btn" disabled>Bestil Carport</button>
    </form>
    <!-- Form end -->
</div>
