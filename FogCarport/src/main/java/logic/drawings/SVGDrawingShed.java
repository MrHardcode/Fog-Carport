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

        if (angle == 0)
        {
            int postamount = sw / postdistance; // 6400/3100 = 2 som int 
            for (int i = 0; i < postamount; i++)
            {                           
                double postplacement = ((1 + i) / (1 + postamount)); // (1+0)/(1+2) = 0.333333
                double tempint = (sw * postplacement); // 0.333333 * 6400 = 2133
                int postwidth = (int) tempint;

                SVG += " <rect x=\"" + ((cw - sw) + postwidth) + "\" \n"
                        + "y=\"" + (cl - sl) + "\" \n"
                        + "width=\"15\" height=\"15\" \n"
                        + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n ";
            }
        }

        int postlength = postdistance; // 3100
        while (angle == 90 && (cl + sl > postlength))
        {
            SVG += " <rect x=\"" + (cw - sw) + "\" \n"
                    + "y=\"" + ((cl - sl) + postlength) + "\" \n"
                    + "width=\"15\" height=\"15\" \n"
                    + "style=\"stroke:black;stroke-width:5;fill-opacity:0;stroke-opacity:1\" />\n ";
            postlength += postdistance;
        }
        return SVG;
    }
    
}
