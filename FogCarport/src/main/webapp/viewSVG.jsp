<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="container w-100">

    <h1 class="my-4">Tegninger af Carport.
        <small>Tag og Underkonstruktion.</small>
    </h1>

    <div class="card h-100">
        <div class="card-body">
            <h4 class="card-title">
                <p>Underkonstruktion</p>
            </h4>
            <p class="card-text">${svgbase}</p>
        </div>
    </div>
    <br>
    <div class="card h-100">
        <div class="card-body">
            <h4 class="card-title">
                <p>Taget</p>
            </h4>
            <p class="card-text">${svgroof}</p>
        </div>
    </div>

</div>
<!-- /.container -->


<br>
<div class="d-flex justify-content-center">
    <a class="btn btn-secondary" href="FrontController?command=link&link=viewOrder">Tilbage til din valgte ordre </a>
</div>