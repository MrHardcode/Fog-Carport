/*
 *  
 */
package presentation;

import data.exceptions.DataException;
import data.exceptions.LoginException;
import data.models.OrderModel;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;

/**
 *
 * @author
 */
public class viewSVG extends Command
{

    public viewSVG(){
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException, DataException
    {
        HttpSession session = request.getSession();
        // Get the order from request.
        OrderModel order = (OrderModel) session.getAttribute("order");
        // Get the partslist from request.
        PartslistModel bom = (PartslistModel) session.getAttribute("bom");
        // Check for null.
        if (order == null || bom == null){
            throw new LoginException("You can't view drawing if you haven't generated the partslist first. See Issue #86");
        }
        // Get the SVG String and place it on request.
        String svgbase = logic.getSVGbase(bom, order);
        request.setAttribute("svgbase", svgbase);
        
        String svgroof = logic.getSVGroof(order);
        request.setAttribute("svgroof", svgroof);
        
        return "viewSVG";
    }

}
