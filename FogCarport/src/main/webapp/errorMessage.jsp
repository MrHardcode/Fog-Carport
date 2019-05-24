<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--The following tag is the JSTL Expression Language tag-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Show errormessage to the User --> 
<c:if test="${not empty errormessage}">
    <br>
    <div class="jumbotron">
        <div class="d-flex justify-content-center">
            <h1 class="display-4">Fejl!</h1>
        </div>
        <div class="d-flex justify-content-center">
            <p class="lead">${errormessage}</p>
        </div>
        <hr class="my-4">
        <div class="d-flex justify-content-center">
            <button class="btn btn-primary btn-lg" onclick="goBack()">Gå tilbage</button>
        </div>
    </div>
</div>

<script>
    function goBack() {
        window.history.back();
    }
</script>

</c:if>
