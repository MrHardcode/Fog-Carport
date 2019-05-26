package logic.drawings;

import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.models.OrderModel;
import data.models.PartslistModel;
import logic.Calculations.RoofFlatCalc;

/**
 *
 * Generates the drawing for a flat roof.
 * 
 * @author
 */
public class SVGDrawingFlatRoof
{

    /**
     *
     * Generate the drawing of a flat roof for a specific order.
     *
     * @param order order in question
     * @return returns a string of SVG elements needed to display carport with
     * flat roof, including rafters, border (fascia+bargeboard) & hulbånd.
     * @throws AlgorithmException throws exception if encountered during
     * calculation.
     * @throws DataException throws exception if encountered during calculation.
     */
    public String getFlatRoofDrawing(OrderModel order) throws AlgorithmException, DataException
    {
        StringBuilder stb = new StringBuilder();
        RoofFlatCalc calc = new RoofFlatCalc();
        PartslistModel bom = calc.calculateFlatRoofStructure(order);

        int roofLength = order.getLength() / 10; //mm to cm conversion
        int roofWidth = (order.getWidth() + 100) / 10; //5cm extension per width + cm conversion
        int rafterCount = bom.getRafterCount();

        //roof border (stern, bargeboard here)
        String outerRoofBorder = " <rect width=\"" + roofLength + "\" height=\"" + roofWidth + "\" \n"
                + "style=\"stroke:black; stroke-width:1; fill-opacity:0; stroke-opacity:1\" />\n";

        stb.append(outerRoofBorder);

        // rafters
        int rafterDist = roofLength / (rafterCount - 1); //distance between each rafter
        int rafterPlacement = 0;
        for (int i = 0; i < rafterCount; i++)
        {
            String rafter = "<rect x=\"" + rafterPlacement + "\" width=\".5%\" height=\"" + roofWidth + "\" fill=\"gray\" ";
            if (i == 0 || i == rafterCount - 1) //if first or last rafter
            {
                rafter += "style=\"fill-opacity: .5;\" />\n";
            }
            else
            {
                rafter += "/>\n"; //closing tag and newline
            }
            stb.append(rafter);
            rafterPlacement += rafterDist; //update rafterPlacement for next rafter
        }

        //hulbånd
        int bandLength = roofLength - (order.getShed_length() / 10); //shed end point
        String band1 = "<line x1=\"" + rafterDist + "\" x2=\"" + bandLength + "\" y2=\"" + roofWidth + "\" style=\"stroke: black; stroke-dasharray:20,10\" />\n";
        String band2 = "<line x1=\"" + rafterDist + "\" y1=\"" + roofWidth + "\" x2=\"" + bandLength + "\" y2=\"0\" style=\"stroke: black; stroke-dasharray:20,10\" />";
        stb.append(band1);
        stb.append(band2);

        return stb.toString();
    }

}
