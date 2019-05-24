<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Main text area, "welcome", centered -->
<div id="mainText">
    <h2>Velkommen til Fog Quickbyg</h2>
    <h6>Vi gør dine carportdrømme til virkelighed</h6>
    <br><br>
</div>

<div class="d-flex justify-content-center" >
    <!-- Form start -->
    <form action="FrontController" method="POST" id="carport-form" accept-charset=utf-8>
        <!-- command = makeCarport -->
        <input type="hidden" name="command" value="makeCarport">

        <h1 class="h1">Bestil Carport</h1>

        <!-- Carport Height - From Sprint 1 - Simple Partslist - (Deprecated - Was used for the simple carport partslist, which is no longer used. Was part of the first sprint.
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
                <option selected="selected" value="">Vælg Tagtype</option>
            </select>
        </div>

        <!-- Hidden elements used by JS to populate the menus -->
        <div class="all-roof-options" hidden="hidden">
            <c:forEach var="option" items="${flatRoofParts}">
                <input class="flat-roof-id" value="${option.getID()}">
                <input class="flat-roof-name" value="${option.getDescription()}">
            </c:forEach>
            <c:forEach var="option" items="${raisedRoofParts}">
                <input class="raised-roof-id" value="${option.getID()}">
                <input class="raised-roof-name" value="${option.getDescription()}">
            </c:forEach>
        </div>

        <!-- Checkbox -->
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="check-skur" name="shed" value="y">
            <label class="form-check-label" for="CheckSkur">Vælg skur</label>
        </div>

        <!-- Shed menu part -->
        <div hidden id="carport-shed-div">
            <!-- Headline -->
            <h1 class="h1">Byg skur</h1>
            <!-- Length of the shed -->
            <div class="form-group">
                <label for="ShedInputLength">Længde i cm</label>
                <select class="form-control" id="shed-length" name="shed-length"><option selected="selected" value="">Vælg længde</option>
                </select>
            </div>
            <!-- Width of the shed -->
            <div class="form-group">
                <label for="ShedInputWidth">Bredde i cm</label>
                <select class="form-control" id="shed-width" name="shed-width"><option selected="selected" value="">Vælg bredde</option>
                </select>
            </div>
            <!-- Type of wood used for the shed floor. -->
            <div class="form-group">
                <label for="ShedInputFloor">Gulv</label>
                <select class="form-control" id="shed-floor" name="shed-floor-id"><option selected="selected" value="">Vælg gulv</option>
                    <c:forEach var="item" items="${shedFloorParts}">
                        <option value="${item.getID()}">${item.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <!-- Type of wood used for the shed walls. -->
            <div class="form-group">
                <label for="ShedInputWall">Beklædning</label>
                <select class="form-control" id="shed-wall" name="shed-wall-id"><option selected="selected" value="">Vælg beklædning</option>
                    <c:forEach var="item" items="${shedWallParts}">
                        <option value="${item.getID()}">${item.getName()}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- IF LOGGED IN --> 
        <c:if test="${not empty sessionScope.customer}">
            <!-- Headline -->
            <h1 class="h1">Kunde info</h1>
            <!-- Customer info -->
            <div class="form-row">
                <!-- Adress -->
                <div class="form-group col-md-8">
                    <label for="inputAddress">Adresse</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="Adresse" name="adress" required>
                </div>
                <!-- Zipcode -->
                <div class="form-group col-md-4">
                    <label for="inputZip">Postnummer</label>
                    <input type="number" class="form-control" id="inputZip" placeholder="Postnummer" name="zip" required>
                </div>
            </div>
        </c:if>
        <!-- IF NOT LOGGED IN --> 
        <c:if test="${empty sessionScope.customer}">
            <!-- Headline, contact info -->
            <h1 class="h1 form-group justify-content-center">Kontaktinfo</h1>
            <!-- Customer info -->
            <div class="form-group">
                <!-- Email -->
                <div class="form-group">
                    <label for="inputEmail">E-mail (Dette bliver dit brugernavn)</label>
                    <input type="email" class="form-control" id="inputEmail" placeholder="Eksempel@mail.dk" name="email" required>
                </div>
                <!-- Name -->
                <div class="form-group">
                    <label for="inputName">Navn</label>
                    <input type="text" class="form-control" id="inputName" placeholder="Navn" name="name" required>
                </div>
                <!-- Adress -->
                <div class="form-group">
                    <label for="inputAddress">Adresse</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="Adresse" name="adress" required>
                </div>
            </div>
            <div class="form-row">
                <!-- Phone number -->
                <div class="form-group col-md-8">
                    <label for="inputPhoneNumber">Telefon</label>
                    <input type="number" class="form-control" id="inputPhoneNumber" placeholder="Telefonnummer" name="phonenumber" required>
                </div>
                <!-- Zipcode -->
                <div class="form-group col-md-4">
                    <label for="inputZip">Postnummer</label>
                    <input type="number" class="form-control" id="inputZip" placeholder="Postnummer" name="zip" required>
                </div>
            </div>

            <!-- If the customer wants a login, so they can see their order. -->
            <button class="btn btn-outline-secondary mb-1" type="button" data-toggle="collapse" data-target="#passwordcollapse" aria-expanded="false" aria-controls="collapseExample" name="createCustomerAccount" value="y">
                Jeg vil gerne have en bruger
            </button>

            <div class="collapse" id="passwordcollapse">
                <!-- Headline - create login (optional) -->
                <h2 class="h2 form-group justify-content-center">Opret bruger (valgfrit)</h2>
                <div class="form-group">
                    <!-- Password -->
                    <div class="form-group">
                        <label for="inputPassword">Adgangskode</label>
                        <input type="password" class="form-control" id="inputPassword" placeholder="********" name="password">
                    </div>
                    <!-- Repeat password -->
                    <div class="form-group">
                        <label for="inputPasswordConfirm">Angiv adgangskode igen</label>
                        <input type="password" class="form-control" id="inputPasswordConfirm" placeholder="********" name="password-confirm">
                    </div>
                </div>
            </div>

            <br>
            <br>
        </c:if>

        <!-- Button to submit -->
        <button type="submit" class="btn btn-outline-secondary mb-1 disabled" id="submit-btn" disabled>Bestil tilbud</button>
    </form>
    <!-- Form end -->
</div>
