/*
 *  
 */
package presentation;

import data.exceptions.AlgorithmException;
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
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException, AlgorithmException
    {
        int orderID = Integer.parseInt(request.getParameter("orderid"));
        OrderModel order = logic.getOrder(orderID);
        PartslistModel bom = logic.getPartslistModel(order);
        
        if (order == null || bom == null){
            throw new LoginException("You can't view drawing if you haven't generated the partslist first. See Issue #86");
        }
        
        String svgbase = logic.getSVGbase(bom, order);
        request.setAttribute("svgbase", svgbase);
        
        String svgroof = logic.getSVGroof(order);
        request.setAttribute("svgroof", svgroof);
        
        return "viewSVG";
    }

}
