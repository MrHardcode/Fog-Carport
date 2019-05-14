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
                Underkonstruktion
            </h4>
            <p class="card-text"><svg width="900" height="900">${svgbase}<svg x="50" y="21.5">${svgroof}</svg></svg></p>
        </div>
    </div>
    <br>
    <div class="card h-100">
        <div class="card-body">
            <h4 class="card-title">
                Taget
            </h4>
            <p class="card-text"><svg width="900" height="900">${svgroof}</svg></p>
        </div>
    </div>

</div>
<!-- /.container -->

<p>
    <a class="btn btn-primary" data-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Show base</a>
    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">Show roof</button>
    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2">Show all</button>
</p>
<div class="row">
  <div class="col">
    <div class="collapse multi-collapse" id="multiCollapseExample1">
      <div class="card card-body">
        <p class="card-text"><svg width="900" height="900">${svgbase}</svg></p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="collapse multi-collapse" id="multiCollapseExample2">
      <div class="card card-body">
        <p class="card-text"><svg width="900" height="900">${svgroof}</svg></p>
      </div>
    </div>
  </div>
</div>

<br>
<div class="d-flex justify-content-center">
    <a class="btn btn-secondary " href="FrontController?command=link&link=viewOrder">Tilbage til din valgte ordre </a>
</div>