/*
 *  
 */
package presentation;

import data.exceptions.LoginException;
import data.models.OrderModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        OrderModel order = logic.getOrder(id);
        
        HttpSession session = request.getSession();
        session.setAttribute("order", order);
        session.setAttribute("tile", logic.getMaterial(order.getRoof_tiles_id()).getDescription());
        session.setAttribute("shedwalls", logic.getMaterial(order.getShed_walls_id()).getDescription());
        session.setAttribute("shedfloor", logic.getMaterial(order.getShed_floor_id()).getDescription());
        session.setAttribute("customer", logic.getCustomer(order.getId_customer()));
        session.setAttribute("employee", logic.getEmployee(order.getId_employee()));
        return "viewOrder";
    }
    
}
