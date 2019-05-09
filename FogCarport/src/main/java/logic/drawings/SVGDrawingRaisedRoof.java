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
        
        double angleRad = Math.toRadians(order.getIncline());
        int topLathDist = (int) (Math.cos(angleRad) * 30);
        int bottomLathDist = (int) (Math.cos(angleRad) * 35);
        
        StringBuilder stb = new StringBuilder();

        String startSVG = "<svg " + "width=\"" + (roofLength + svgExtraPadding) + "\" " + "height=\"" + (roofWidth + svgExtraPadding) + "\">\n";
        String outerRoofBorder = " <rect x=\"" + halfPadding + "\" y=\"" + halfPadding + "\" width=\"" + roofLength + "\" height=\"" + roofWidth + "\" "
                + "style=\"fill:none; stroke:red; stroke-width:1; fill-opacity:1.0; stroke-opacity:1.0\" />\n";
        String endSVG = "</svg>";

        stb.append(startSVG);
        stb.append(outerRoofBorder);

        // place 3 middle laths
        int middlePlacement = halfPadding + (roofWidth / 2) - topLathDist;
        for (int i = 0; i < 3; i++) {
            String lath = " <rect x=\"" + halfPadding + "\" y=\"" + middlePlacement + "\" width=\"" + roofLength + "\" height=\"3\" "
                    + "style=\"fill:none; stroke:magenta; stroke-width:1;\" />\n";
            middlePlacement = middlePlacement + topLathDist;
            lathRowCount = lathRowCount - 1;
            stb.append(lath);
        }

        // place 4 outer laths
        int outerPlacement = halfPadding;
        for (int i = 0; i < 4; i++) {
            String lath = " <rect x=\"" + halfPadding + "\" y=\"" + outerPlacement + "\" width=\"" + roofLength + "\" height=\"3\" "
                    + "style=\"fill:none; stroke:green; stroke-width:1;\" />\n";
            if (i == 1) {
                outerPlacement = halfPadding + roofWidth - (2 * bottomLathDist);
            }
            outerPlacement = outerPlacement + bottomLathDist;
            lathRowCount = lathRowCount - 1;
            stb.append(lath);
        }
        
        
        
        
        
        // rest of laths
        int remainderLathDistTotal = roofWidth - (2* topLathDist) - (2 * bottomLathDist);
        int remainderDistEach = remainderLathDistTotal / (lathRowCount + 2);

        int shiftRoofSide = lathRowCount / 2;

        int restPlacement = halfPadding + bottomLathDist + remainderDistEach;
        for (int i = 0; i < lathRowCount; i++) {
            String lath = " <rect x=\"" + halfPadding + "\" y=\"" + restPlacement + "\" width=\"" + roofLength + "\" height=\"3\" "
                    + "style=\"fill:none; stroke:black; stroke-width:1;\" />\n";
            if (i == shiftRoofSide - 1) {
                restPlacement = halfPadding + (roofWidth / 2) + topLathDist;
            }
            restPlacement = restPlacement + remainderDistEach;
            stb.append(lath);
        }
        
        
        
        
        
        
        // rafters
        int rafterDist = roofLength/(rafterCount-1);
        int rafterPlacement = halfPadding;
        for (int i = 0; i < rafterCount; i++) {
            String rafter = " <rect x=\"" + rafterPlacement + "\" y=\"" + halfPadding + "\" width=\"6\" height=\"" + roofWidth + "\" "
                    + "style=\"fill:none; stroke:blue; stroke-width:1;\" />\n";
            rafterPlacement = rafterPlacement + rafterDist;
            stb.append(rafter);
        }
        
        stb.append(endSVG);

        return stb.toString();
    }

}
