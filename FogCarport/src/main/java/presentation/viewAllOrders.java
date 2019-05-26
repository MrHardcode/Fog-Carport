/*
 * 
 */
package presentation;

import data.exceptions.DataException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
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

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws DataException
    {
        // Pull Customer out of Session.
        CustomerModel customer = (CustomerModel) request.getSession().getAttribute("customer");
        EmployeeModel employee = (EmployeeModel) request.getSession().getAttribute("employee");
        if (customer != null) {
            // Get all the ids of the customers orders from the database.
            List<Integer> ids = logic.getOrderIds(customer.getId());
            // Message to User if they have no orders.
            if (ids.isEmpty())
            {
                request.setAttribute("message", "Ingen ordrer fundet. Når du engang har bestilt, vil din ordre vises her.");
            }
            // Put them on the request so they can be shown to the Customer.
            request.setAttribute("ids", ids);
        }
        else if(employee != null){
            List<Integer> allOrders = logic.getAllOrderIds();
            request.setAttribute("ids", allOrders);
        }
        

        // Send Customer to the page where they can view and select any of their orders.
        return "allOrders";
    }

}
