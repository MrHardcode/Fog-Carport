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
    private final int postdistance = 310; // in cm.
    
    /*
        Width / poledistance  = amount of posts (Dont remember modulo. Asger takes care of it.

        Then put the poles down starting at 0,0 (corner) and going to the edge.

        Do the same for the other side.

        And voila, finished.
    */
    
    // Update with a forloop for the amount of poles.
    public String getShedDrawing(OrderModel order){
        int cw = order.getWidth()/10;
        int cl = order.getLength()/10;
        int sw = order.getShed_width()/10;
        int sl = order.getShed_length()/10;
        
        
        String SVG = 
                // Container that matches the entire carport in size.
                "<svg "
                + "width=\""+(cw)+"\" "
                + "height=\""+(cl)+"\">\n" +
                
                // The shed itself.
"            <rect "
                + "x=\""+((cw)-(sw))+"\" \n" +
"                  y=\""+((cl)-(sl))+"\" \n" +
"                  width=\""+(sw)+"\" \n" +
"                  height=\""+(sl)+"\" \n" +
"                  style=\"stroke:black;stroke-dasharray:10,5;stroke-width:5;fill-opacity:0.1;stroke-opacity:1\" />\n" +
                
                // Posts from corner to the edge.
"            \n" + getPole(order, 0) + getPole(order, 90) +
                
                //Post at the corner
                "<rect x=\"" + (((cw) - (sw))) + "\" \n"
                    + "y=\"" + ((cl) - (sl)) + "\" \n"
                    + "width=\"15\" height=\"15\" \n"
                    + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n"+
"            Sorry, your browser does not support inline SVG.  \n" +
"        </svg>";
        
        return SVG;
    }
    
    // 90 in angle if its the width. 0 if the length.
    String getPole(OrderModel order, int angle)
    {
        int cw = order.getWidth() / 10;
        int cl = order.getLength() / 10;
        int sw = order.getShed_width() / 10;
        int sl = order.getShed_length() / 10;
        String SVG = "";

        if (angle == 0) // Horizontally
        { // Using example where shed is 640cm wide and postdistance is 310cm.
            int postamount = sw / postdistance; // 640/310 = 2 as int 
            for (double i = 0; i < postamount; i += 1)
            {                           
                double postplacement = ((1 + i) / (1 + postamount)); // (1+0)/(1+2) = 0.333333
                double tempint = (double) (sw * postplacement); // 0.333333 * 640 = 213
                int postwidth = (int) tempint;

                SVG += " <rect x=\"" + ((cw - sw) + postwidth) + "\" \n" // Places posts 213cm instead of 310cm. Now they are spread even and nice.
                        + "y=\"" + (cl - sl) + "\" \n"
                        + "width=\"15\" height=\"15\" \n"
                        + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n ";
            }
        }

        if (angle == 90) // Vertically 
        {
            int postamount = sl / postdistance; 
            for (double i = 0; i < postamount; i += 1)
            {                           
                double postplacement = ((1 + i) / (1 + postamount));
                double tempint = (double) (sl * postplacement); 
                int postlength = (int) tempint;

                SVG += " <rect x=\"" + (cw - sw)  + "\" \n"
                        + "y=\"" + ((cl - sl) + postlength) + "\" \n"
                        + "width=\"15\" height=\"15\" \n"
                        + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n ";
            }
        }
        return SVG;
    }
    
}
