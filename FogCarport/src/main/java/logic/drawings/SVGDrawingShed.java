/*
 *  Malte Hviid-Magnussen
 */
package logic.drawings;

import data.models.OrderModel;

/**
 *
 * @author Malte
 */
public class SVGDrawingShed
{
    private final int postdistance = 3100/10;
    
    /*
        Width / poledistance  = amount of posts (Dont remember modulo. Asger takes care of it.

        Then put the poles down starting at 0,0 (corner) and going to the edge.

        Do the same for the other side.

        And voila, finished.
    */
    
    // Update with a forloop for the amount of poles.
    public String getShedDrawing(OrderModel order){
        String SVG = "<svg "
                + "width=\""+(order.getLength()/10)+"\" "
                + "height=\""+(order.getWidth()/10)+"\">\n" +
"            <rect "
                + "x=\""+((order.getLength()/10)-(order.getShed_length()/10))+"\" \n" +
"                  y=\""+((order.getWidth()/10)-(order.getShed_width()/10))+"\" \n" +
"                  width=\""+(order.getShed_width()/10)+"\" \n" +
"                  height=\""+(order.getShed_length()/10)+"\" \n" +
"                  style=\"stroke:black;stroke-width:5;fill-opacity:0.1;stroke-opacity:1\" />\n" +
"            \n" + getPole(order, 0) +
                "<rect x=\"" + ((order.getLength() / 10) - (order.getShed_length() / 10)) + "\" \n"
                    + "y=\"" + (((order.getWidth() / 10) - (order.getShed_width() / 10))+postdistance) + "\" \n"
                    + "width=\"15\" height=\"15\" \n"
                    + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n"+
"            Sorry, your browser does not support inline SVG.  \n" +
"        </svg>";
        
        return SVG;
    }
    
    // 90 in angle if its the width. 0 if the length.
    String getPole(OrderModel order, int angle)
    {
        String SVG = "";
        if (angle == 0)
        {
            SVG = "<rect x=\"" + (((order.getLength() / 10) - (order.getShed_length() / 10))+postdistance) + "\" \n"
                    + "y=\"" + ((order.getWidth() / 10) - (order.getShed_width() / 10)) + "\" \n"
                    + "width=\"15\" height=\"15\" \n"
                    + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n";
        } else if (angle == 90)
        {
            SVG = "<rect x=\"" + ((order.getLength() / 10) - (order.getShed_length() / 10)) + "\" \n"
                    + "y=\"" + (((order.getWidth() / 10) - (order.getShed_width() / 10))+postdistance) + "\" \n"
                    + "width=\"15\" height=\"15\" \n"
                    + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n";
        }
        return SVG;
    }
    
}
