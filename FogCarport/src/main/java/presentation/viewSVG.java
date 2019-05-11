/*
 *  
 */
package presentation;

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

    public viewSVG()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        HttpSession session = request.getSession();
        OrderModel order = (OrderModel) session.getAttribute("order");
        PartslistModel bom = (PartslistModel) session.getAttribute("bom");
        if (order == null || bom == null){
            throw new LoginException("You can't view drawing if you haven't generated the partslist first. See Issue #86");
        }
        String svgbase = logic.getSVGbase(bom, order);
        session.setAttribute("svgbase", svgbase);
        
        String svgroof = logic.getSVGroof(order);
        session.setAttribute("svgroof", svgroof);
        
        
        
        return "viewSVG";
    }

}
