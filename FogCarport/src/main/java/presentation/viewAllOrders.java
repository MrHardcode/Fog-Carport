/*
 * 
 */
package presentation;

import data.exceptions.LoginException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;
import logic.LogicFacadeImpl;

/**
 * View a list of all orders.
 * @author 
 */
public class viewAllOrders extends Command
{

    public viewAllOrders()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        List<Integer> ids = logic.getAllOrderIds();
        request.getSession().setAttribute("ids", ids);
        return "allOrders";
    }
    
}
