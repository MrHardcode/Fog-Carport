package logic.drawings;

import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.models.OrderModel;
import data.models.PartslistModel;
import logic.Calculations.RoofRaisedCalc;

/**
 * Creates the string with the svg for the raised roof.
 * @author 
 */
public class SVGDrawingRaisedRoof {

    public String getRaisedRoofDrawing(OrderModel order) throws DataException, AlgorithmException {
        RoofRaisedCalc calc = new RoofRaisedCalc();
        PartslistModel roofRaisedBOM = calc.getRoofRaisedMaterials(order);

        int svgExtraPadding = 100;
        int halfPadding = (svgExtraPadding / 2);
        int roofWidth = (order.getWidth() / 10) + 60; // + overhang
        int roofLength = order.getLength() / 10;
        int rafterCount = roofRaisedBOM.getRafterCount();
        int lathRowCount = roofRaisedBOM.getLathRowCount();

        double angleRad = Math.toRadians(order.getIncline());
        int topLathDist = (int) (Math.cos(angleRad) * 30);
        int bottomLathDist = (int) (Math.cos(angleRad) * 35);

        StringBuilder stb = new StringBuilder();

        String outerRoofBorder = " <rect x=\"" + halfPadding + "\" y=\"" + halfPadding + "\" width=\"" + roofLength + "\" height=\"" + roofWidth + "\" "
                + "style=\"fill:none; stroke:black; stroke-width:1;\" />\n";

        stb.append(outerRoofBorder);

        //rafters
        int rafterDist = roofLength / (rafterCount - 1);
        int rafterPlacement = halfPadding;
        for (int i = 0; i < rafterCount; i++) {
            String rafter = " <rect x=\"" + rafterPlacement + "\" y=\"" + halfPadding + "\" width=\"6\" height=\"" + roofWidth + "\" "
                    + "style=\"fill:gainsboro; stroke:black; stroke-width:1;\" />\n";
            rafterPlacement = rafterPlacement + rafterDist;
            stb.append(rafter);
        }
        
        // place 3 middle laths
        int middlePlacement = halfPadding + (roofWidth / 2) - topLathDist;
        for (int i = 0; i < 3; i++) {
            String lath = " <rect x=\"" + halfPadding + "\" y=\"" + middlePlacement + "\" width=\"" + roofLength + "\" height=\"3\" "
                    + "style=\"fill:darkgrey; stroke:black; stroke-width:1;\" />\n";
            middlePlacement = middlePlacement + topLathDist;
            lathRowCount = lathRowCount - 1;
            stb.append(lath);
        }

        // place 4 outer laths
        int outerPlacement = halfPadding;
        for (int i = 0; i < 4; i++) {
            String lath = " <rect x=\"" + halfPadding + "\" y=\"" + outerPlacement + "\" width=\"" + roofLength + "\" height=\"3\" "
                    + "style=\"fill:darkgrey ; stroke:black; stroke-width:1;\" />\n";
            if (i == 1) {
                outerPlacement = halfPadding + roofWidth - (2 * bottomLathDist);
            }
            outerPlacement = outerPlacement + bottomLathDist;
            lathRowCount = lathRowCount - 1;
            stb.append(lath);
        }

        // rest of laths
        double remainderLathDistHalf = (roofWidth / 2) - topLathDist - bottomLathDist;
        double remianderDistEach = remainderLathDistHalf / ((lathRowCount / 2) + 1);

        double restLathPlacement = halfPadding + bottomLathDist;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < (lathRowCount / 2); j++) {
                restLathPlacement = restLathPlacement + remianderDistEach;
                String lath = " <rect x=\"" + halfPadding + "\" y=\"" + restLathPlacement + "\" width=\"" + roofLength + "\" height=\"3\" "
                        + "style=\"fill:white; stroke:black; stroke-width:1;\" />\n";

                stb.append(lath);
            }
            restLathPlacement = topLathDist + (roofWidth / 2) + halfPadding;
        }

        return stb.toString();
    }

}
