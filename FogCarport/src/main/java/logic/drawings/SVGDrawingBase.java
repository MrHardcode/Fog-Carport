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

    public SVGDrawingBase(OrderModel order, PartslistModel bom)
    {
        cLength = order.getLength() / 10;
        cWidth = order.getWidth() / 10;
        postsSideOne = bom.getPostPosSideOne();
        postsSideTwo = bom.getPostPosSideTwo();
        postsRear = bom.getPostPosRear();
    }
    
    public String getBaseDrawing()
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
                //Arrows and labels showing the dimensions of the carport
                + getArrow(0, cWidth + 20, cLength, cWidth + 20)
                + getArrow(cLength + 20, 0, cLength + 20, cWidth)
                + getLabel(cLength + 25, cWidth / 2, cWidth)
                + getLabel(cLength / 2 - 20, cWidth + 40, cLength)
                ;
        
        
        return SVG;
    }

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
    
    private String getArrow(int beginX, int beginY, int endX, int endY){
        // The Arrow.
        String SVG = " "
                + "<defs>\n"
                + "    <marker id=\"beginArrow\" \n"
                + "    	markerWidth=\"9\" markerHeight=\"9\" \n"
                + "    	refX=\"0\" refY=\"4\" \n"
                + "    	orient=\"auto\">\n"
                + "        <path d=\"M0,4 L8,0 L8,8 L0,4\" style=\"fill: #000000s;\" />\n"
                + "    </marker>\n"
                + "    <marker id=\"endArrow\" \n"
                + "    	markerWidth=\"9\" markerHeight=\"9\" \n"
                + "    	refX=\"8\" refY=\"4\" \n"
                + "    	orient=\"auto\">\n"
                + "        <path d=\"M0,0 L8,4 L0,8 L0,0\" style=\"fill: #000000;\" />\n"
                + "    </marker>\n"
                + "</defs>\n"
                + "<line x1=\""+beginX+"\"  y1=\""+beginY+"\" x2=\""+endX+"\"   y2=\""+endY+"\" \n"
                + "	style=\"stroke:#006600;\n"
                + "	marker-start: url(#beginArrow);\n"
                + "   marker-end: url(#endArrow);\"/>"
                + " ";
        
        return SVG;
    }
    
    private String getLabel(int x, int y, int distance)
    {
        String SVG = "";
        // The text
        SVG += " <text x=\"" + x + "\" y=\"" + y + "\" fill=\"black\"\">" + distance + "cm" + "</text> "; 
        
        return SVG;
    }
}
