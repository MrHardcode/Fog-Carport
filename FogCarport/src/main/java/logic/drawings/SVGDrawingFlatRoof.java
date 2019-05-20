package logic.drawings;

import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import data.models.OrderModel;
import data.models.PartslistModel;
import logic.Calculations.RoofFlatCalc;

/**
 *
 * @author 
 */
public class SVGDrawingFlatRoof {

    public String getRaisedRoofDrawing(OrderModel order) throws LoginException, AlgorithmException {
        RoofFlatCalc calc = new RoofFlatCalc();
        PartslistModel bom = calc.calculateFlatRoofStructure(order);

        int svgExtraPadding = 100;
        int halfPadding = (svgExtraPadding / 2);

        StringBuilder stb = new StringBuilder();

        //roof border
        String outerRoofBorder = " <rect x=\"" + halfPadding + "\" y=\"" + halfPadding + "\" width=\"" + roofLength + "\" height=\"" + roofWidth + "\" "
                + "style=\"fill:none; stroke:red; stroke-width:1; fill-opacity:1.0; stroke-opacity:1.0\" />\n";

        stb.append(outerRoofBorder);

        // rafters
        int rafterDist = roofLength / (rafterCount - 1);
        int rafterPlacement = halfPadding;
        for (int i = 0; i < rafterCount; i++) {
            String rafter = " <rect x=\"" + rafterPlacement + "\" y=\"" + halfPadding + "\" width=\"6\" height=\"" + roofWidth + "\" "
                    + "style=\"fill:none; stroke:blue; stroke-width:1;\" />\n";
            rafterPlacement = rafterPlacement + rafterDist;
            stb.append(rafter);
        }
        
        
        //hulbånd
        String band = "";
        
        stb.append(band);

        return stb.toString();
    }

}
