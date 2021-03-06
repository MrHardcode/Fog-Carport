<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "en">
    <head>
        <link rel="icon" type="image/png" href="resources/favicon.png" />
        <base href="${pageContext.request.contextPath}/" />
        <!-- meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fog Carport</title>

        <!--The following tag is the JSTL Expression Language tag-->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!-- Insert bootstrap CSS - integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">

        <!-- Insert FontAwesome CSS - integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"  crossorigin="anonymous">

        <!-- Custom stylesheet -->
        <link href="css/global.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <!-- Navbar include. -->
        <jsp:include page='/navbar.jsp'></jsp:include>

        <!-- MASTER INCLUDE -->
        <div class="container">
            <jsp:include page='${target}.jsp'></jsp:include>
        </div>

        <!-- FOOTER -->
        <div class="footer">
            <div id="gitLinkText" class="hover">Project Site</div>
            <a href="https://github.com/HrBjarup/Fog-Carport" target="_blank"><img src="resources/GitHubLogo.png" alt="github logo"/></a>
        </div>
        <!-- FOOTER END -->

        <!-- JQUERY JS -->
        <script src="https://code.jquery.com/jquery-3.4.0.min.js" crossorigin="anonymous"></script>
        <!-- BOOTSTRAP JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <!-- SWEETALERT JS -->
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <!-- CUSTOM JS -->
        <script src="javascript/global.js" type="text/javascript" charset="utf-8"></script>
    </body>
</html>
