package logic.drawings;

import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;

/**
 *
 * Draws the base of the carport, including the edge, poles (posts) and arrows
 * with accompanying labels.
 *
 * @author
 */
public class SVGDrawingBase
{

    int carportLength = 0;
    int carportWidth = 0;
    ArrayList postsSideOne = new ArrayList();
    ArrayList postsSideTwo = new ArrayList();
    ArrayList postsRear = new ArrayList();
    private static int arrowHeadCounter = 500;

    /**
     *
     * @param order order in question
     * @param bom Bill of Materials in question. Its fields are required for the drawing.
     */
    public SVGDrawingBase(OrderModel order, PartslistModel bom)
    {
        carportLength = order.getLength() / 10; //from mm to cm.
        carportWidth = order.getWidth() / 10; //from mm to cm.
        postsSideOne = bom.getPostPosSideOne();
        postsSideTwo = bom.getPostPosSideTwo();
        postsRear = bom.getPostPosRear();
    }

    /**
     * Get the base drawing for the carport
     *
     * @param order order in question
     * @return returns a String with SVG-elements related to building the carport base.
     */
    public String getBaseDrawing(OrderModel order)
    {
        String SVG
                = //The strap / edge of the base carport construction:
                "<rect "
                + "width=\"" + carportLength + "\" height=\"5\" y=\"2\" "
                + "stroke=\"#000000\" stroke-width=\"2\" fill=\"#FFFFFF\"/>\n"
                + "<rect "
                + "y=\"" + carportWidth + "\" width=\"" + carportLength + "\" height=\"5\" "
                + "stroke=\"#000000\" stroke-width=\"2\" fill=\"#FFFFFF\"/>\n"
                + "<rect "
                + "x=\"" + carportLength + "\" width=\"5\" height=\"" + carportWidth + "\" "
                + "stroke=\"#000000\" stroke-width=\"2\" fill=\"#FFFFFF\"/>"
                //The poles for the base carport construction:
                + getPoles();

        return SVG;
    }

    /**
     * Get the poles for the base drawing.
     * 
     * @return returns a String with SVG-elements related to building the carport base poles.
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
                    + "width=\"7\" height=\"7\" x=\"" + postsSideTwo.get(i) + "\" y=\"" + carportWidth + "\" "
                    + "stroke=\"#000000\" stroke-width=\"3\" fill=\"#FFFFFF\"/>";
        }
        for (int i = 0; i < postsRear.size(); i++)
        {
            SVG += "<rect "
                    + "width=\"7\" height=\"7\" x=\"" + carportLength + "\" y=\"" + postsRear.get(i) + "\" "
                    + "stroke=\"#000000\" stroke-width=\"3\" fill=\"#FFFFFF\"/>";
        }
        return SVG;
    }

    /**
     *
     * @param extraDistance
     * @return returns a String with SVG-elements related to building the arrows for the carport length
     */
    public String getLengthArrow(int extraDistance)
    {
        int extraWidth = 0;
        if (extraDistance > 0)
        {
            extraWidth = 25;
        }
        int beginX = 0;
        int beginY = carportWidth + 20 + extraWidth;
        int endX = carportLength;
        int endY = carportWidth + 20 + extraWidth;
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
     *
     * @param extraDistance
     * @return returns a String with SVG-elements related to building the arrows for the carport width.
     */
    public String getWidthArrow(int extraDistance)
    {
        int extraWidth = 0;
        if (extraDistance > 0)
        {
            extraWidth = 60;
        }
        int beginX = carportLength + 20;
        int beginY = 0;
        int endX = carportLength + 20;
        int endY = carportWidth + extraWidth;
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
     *
     * @param extraDistance
     * @return returns a String with SVG-elements related to building the label for the carport width
     */
    public String getWidthLabel(int extraDistance)
    {
        int extraWidth = 0;
        if (extraDistance > 0)
        {
            extraWidth = 60;
        }
        int x = carportLength + 25;
        int y = carportWidth / 2;
        int distance = carportWidth + extraWidth;
        String SVG = "";
        // The text
        SVG += " <text x=\"" + x + "\" y=\"" + y + "\" fill=\"black\"\">" + distance + "cm" + "</text> ";

        return SVG;
    }

    /**
     *
     * @param extraDistance
     * @return returns a String with SVG-elements related to building the label for the carport length
     */
    public String getLengthLabel(int extraDistance)
    {
        int extraWidth = 0;
        if (extraDistance > 0)
        {
            extraWidth = 25;
        }
        int x = carportLength / 2 - 20;
        int y = carportWidth + 40 + extraWidth;
        int distance = carportLength;
        String SVG = "";
        // The text
        SVG += " <text x=\"" + x + "\" y=\"" + y + "\" fill=\"black\"\">" + distance + "cm" + "</text> ";

        return SVG;
    }
}
