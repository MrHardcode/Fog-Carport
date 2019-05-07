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
//        RoofRaisedCalc calc = new RoofRaisedCalc();
//        PartslistModel roofRaisedBOM = calc.getRoofRaisedMaterials(order);
//
//        int rafterCount = roofRaisedBOM.getRafterCount();
//        int lathRowCount = roofRaisedBOM.getLathRowCount();
//        int tileCount = roofRaisedBOM.getTileCount();
//        int topTileCount = roofRaisedBOM.getTopTileCount();

        //HARDCODED UDKAST
        String hardcode = "<svg width=\"800\" height=\"400\">\n"
                + "\n"
                + "  <rect x=\"0\" y=\"0\" width=\"800\" height=\"400\"\n"
                + "  style=\"fill:grey; stroke:black; stroke-width:4; opacity:0.3\" />\n"
                + "  \n"
                + "  <line x1=\"0\" y1=\"199\" x2=\"800\" y2=\"199\" style=\"stroke: black; stroke-width:2\" stroke-dasharray=\"5,2\" />\n"
                + "  <line x1=\"0\" y1=\"1\" x2=\"800\" y2=\"1\" style=\"stroke: black; stroke-width:2\" stroke-dasharray=\"5,2\" />\n"
                + "  <line x1=\"0\" y1=\"399\" x2=\"800\" y2=\"399\" style=\"stroke: black; stroke-width:2\" stroke-dasharray=\"5,2\" />\n"
                + "  <line x1=\"0\" y1=\"99\" x2=\"800\" y2=\"99\" style=\"stroke: black; stroke-width:2\" stroke-dasharray=\"5,2\" />\n"
                + "  <line x1=\"0\" y1=\"299\" x2=\"800\" y2=\"299\" style=\"stroke: black; stroke-width:2\" stroke-dasharray=\"5,2\" />\n"
                + "  \n"
                + "  <line x1=\"3\" y1=\"0\" x2=\"3\" y2=\"400\" style=\"stroke: black; stroke-width:6\"/>\n"
                + "  <line x1=\"797\" y1=\"0\" x2=\"797\" y2=\"400\" style=\"stroke: black; stroke-width:6\"/>\n"
                + "  <line x1=\"197\" y1=\"0\" x2=\"197\" y2=\"400\" style=\"stroke: black; stroke-width:6\"/>\n"
                + "  <line x1=\"597\" y1=\"0\" x2=\"597\" y2=\"400\" style=\"stroke: black; stroke-width:6\"/>\n"
                + "  <line x1=\"397\" y1=\"0\" x2=\"397\" y2=\"400\" style=\"stroke: black; stroke-width:6\"/>\n"
                + "\n"
                + "</svg>";

        return hardcode;
    }

}
