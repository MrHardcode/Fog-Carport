package logic.drawings;

import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.models.OrderModel;
import data.models.PartslistModel;
import logic.Calculations.RoofFlatCalc;

/**
 *
 * @author
 */
public class SVGDrawingFlatRoof
{

    public String getRaisedRoofDrawing(OrderModel order) throws AlgorithmException, DataException
    {
        StringBuilder stb = new StringBuilder();
        RoofFlatCalc calc = new RoofFlatCalc();
        PartslistModel bom = calc.calculateFlatRoofStructure(order);

        int svgExtraPadding = 100;
        int halfPadding = (svgExtraPadding / 2);
        int roofLength = order.getLength() / 10; //mm to cm conversion
        int roofWidth = (order.getWidth() + 100) / 10; //5cm extension per width + cm conversion
        int rafterCount = bom.getRafterCount();

        //roof border
        String outerRoofBorder = " <rect width=\"" + roofLength + "\" height=\"" + roofWidth + "\" \n"
                + "style=\"stroke:black; stroke-width:1; fill-opacity:0; stroke-opacity:1\" />\n";

        stb.append(outerRoofBorder);

        // rafters
        int rafterDist = roofLength / (rafterCount - 1); //distance between each rafter
        int rafterPlacement = 0;
        for (int i = 0; i < rafterCount; i++)
        {
            String rafter = "<rect x=\"" + rafterPlacement + "\" width=\".5%\" height=\"" + roofWidth + "\" fill=\"gray\" />";
            stb.append(rafter);
            rafterPlacement += rafterDist; //update rafterPlacement for next rafter
        }

        //hulbånd
        int bandLength = roofLength - (order.getShed_length() / 10); //shed end point
        String band1 = "<line x1=\"" + rafterDist + "\" y1=\"0\" x2=\"" + bandLength + "\" y2=\"" + roofWidth + " style=\"stroke: black; stroke-dasharray:20,10\" />";
        String band2 = "<line x1=\"" + rafterDist + "\" y1=\"" + roofWidth + "\" x2=\"" + bandLength + "\" y2=\"0\" style=\"stroke: black; stroke-dasharray:20,10\" />";
        stb.append(band1);
        stb.append(band2);

        return stb.toString();
    }

}
