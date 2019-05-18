/*
 *  
 */
package presentation.commands;


import presentation.Validation;
import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.OrderModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * View a single order.
 *
 * @author
 */
public class ViewSingleOrder extends Command {
    @Override

    public String execute(HttpServletRequest request, LogicFacade logic) throws DataException, UserException
    {


        Validation validation = new Validation();
        int id = validation.validateInteger(request.getParameter("orderid"), "Order id");

        // Get an order by id from database.
        OrderModel order = logic.getOrder(id);

        // Place values used by viewOrder on request.
        request.setAttribute("order", order);
        request.setAttribute("tile", logic.getMaterial(order.getRoof_tiles_id(), "roof").getDescription());
        request.setAttribute("shedwalls", logic.getMaterial(order.getShed_walls_id(), "shed").getDescription());
        request.setAttribute("shedfloor", logic.getMaterial(order.getShed_floor_id(), "shed").getDescription());
        request.setAttribute("customer", logic.getCustomer(order.getId_customer()));
        request.setAttribute("employee", logic.getEmployee(order.getId_employee()));

        return "viewOrder";
    }

}
