<%-- 
    Document   : makeCarportShed
    Created on : 28-04-1992, 17:50:40
    Author     : Asger
--%>

<jsp:include page='/header.jsp'></jsp:include>
    <div id="shed-menu" class="d-flex justify-content-center">
        <form action="FrontController" method="post" id="carport-shed-form">
            <h1>Byg skur</h1>
            <div>
                <select id="shed-length"><option selected="selected" value="">Vælg længde</option>
                </select>
            </div>
            <div>
                <select id="shed-width"><option selected="selected" value="">Vælg bredde</option>
                </select>
            </div>
        </form>
    </div>   

<script src="javascript/OrderValidationShed.js" type="text/javascript"></script>
<jsp:include page='/footer.jsp'></jsp:include>