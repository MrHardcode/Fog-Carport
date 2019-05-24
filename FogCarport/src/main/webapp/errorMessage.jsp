<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Show errormessage to the User --> 
<c:if test="${not empty message}">
    <h1>  Besked: ${message} </h1>
</c:if>
