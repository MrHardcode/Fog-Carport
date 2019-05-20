
<%@page import="data.models.OrderModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            OrderModel o = new OrderModel();
            o.setHeight(2100);
            o.setIncline(0);
            o.setLength(7800);
            o.setWidth(6000);
            o.setRoof_tiles_id(28);
            o.setShed_length(2000);

            int roofLength = o.getLength() / 10; //mm to cm conversion
            int roofWidth = (o.getWidth() + 100) / 10; //5cm extension per width + cm conversion
            int rafterCount = 15; //need to set on partslistmodel
            int bandLength = roofLength-(o.getShed_length()/10); //shed end

            int svgExtraPadding = 100;
            int halfPadding = 50;
        %>
    </head>

    <body>
        <!-- svg to fit elements inside -->
        <svg width="<%=(roofLength + svgExtraPadding)%>" height="<%=(roofWidth + svgExtraPadding)%>" >
            <!--<rect x="<%=halfPadding%>" y="<%=halfPadding%>" width="<%=roofLength%>" height="<%= roofWidth%>"
            style="fill:none; stroke:red; stroke-width:1; fill-opacity:1.0; stroke-opacity:1.0"/> -->

        <!-- Outline of roof ends (fascias, bargeboards here) --> 
        <rect width="<%=roofLength%>" height="<%= roofWidth%>" 
              style="stroke:black; stroke-width:1; fill-opacity:0; stroke-opacity:1" />

        <%
            int rafterDist = roofLength / (rafterCount - 1);
            int rafterPlacement = 0; 
            for (int i = 0; i < rafterCount; i++)
            {
        %>
        <rect x="<%=rafterPlacement%>" width=".5%" height="<%=roofWidth%>" fill="gray" />
        <%
                rafterPlacement += rafterDist;
                }
        %>
        <line x1="<%=rafterDist %>" y1="0" x2="<%=bandLength %>" y2="<%=roofWidth %>" style="stroke: black; stroke-dasharray:20,10" />
        <line x1="<%=rafterDist %>" y1="<%=roofWidth %>" x2="<%=bandLength %>" y2="<%=0 %>" style="stroke: black; stroke-dasharray:20,10" />
        </svg>
    </body>
</html>
