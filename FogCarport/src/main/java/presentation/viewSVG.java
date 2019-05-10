/*
 *  
 */
package presentation;

import data.exceptions.LoginException;
import data.models.OrderModel;
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
        
        String svgbase = logic.getSVGbase(order);
        session.setAttribute("svgbase", svgbase);
        
        String svgroof = logic.getSVGroof(order);
        session.setAttribute("svgroof", svgroof);
        
        
        
        return "viewSVG";
    }

}
