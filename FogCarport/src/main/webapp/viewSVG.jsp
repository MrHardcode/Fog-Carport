<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Headline -->
<div class="container w-100">
    <h1 class="my-4">Tegninger af Carport.
        <small>Tag og Underkonstruktion.</small>
    </h1>
</div>

<!-- The SVG drawings of the carport -->
<div>
    <p> 
        <!-- Using bootstrap collapse -->
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
        <button type="submit" class="btn btn-primary">Tilbage til din valgte ordre</button>
    </form>
</div>