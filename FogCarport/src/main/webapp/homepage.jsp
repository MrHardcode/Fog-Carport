
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Main text area, "welcome", centered -->
<div id="mainText">
    <h2>Velkommen til Fog Quickbyg</h2>
    <h6>Vi gør dine carport drømme til virkelighed</h6>
    <br><br>
</div>


<div class="d-flex justify-content-center" >
    <!-- Form start -->
    <form action="FrontController" method="POST" id="carport-form" accept-charset=utf-8>

        <input type="hidden" name="command" value="makeCarport">

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
            <select class="form-control" id="roof-inclines" name="incline">
                <option selected="selected" value="">Vælg Taghældning</option>
            </select>
        </div>

        <!-- Roof type dependant on roof incline-->
        <div class="form-group">
            <label for="flatRoofInput">Tagtype</label>
            <select class="form-control" id="roof-tiles" name="roof_tiles_id">
                <option selected="selected" value="">Vælg tagtype</option>
            </select>
        </div>

        <!-- Checkbox -->
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="check-skur" name="shed" value="y">
            <label class="form-check-label" for="CheckSkur">Vælg skur</label>
        </div>

        <!-- Shed menu part -->
        <div hidden id="carport-shed-div">
            <h1 class="h1">Byg skur</h1>
            <div class="form-group">
                <label for="ShedInputLength">Længde i cm</label>
                <select class="form-control" id="shed-length" name="shed-length"><option selected="selected" value="">Vælg længde</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ShedInputWidth">Bredde i cm</label>
                <select class="form-control" id="shed-width" name="shed-width"><option selected="selected" value="">Vælg bredde</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ShedInputFloor">Gulv</label>
                <select class="form-control" id="shed-floor" name="shed-floor-id"><option selected="selected" value="">Vælg gulv</option>
                </select>
            </div>
            <div class="form-group">
                <label for="ShedInputWall">Beklædning</label>
                <select class="form-control" id="shed-wall" name="shed-wall-id"><option selected="selected" value="">Vælg beklædning</option>
                </select>
            </div>
        </div>

        <h1 class="h1 form-group justify-content-center">Kontakt info</h1>
        <!-- Customer info -->
        <div class="form-group">
            <div class="form-group">
                <label for="inputEmail">E-mail (Dette bliver dit brugernavn)</label>
                <input type="email" class="form-control" id="inputEmail" placeholder="Eksempel@mail.dk" name="email" required>
            </div>
            <div class="form-group">
                <label for="inputName">Navn</label>
                <input type="text" class="form-control" id="inputName" placeholder="Navn" name="name" required>
            </div>
            <div class="form-group">
                <label for="inputAddress">Adresse</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="Adresse" name="adress" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-8">
                <label for="inputPhoneNumber">Telefon</label>
                <input type="number" class="form-control" id="inputPhoneNumber" placeholder="Telefonnummer" name="phonenumber" required>
            </div>
            <div class="form-group col-md-4">
                <label for="inputZip">Postnummer</label>
                <input type="number" class="form-control" id="inputZip" placeholder="Postnummer" name="zip" required>
            </div>
        </div>

        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#passwordcollapse" aria-expanded="false" aria-controls="collapseExample" name="createCustomerAccount" value="y">
            Jeg vil gerne have en bruger
        </button>

        <div class="collapse" id="passwordcollapse">
            <h2 class="h2 form-group justify-content-center">Opret bruger (valgfrit)</h2>
            <div class="form-group">
                <div class="form-group">
                    <label for="inputPassword">Adgangskode</label>
                    <input type="password" class="form-control" id="inputPassword" placeholder="********" name="password">
                </div>
                <div class="form-group">
                    <label for="inputPasswordConfirm">Angiv adgangskode igen</label>
                    <input type="password" class="form-control" id="inputPasswordConfirm" placeholder="********" name="password-confirm">
                </div>
            </div>
        </div>
        <!-- Button to submit -->
        <button type="submit" class="btn btn-primary disabled" id="submit-btn" disabled>Bestil tilbud</button>
    </form>
    <!-- Form end -->
</div>

