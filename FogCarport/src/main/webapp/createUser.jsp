<!-- Taken from makeCarport.jsp - change at will - Needs password etc - Needs Command - -->
<div class="form-group mx-auto infoBody">
    <form action="FrontController" method="post" id="create-user-form" accept-charset=utf-8>
        
        <input type="hidden" name="command" value="createUser">
        
        <h1 class="h1 form-group justify-content-center">Kundeinfo</h1>

        <h4 class="h4 form-group justify-content-center">Opret bruger ved at indtaste dine oplysninger herunder</h4>
        <!-- Customer info -->

        <div class="form-group">
            <div class="form-group">
                <label for="inputEmail">E-mail (Dette bliver dit brugernavn)</label>
                <input type="email" class="form-control" id="inputEmail" placeholder="Eksempel@mail.dk" name="email" required>
            </div>
            <div class="form-group">
                <label for="inputPassword">Adgangskode</label>
                <input type="password" class="form-control" id="inputPassword" placeholder="********" name="password" required>
            </div>
            <div class="form-group">
                <label for="inputPasswordConfirm">Angiv adgangskode igen</label>
                <input type="password" class="form-control" id="inputPasswordConfirm" placeholder="********" name="password-confirm" required>
            </div>
            <div class="form-group">
                <label for="inputName">Navn</label>
                <input type="text" class="form-control" id="inputName" placeholder="Navn" name="name" required>
            </div>
            <div class="form-group">
                <label for="inputPhoneNumber">Telefon</label>
                <input type="number" class="form-control col-md-4" id="inputPhoneNumber" placeholder="Telefonnummer" name="phonenumber" required>
            </div>

        </div>

        <div class="form-row">
            <div class="form-group col-md-9">
                <label for="inputAddress">Adresse</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="Adresse" name="address" required>
            </div>
            <div class="form-group col-md-3">
                <label for="inputZip">Postnummer</label>
                <input type="number" class="form-control" id="inputZip" placeholder="XXXX" name="zip" required>
            </div>
        </div>
        
        <!-- Submit button -->
        <button type="submit" class="btn btn-primary" id="submit-btn">Opret og log ind</button>
    </form>
</div>
