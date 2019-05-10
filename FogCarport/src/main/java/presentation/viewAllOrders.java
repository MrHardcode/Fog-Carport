/*
 * 
 */
package presentation;

import data.exceptions.LoginException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * View a list of all orders. Sends user to allOrders.jsp.
 *
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
        if (request.getSession().getAttribute("ids") == null)
        {
            List<Integer> ids = logic.getAllOrderIds();
            request.getSession().setAttribute("ids", ids);
        }
        return "allOrders";
    }

}
