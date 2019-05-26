
<div class="form-group mx-auto infoBody">
    <form action="FrontController" method="POST" id="create-user-form" accept-charset=utf-8>
        
        <!-- createUser command -->
        <input type="hidden" name="command" value="createUser">
        
        <!-- Headline -->
        <h1 class="h1 form-group justify-content-center">Kundeinfo</h1>

        <h4 class="h4 form-group justify-content-center">Opret bruger ved at indtaste dine oplysninger herunder</h4>
        
        <!-- Customer info -->
        <div class="form-group">
            <!-- Email -->
            <div class="form-group">
                <label for="inputEmail">E-mail (Dette bliver dit brugernavn)</label>
                <input type="email" class="form-control" id="inputEmail" placeholder="Eksempel@mail.dk" name="email" required>
            </div>
            <!-- Password -->
            <div class="form-group">
                <label for="inputPassword">Adgangskode</label>
                <input type="password" class="form-control" id="inputPassword" placeholder="********" name="password" required>
            </div>
            <!-- Password used to check that user has input the right password. If both passwords match each other, we're good to go. -->
            <div class="form-group">
                <label for="inputPasswordConfirm">Angiv adgangskode igen</label>
                <input type="password" class="form-control" id="inputPasswordConfirm" placeholder="********" name="password-confirm" required>
            </div>
            <!-- Name -->
            <div class="form-group">
                <label for="inputName">Navn</label>
                <input type="text" class="form-control" id="inputName" placeholder="Navn" name="name" required>
            </div>
            <!-- Phonenumber -->
            <div class="form-group">
                <label for="inputPhoneNumber">Telefon</label>
                <input type="number" class="form-control col-md-4" id="inputPhoneNumber" placeholder="Telefonnummer" name="phonenumber" required>
            </div>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-outline-secondary mb-1" id="submit-btn">Opret og log ind</button>
    </form>
</div>
