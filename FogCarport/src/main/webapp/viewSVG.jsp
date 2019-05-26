<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Headline -->
<div class="container w-100">
    <h1 class="my-4">Tegninger af Carport.</h1>
    <h4 class="my-4"> Tag og Underkonstruktion.</h4>
</div>

<!-- The SVG drawings of the carport -->
<div class="SVGdiv">
    <div class="toggleGroup SVGdiv">
        <center>
        <h5>Underkonstruktion</h5>
        </center>
        <div class="btn-group col-md-2">
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <label id="radio-base-show" class="btn btn-secondary active">
                    <input type="radio" name="options" id="option1" autocomplete="off" checked> VIS
                </label>
                <label id="radio-base-hide" class="btn btn-secondary">
                    <input type="radio" name="options" id="option2" autocomplete="off"> GEM
                </label>
            </div>
        </div>
    </div>

    <div class="toggleGroup SVGdiv">
        <center>
        <h5>Tagkonstruktion</h5>
        </center>
        <div class="btn-group col-md-5">
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <label id="radio-roof-show" class="btn btn-secondary">
                    <input type="radio" name="options" id="option3" autocomplete="off" checked> VIS
                </label>
                <label id="radio-roof-hide" class="btn btn-secondary active">
                    <input type="radio" name="options" id="option4" autocomplete="off"> GEM
                </label>
            </div>
        </div>
    </div>
    
        <!-- Using bootstrap collapse -->
        <a id="base-toggle-access" class="" role="button" data-toggle="collapse" href=".multiCollapse1"
           aria-expanded="true" aria-controls="multiCollapse1" hidden="hidden">Show base</a>

        <button id="roof-toggle-access" class="" type="button" data-toggle="collapse" 
                data-target=".multiCollapse2,.collapseOne" aria-expanded="false" 
                aria-controls="multiCollapse2,.collapseOne" hidden="hidden">Show roof</button>
        
    <div class="row card">
        <p>
            <svg width="900" height="900">
            <g id="accordion1" class="accordion card-text collapse show multi-collapse multiCollapse1">
            ${svgbase}
            <svg x="100" y="100" id="collapseOne" class="collapseOne collapse show" data-parent="#accordion1">
            ${svgbaseArrowWidth}
            ${svgbaseArrowLength}
            ${svgbaseLabelWidth}
            ${svgbaseLabelLength}
            </svg>
            </g>
            <g class="card-text collapse multi-collapse multiCollapse2">
            <c:choose>
                <c:when test="${incline > 0}">
                    <svg x="50" y="21.5" >
                    ${svgroof}
                    </svg>
                </c:when>
                <c:otherwise>
                    <svg x="100" y="98">
                    ${svgroof}
                    </svg>
                </c:otherwise>
            </c:choose>

            <svg x="100" y="100">
            ${svgbaseArrowLengthExtra}
            ${svgbaseLabelWidthExtra}
            ${svgbaseLabelLengthExtra}
            </svg>
            <c:choose>
                <c:when test="${incline > 0}">
                    <svg x="100" y="70">
                    ${svgbaseArrowWidthExtra}
                    </svg>
                </c:when>
                <c:otherwise>
                    <svg x="100" y="100">
                    ${svgbaseArrowWidthExtra}
                    </svg>
                </c:otherwise>
            </c:choose>
            </g>
            </svg>
        </p>
    </div>
</div>
<!-- END OF SVG DRAWING -->

<br>
<!-- Button to go back to viewOrder -->
<div class="d-flex justify-content-center">
    <form method="POST" action="FrontController"  class="">
        <input type="hidden" name="command" value="viewOrder">   
        <input type="hidden" name="orderid" value="${ID}"> 
        <button type="submit" class="btn btn-outline-secondary mb-1">Tilbage til din valgte ordre</button>
    </form>
</div>