
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <!--Main text area, "welcome", centered -->
    <div id="mainText">
        <h2>Velkommen til Fog Quickbyg</h2>
        <h6>Vi gør dine carport drømme til virkelighed</h6>
        <br><br>
        <p>Hvordan vil du fortsætte?</p>
    </div>

    <div id="mainOptions" class="offset-md-4">

        <form id="optionOffer" action="FrontController?command=link&link=makeCarport"> <!-- /FrontController?command=simpleorder--> <!-- We redirect to .jsp instead of using the frontcontroller pattern (correctly in this case)-->
            <label>Indhent tilbud</label>
            <br>
            <a href="FrontController?command=link&link=makeCarport" class="btn btn-primary" role="button"><i class="fas fa-warehouse"></i> Fortsæt</a>
        </form>
    </div>
    <div id="mainOptions">
        <form id="optionOther" action="index.jsp">
            <label>Gør noget andet</label>
            <br>
            <a href="FrontController?command=link&link=homepage" class="btn btn-primary" role="button"><i class="fas fa-question-circle"></i> Fortsæt</a>

        </form>
    </div>
