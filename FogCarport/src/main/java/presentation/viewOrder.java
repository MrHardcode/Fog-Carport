/*
 *  
 */
package presentation;

import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import data.models.OrderModel;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;

/**
 * View a single order.
 *
 * @author
 */
public class viewOrder extends Command {

    public viewOrder() {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException, AlgorithmException {

        Validation validation = new Validation();
        int id = validation.validateInteger(request.getParameter("orderid"), "Order id");

        // Get an order by id from database.
        OrderModel order = logic.getOrder(id);

        // Place values used by viewOrder on request.
        request.setAttribute("order", order);
        request.setAttribute("tile", logic.getMaterial(order.getRoof_tiles_id()).getDescription());
        request.setAttribute("shedwalls", logic.getMaterial(order.getShed_walls_id()).getDescription());
        request.setAttribute("shedfloor", logic.getMaterial(order.getShed_floor_id()).getDescription());
        request.setAttribute("customer", logic.getCustomer(order.getId_customer()));
        request.setAttribute("employee", logic.getEmployee(order.getId_employee()));

        PartslistModel partslist = logic.getPartslistModel(order);
        request.setAttribute("bom", partslist);

        return "viewOrder";
    }

}
