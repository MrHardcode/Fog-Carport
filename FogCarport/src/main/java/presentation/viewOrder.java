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
        LogicFacade db = LogicFacadeImpl.getInstance();
        OrderModel order = db.getOrder(id);
        
        HttpSession session = request.getSession();
        session.setAttribute("order", order);
        session.setAttribute("tile", db.getMaterial(order.getRoof_tiles_id()).getDescription());
        session.setAttribute("shedwalls", db.getMaterial(order.getShed_walls_id()).getDescription());
        session.setAttribute("shedfloor", db.getMaterial(order.getShed_floor_id()).getDescription());
        session.setAttribute("customer", db.getCustomer(order.getId_customer()));
        session.setAttribute("employee", db.getEmployee(order.getId_employee()));
        return "viewOrder";
    }
    
}
