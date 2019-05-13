/*
 * 
 */
package presentation;

import data.exceptions.LoginException;
import data.models.CustomerModel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 *
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
        // Pull Customer out of Session.
        CustomerModel customer = (CustomerModel) request.getSession().getAttribute("customer");
        if (customer != null)
        {
            // Get all the ids of the customers orders from the database.
            List<Integer> ids = logic.getOrderIds(customer.getId());
            // Message to User if they have no orders.
            if (ids.isEmpty())
            {
                request.setAttribute("message", "You have no Orders. Orders show up here when you make one.");
            }
            // Put them on the request so they can be shown to the Customer.
            request.setAttribute("ids", ids);
        }

        // Send Customer to the page where they can view and select any of their orders.
        return "allOrders";
    }

}
