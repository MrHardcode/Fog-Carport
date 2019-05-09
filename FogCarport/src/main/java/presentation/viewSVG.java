/*
 *  
 */
package presentation;

import data.exceptions.LoginException;
import data.models.OrderModel;
import javax.servlet.http.HttpServletRequest;
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
        OrderModel order = (OrderModel) request.getSession().getAttribute("order");
        
        
        String svg = logic.getSVG(order);
        
        request.getSession().setAttribute("svg", svg);
        
        
        
        return "viewSVG";
    }

}
