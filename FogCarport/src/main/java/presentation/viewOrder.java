/*
 *  
 */
package presentation;

import data.exceptions.LoginException;
import data.models.OrderModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;
import logic.LogicFacadeImpl;

/**
 * View a single order.
 * @author 
 */
public class viewOrder extends Command
{

    public viewOrder()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        int id = Integer.parseInt(request.getParameter("orderid"));
        LogicFacade db = LogicFacadeImpl.getInstance();
        OrderModel order = db.getOrder(id);
        
        request.getSession().setAttribute("order", order);
        request.getSession().setAttribute("tile", db.getMaterial(order.getRoof_tiles_id()).getDescription());
        request.getSession().setAttribute("shedwalls", db.getMaterial(order.getShed_walls_id()).getDescription());
        request.getSession().setAttribute("shedfloor", db.getMaterial(order.getShed_floor_id()).getDescription());
        return "viewOrder";
    }
    
}
