package logic.drawings;

import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class SVGDrawingBase
{

    int cLength = 0;
    int cWidth = 0;
    ArrayList postsSideOne = new ArrayList();
    ArrayList postsSideTwo = new ArrayList();
    ArrayList postsRear = new ArrayList();
    private static int arrowHeadCounter = 500;

    public SVGDrawingBase(OrderModel order, PartslistModel bom)
    {
        cLength = order.getLength() / 10;
        cWidth = order.getWidth() / 10;
        postsSideOne = bom.getPostPosSideOne();
        postsSideTwo = bom.getPostPosSideTwo();
        postsRear = bom.getPostPosRear();
    }
    
    /**
     * Used to get a String containing the SVG elements representing the 
     * straps for the base construction.
     * @param order OrderModel 
     * @return String - the SVG elements for the base constructions itself
     */
    public String getBaseDrawing(OrderModel order)
    {
        String SVG =
                //The strap / edge of the base carport construction:
            "<rect "
                + "width=\"" + cLength + "\" height=\"5\" y=\"2\" "
                + "stroke=\"#000000\" stroke-width=\"2\" fill=\"#FFFFFF\"/>\n" +
                
            "<rect "
                + "y=\"" + cWidth + "\" width=\"" + cLength + "\" height=\"5\" "
                + "stroke=\"#000000\" stroke-width=\"2\" fill=\"#FFFFFF\"/>\n" +
                
            "<rect "
                + "x=\"" + cLength + "\" width=\"5\" height=\"" + cWidth + "\" "
                + "stroke=\"#000000\" stroke-width=\"2\" fill=\"#FFFFFF\"/>"
                //The poles for the base carport cinstruction:
                + getPoles()
                ;
        
        
        return SVG;
    }

    /**
     * Used to get the SVG elements representing the poles in the base construction.
     * This method uses the ArrayLists from the Partslist created by baseCalc.java
     * @return String
     */
    private String getPoles()
    {
        String SVG = "";
        for (int i = 0; i < postsSideOne.size(); i++)
        {
            SVG += "<rect "
                + "width=\"7\" height=\"7\" x=\"" + postsSideOne.get(i) + "\" y=\"2\" "
                + "stroke=\"#000000\" stroke-width=\"3\" fill=\"#FFFFFF\"/>";
        }
        for (int i = 0; i < postsSideTwo.size(); i++)
        {
            SVG += "<rect "
                + "width=\"7\" height=\"7\" x=\"" + postsSideTwo.get(i) + "\" y=\"" + cWidth + "\" "
                + "stroke=\"#000000\" stroke-width=\"3\" fill=\"#FFFFFF\"/>";
        }
        for (int i = 0; i < postsRear.size(); i++)
        {
            SVG += "<rect "
                + "width=\"7\" height=\"7\" x=\"" + cLength + "\" y=\"" + postsRear.get(i) + "\" "
                + "stroke=\"#000000\" stroke-width=\"3\" fill=\"#FFFFFF\"/>";
        }
        return SVG;
    }
    
    /**
     * Used to get an arrow showing the length of the carport.
     * This methods needs an integer representing the incline of the roof. If the 
     * roof has an incline above 0 then the SVG elements for the roof 
     * will cover the arrow if the arrow isn't moved a bit away from the base SVG element
     * @param extraDistance int
     * @return String
     */
    public String getLengthArrow(int extraDistance){
        int extraWidth = 0;
        if (extraDistance > 0)
        {
            /*The extra width represents the "overhang" of the roof.
            * The extra width is applied to the arrow so the arrow won't get 
            * covered by the "roof overhang"
            */
            extraWidth = 25;
        }
        int beginX = 0;
        int beginY = cWidth + 20 + extraWidth;
        int endX = cLength;
        int endY = cWidth + 20 + extraWidth;
        ++arrowHeadCounter;
        // The Arrow.
        String SVG = " "
                + "<defs>\n"
                + "    <marker id=\"beginArrow" + arrowHeadCounter + "\" \n"
                + "    	markerWidth=\"9\" markerHeight=\"9\" \n"
                + "    	refX=\"0\" refY=\"4\" \n"
                + "    	orient=\"auto\">\n"
                + "        <path d=\"M0,4 L8,0 L8,8 L0,4\" style=\"fill: #000000s;\" />\n"
                + "    </marker>\n"
                + "    <marker id=\"endArrow" + arrowHeadCounter + "\" \n"
                + "    	markerWidth=\"9\" markerHeight=\"9\" \n"
                + "    	refX=\"8\" refY=\"4\" \n"
                + "    	orient=\"auto\">\n"
                + "        <path d=\"M0,0 L8,4 L0,8 L0,0\" style=\"fill: #000000;\" />\n"
                + "    </marker>\n"
                + "</defs>\n"
                + "<line x1=\"" + beginX + "\"  y1=\"" + beginY + "\" x2=\"" + endX + "\"   y2=\"" + endY + "\" \n"
                + "	style=\"stroke:#006600;\n"
                + "	marker-start: url(#beginArrow" + arrowHeadCounter + ");\n"
                + "   marker-end: url(#endArrow" + arrowHeadCounter + ");\"/>"
                + " ";
        
        return SVG;
    }
    
    /**
     * Used to get an arrow showing the width of the carport.
     * This method needs an integer representing the roof incline. If the roof 
     * incline is above 0 degress then some extra length is applied to the arrow 
     * so it shows the width of the roof instead of the width of the carport. 
     * (Raised roof is always wider than the carport's base construction)
     * @param extraDistance int
     * @return String
     */
    public String getWidthArrow(int extraDistance){
        int extraWidth = 0;
        if (extraDistance > 0)
        {
            extraWidth = 60;
        }
        int beginX = cLength + 20;
        int beginY = 0;
        int endX = cLength + 20;
        int endY = cWidth + extraWidth;
        ++arrowHeadCounter;
        String SVG = " "
                + "<defs>\n"
                + "    <marker id=\"beginArrow" + arrowHeadCounter + "\" \n"
                + "    	markerWidth=\"9\" markerHeight=\"9\" \n"
                + "    	refX=\"0\" refY=\"4\" \n"
                + "    	orient=\"auto\">\n"
                + "        <path d=\"M0,4 L8,0 L8,8 L0,4\" style=\"fill: #000000s;\" />\n"
                + "    </marker>\n"
                + "    <marker id=\"endArrow" + arrowHeadCounter + "\" \n"
                + "    	markerWidth=\"9\" markerHeight=\"9\" \n"
                + "    	refX=\"8\" refY=\"4\" \n"
                + "    	orient=\"auto\">\n"
                + "        <path d=\"M0,0 L8,4 L0,8 L0,0\" style=\"fill: #000000;\" />\n"
                + "    </marker>\n"
                + "</defs>\n"
                + "<line x1=\"" + beginX + "\"  y1=\"" + beginY + "\" x2=\"" + endX + "\"   y2=\"" + endY + "\" \n"
                + "	style=\"stroke:#006600;\n"
                + "	marker-start: url(#beginArrow" + arrowHeadCounter + ");\n"
                + "   marker-end: url(#endArrow" + arrowHeadCounter + ");\"/>"
                + " ";
        
        return SVG;
    }
    
    /**
     * Used in combination with getWidthArrow().
     * This method returns an SVG element that displays a label for the width-arrow.
     * This method needs an integer representing the incline of the roof of the carport. 
     * If the incline is above 0 then the label adds "60" to its own value.
     * Raised roof is always 60cm wider than the base construction of the carport
     * @param extraDistance int
     * @return String
     */
    public String getWidthLabel(int extraDistance)
    {
        int extraWidth = 0;
        if (extraDistance > 0)
        {
            extraWidth = 60;
        }
        int x = cLength + 25;
        int y= cWidth / 2;
        int distance = cWidth + extraWidth;
        String SVG = "";
        // The text
        SVG += " <text x=\"" + x + "\" y=\"" + y + "\" fill=\"black\"\">" + distance + "cm" + "</text> "; 
        
        return SVG;
    }
    
    /**
     * Used in combination with getLengthArrow().
     * This method returns an SVG element that displays a label for the length-arrow.
     * This method needs an integer representing the incline of the roof of the carport.
     * If the incline is above 0 then the label needs to be moved down slightly 
     * so it doesn't get covered by the SVG elements for the roof.
     * @param extraDistance int
     * @return String
     */
    public String getLengthLabel(int extraDistance)
    {
        int extraWidth = 0;
        if (extraDistance > 0)
        {
            extraWidth = 25;
        }
        int x = cLength / 2 - 20;
        int y= cWidth + 40 + extraWidth;
        int distance = cLength;
        String SVG = "";
        // The text
        SVG += " <text x=\"" + x + "\" y=\"" + y + "\" fill=\"black\"\">" + distance + "cm" + "</text> "; 
        
        return SVG;
    }
}
