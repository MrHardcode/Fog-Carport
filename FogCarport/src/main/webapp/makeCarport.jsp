<%-- 
    Document   : makeCarport
    Created on : 12-04-2019, 16:39:35
--%>

<jsp:include page='/header.jsp'></jsp:include>

    <div class="d-flex justify-content-center" >
        <!-- Form start -->
        <form action="FrontController" method="post" id="carport-form">

            <!-- Hidden input: &command=simpleorder -->
            <input type="hidden" name="command" value="simpleorder">

            <h1>Bestil Carport</h1>

            <!-- Height 
            <div class="form-group">
                <label for="InputHeight">Højde i cm</label>
                <input type="number"class="form-control" id="input-height" placeholder="Indtast højde" name="height">
                <p hidden class="text-error-color text-error-size">Højde skal være mellem 200cm og 300cm</p>
            </div> -->

            <!-- Length 
            <input type="number" class="form-control" id="input-length" placeholder="Indtast længde" name="length"> -->
            <div class="form-group">
                <label for="InputLength">Længde i cm</label>
                <select class="form-control" id="input-length" name="length"><option selected="selected" value="">Vælg længde</option>
                    <option value="240 cm">240 cm</option>
                    <option value="270 cm">270 cm</option>
                    <option value="300 cm">300 cm</option>
                    <option value="330 cm">330 cm</option>
                    <option value="360 cm">360 cm</option>
                    <option value="390 cm">390 cm</option>
                    <option value="420 cm">420 cm</option>
                    <option value="450 cm">450 cm</option>
                    <option value="480 cm">480 cm</option>
                    <option value="510 cm">510 cm</option>
                    <option value="540 cm">540 cm</option>
                    <option value="570 cm">570 cm</option>
                    <option value="600 cm">600 cm</option>
                    <option value="630 cm">630 cm</option>
                    <option value="660 cm">660 cm</option>
                    <option value="690 cm">690 cm</option>
                    <option value="720 cm">720 cm</option>
                    <option value="750 cm">750 cm</option>
                </select>
                <p hidden class="text-error-color text-error-size">Længde skal være mellem 240cm og 720cm</p>
            </div>

            <!-- Width 
            <input type="number" class="form-control" id="input-width" placeholder="Indtast bredde" name="width"> -->
            <div class="form-group">
                <label for="InputWidth">Bredde i cm</label>
                <select class="form-control" id="input-width" name="width"><option selected="selected" value="">Vælg bredde</option>
                    <option value="240 cm">240 cm</option>
                    <option value="270 cm">270 cm</option>
                    <option value="300 cm">300 cm</option>
                    <option value="330 cm">330 cm</option>
                    <option value="360 cm">360 cm</option>
                    <option value="390 cm">390 cm</option>
                    <option value="420 cm">420 cm</option>
                    <option value="450 cm">450 cm</option>
                    <option value="480 cm">480 cm</option>
                    <option value="510 cm">510 cm</option>
                    <option value="540 cm">540 cm</option>
                    <option value="570 cm">570 cm</option>
                    <option value="600 cm">600 cm</option>
                    <option value="630 cm">630 cm</option>
                    <option value="660 cm">660 cm</option>
                    <option value="690 cm">690 cm</option>
                    <option value="720 cm">720 cm</option>
                    <option value="750 cm">750 cm</option>
                </select>
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
