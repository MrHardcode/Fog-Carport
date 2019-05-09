/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.drawings;

import data.exceptions.LoginException;
import data.models.OrderModel;
import data.models.PartslistModel;
import logic.Calculations.RoofRaisedCalc;

/**
 *
 * @author Camilla
 */
public class SVGDrawingRaisedRoof {

    public String getRaisedRoofDrawing(OrderModel order) throws LoginException {
        RoofRaisedCalc calc = new RoofRaisedCalc();
        PartslistModel roofRaisedBOM = calc.getRoofRaisedMaterials(order);

        int svgExtraPadding = 100;
        int halfPadding = (svgExtraPadding / 2);
        int roofWidth = (order.getWidth() / 10) + 60; // + udhæng af tag
        int roofLength = order.getLength() / 10;
        int rafterCount = roofRaisedBOM.getRafterCount();
        int lathRowCount = roofRaisedBOM.getLathRowCount();
        int tileCount = roofRaisedBOM.getTileCount();
        int topTileCount = roofRaisedBOM.getTopTileCount();

        StringBuilder stb = new StringBuilder();

        String startSVG = "<svg " + "width=\"" + (roofLength + svgExtraPadding) + "\" " + "height=\"" + (roofWidth + svgExtraPadding) + "\">\n";
        String outerRoofBorder = " <rect x=\"" + halfPadding + "\" y=\"" + halfPadding + "\" width=\"" + roofLength + "\" height=\"" + roofWidth + "\" "
                + "style=\"fill:none; stroke:black; stroke-width:1; fill-opacity:1.0; stroke-opacity:1.0\" />\n";
        String endSVG = "</svg>";

        
        stb.append(startSVG);
        stb.append(outerRoofBorder);
        
        // place 3 middle laths
        int placement = halfPadding + (roofWidth / 2) - 30;
        for (int i = 0; i < 3; i++) {
            String lath = " <rect x=\"" + halfPadding + "\" y=\"" + placement + "\" width=\"" + roofLength + "\" height=\"3\" "
                    + "style=\"fill:none; stroke:black; stroke-width:1;\" />\n";
            placement = placement + 30;
            lathRowCount = lathRowCount - 1;
            stb.append(lath);
        }

        stb.append(endSVG);

        //HARDCODED UDKAST
        String hardcode = "<svg "
                + "width=\"" + (roofLength + svgExtraPadding) + "\" "
                + "height=\"" + (roofWidth + svgExtraPadding) + "\">\n"
                // outer roof border
                + "  <rect x=\"" + halfPadding + "\" y=\"" + halfPadding + "\" width=\"" + roofLength + "\" height=\"" + roofWidth + "\" "
                + "style=\"fill:none; stroke:black; stroke-width:4; fill-opacity:1.0; stroke-opacity:1.0\" />\n"
                // laths, starting in the middle

                + "  <rect x=\"" + halfPadding + "\" y=\"" + (halfPadding + (roofWidth / 2)) + "\" width=\"" + roofLength + "\" height=\"3\" style=\"fill:none; stroke:black; stroke-width:1;\" />\n"
                + "  <rect x=\"" + halfPadding + "\" y=\"" + (halfPadding + ((roofWidth / 2) + 30)) + "\" width=\"" + roofLength + "\" height=\"3\" style=\"fill:none; stroke:black; stroke-width:1;\" />\n"
                + "  <rect x=\"" + halfPadding + "\" y=\"" + (halfPadding + ((roofWidth / 2) - 30)) + "\" width=\"" + roofLength + "\" height=\"3\" style=\"fill:none; stroke:black; stroke-width:1;\" />"
                // rafter
                //+ "  <rect x=\"50\" y=\"25\" width=\"6\" height=\"300\" style=\"fill:none; stroke:black; stroke-width:1;\" />\n"
                + "</svg>";

        return stb.toString();
    }

}
