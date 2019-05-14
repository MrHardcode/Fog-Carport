/*
 *  
 */
package logic.drawings;

import data.models.OrderModel;

/**
 *
 * @author
 */
public class SVGDrawingShed
{

    private final int postdistance = 310; // in cm.

    public SVGDrawingShed()
    {
    }

    /**
     * Get a SVG drawing of the shed.
     *
     * @param order
     * @return SVG drawing in string for html.
     */
    public String getShedDrawing(OrderModel order)
    {
        int carportWidth = order.getLength() / 10;
        int carportLength = order.getWidth() / 10;
        int shedWidth = order.getShed_length() / 10;
        int shedLength = order.getShed_width() / 10;

        String SVG
                = // Container that matches the entire carport in size.
                "<svg "
                + "width=\"" + (carportWidth) + "\" "
                + "height=\"" + (carportLength) + "\">\n"
                + // The shed itself.
                " <rect "
                + "x=\"" + ((carportWidth) - (shedWidth)) + "\" \n"
                + " y=\"" + ((carportLength) - (shedLength)) + "\" \n"
                + " width=\"" + (shedWidth) + "\" \n"
                + " height=\"" + (shedLength) + "\" \n"
                + " style=\"stroke:black;stroke-dasharray:10,5;stroke-width:5;fill-opacity:0.1;stroke-opacity:1\" />\n";

        // Posts from corner to the edge.
        if (shedWidth != carportWidth)
        {
            // Horizontal
            SVG += getPole(order, 0);
        }
        if (shedLength != carportLength)
        {
            // Vertical
            SVG += getPole(order, 90);
        }

        if (shedLength != carportLength && shedWidth != carportWidth)
        {
            //Post at the corner
            SVG += "<rect x=\"" + (((carportWidth) - (shedWidth))) + "\" \n"
                    + "y=\"" + ((carportLength) - (shedLength)) + "\" \n"
                    + "width=\"15\" height=\"15\" \n"
                    + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n";
        }
        // Closing tag
        SVG += "        </svg>";

        return SVG;
    }

    /**
     * Get a SVG pole drawn in the right spot, with labels and arrows.
     *
     * @param order
     * @param angle 90 in angle if its the width. 0 if the length.
     * @return SVG drawing string for html.
     */
    String getPole(OrderModel order, int angle)
    {
        int carportWidth = order.getLength() / 10;
        int carportLength = order.getWidth() / 10;
        int shedWidth = order.getShed_length() / 10;
        int shedLength = order.getShed_width() / 10;
        String SVG = "";

        if (angle == 0) // Horizontally
        { // Using example where shed is 640cm wide and postdistance is 310cm.
            int postamount = shedWidth / postdistance; // 640/310 = 2 as int 
            for (double i = 0; i <= postamount; i += 1)
            {
                double postplacement = ((1 + i) / (1 + postamount)); // (1+0)/(1+2) = 0.333333
                double tempint = (double) (shedWidth * postplacement); // 0.333333 * 640 = 213
                int postwidth = (int) tempint;

                // The Arrow.
                if (i == 0)
                {                   // beginX     beginY         endX                     endY 
                    SVG += getArrow(((carportWidth - shedWidth)), (carportLength - shedLength) - 15, ((carportWidth - shedWidth) + postwidth), (carportLength - shedLength) - 15);
                    SVG += getLabel((carportWidth - shedWidth) + (postwidth / 2) - 10, (carportLength - shedLength) - 20, postwidth);
                }

                // The post
                SVG += " <rect x=\"" + ((carportWidth - shedWidth) + postwidth) + "\" \n" // Places posts 213cm instead of 310cm. Now they are spread even and nice.
                        + "y=\"" + (carportLength - shedLength) + "\" \n"
                        + "width=\"15\" height=\"15\" \n"
                        + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n ";
            }
        }

        if (angle == 90) // Vertically 
        {
            int postamount = shedLength / postdistance;
            for (double i = 0; i <= postamount; i += 1)
            {
                double postplacement = ((1 + i) / (1 + postamount));
                double tempint = (double) (shedLength * postplacement);
                int postlength = (int) tempint;

                // The Arrow.
                if (i == 0)
                {                   // beginX       beginY                  endX            endY                                
                    SVG += getArrow((carportWidth - shedWidth) - 15, ((carportLength - shedLength)), (carportWidth - shedWidth) - 15, ((carportLength - shedLength) + postlength));
                    SVG += getLabel((carportWidth - shedWidth) - 60, (carportLength - shedLength) + (postlength / 2), postlength);
                }

                SVG += " <rect x=\"" + (carportWidth - shedWidth) + "\" \n"
                        + "y=\"" + ((carportLength - shedLength) + postlength) + "\" \n"
                        + "width=\"15\" height=\"15\" \n"
                        + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n ";
            }
        }
        return SVG;
    }

    /**
     * Get a SVG arrow, that shows the distance between two poles on the shed.
     *
     * @param beginX Start X coordinate.
     * @param beginY Start Y coordinate.
     * @param endX End X coordinate.
     * @param endY End Y coordinate.
     * @return SVG drawing string for html.
     */
    String getArrow(int beginX, int beginY, int endX, int endY)
    {
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
                + "<line x1=\"" + beginX + "\"  y1=\"" + beginY + "\" x2=\"" + endX + "\"   y2=\"" + endY + "\" \n"
                + "	style=\"stroke:#006600;\n"
                + "	marker-start: url(#beginArrow);\n"
                + "   marker-end: url(#endArrow);\"/>"
                + " ";

        return SVG;
    }

    /**
     * Get a distance label for the arrow that marks the distance between two
     * posts.
     *
     * @param x X position.
     * @param y Y position.
     * @param distance Distance between the two posts.
     * @return SVG string.
     */
    String getLabel(int x, int y, int distance)
    {
        String SVG = "";
        // The text
        SVG += " <text x=\"" + x + "\" y=\"" + y + "\" fill=\"black\"\">" + distance + "cm" + "</text> ";

        return SVG;
    }

}
