<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="container w-100">

    <h1 class="my-4">Tegninger af Carport.
        <small>Tag og Underkonstruktion.</small>
    </h1>
</div>
<!-- /.container -->

<div>
    <p>
        <a class="btn btn-primary" data-toggle="collapse" href=".multiCollapse1" role="button" 
           aria-expanded="true" aria-controls="multiCollapse1">Show base</a>
        
        <button class="btn btn-primary" type="button" data-toggle="collapse" 
                data-target=".multiCollapse2,.collapseOne" aria-expanded="false" 
                aria-controls="multiCollapse2,.collapseOne">Show roof</button>
    </p>
    <div class="row card">
        <p>
            <svg width="900" height="900">
            <g id="accordion1" class="accordion card-text collapse multi-collapse multiCollapse1">
            ${svgbase}
            <svg x="100" y="100" id="collapseOne" class="collapseOne collapse show" data-parent="#accordion1">
            ${svgbaseArrowWidth}
            ${svgbaseArrowLength}
            ${svgbaseLabelWidth}
            ${svgbaseLabelLength}
            </svg>
            </g>
            <g class="card-text collapse multi-collapse multiCollapse2">
            <svg x="50" y="21.5" >${svgroof}</svg>
            <svg x="100" y="100">
            ${svgbaseArrowLengthExtra}
            ${svgbaseLabelWidth}
            ${svgbaseArrowWidth}
            ${svgbaseLabelLengthExtra}
            </svg>
            </g>
            </svg>
        </p>
    </div>
</div>

<br>
<div class="d-flex justify-content-center">
    <a class="btn btn-secondary" href="FrontController?command=link&link=viewOrder">Tilbage til din valgte ordre </a>
</div>