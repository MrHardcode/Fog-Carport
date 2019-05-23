/*
 *  
 */
package presentation;


import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
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

    String execute(HttpServletRequest request, LogicFacade logic) throws DataException, UserException, AlgorithmException
    {
        Validation validation = new Validation();
        int id = validation.validateInteger(request.getParameter("orderid"), "Order id");
        
        // Get an order by id from database
        OrderModel order = logic.getOrder(id);
        
        // Comparing session's userID with the order's userID if the logged in user is a customer
        if (request.getSession().getAttribute("customer") != null)
        {
            int userID1 = order.getId_customer();
            CustomerModel user = (CustomerModel)request.getSession().getAttribute("customer");
            int userID2 = user.getId();
            if (userID1 != userID2)
            {
                throw new UserException("You do not have permission to view this order");
            }
        }
        
        // Creating partslist
        PartslistModel partslist = logic.getPartslistModel(order);

        // Place values used by viewOrder on request.
        request.setAttribute("order", order);
        request.setAttribute("tile", logic.getMaterial(order.getRoof_tiles_id(), "roof").getDescription());
        request.setAttribute("shedwalls", logic.getMaterial(order.getShed_walls_id(), "shed").getDescription());
        request.setAttribute("shedfloor", logic.getMaterial(order.getShed_floor_id(), "shed").getDescription());
        request.setAttribute("customer", logic.getCustomer(order.getId_customer()));
        request.setAttribute("employee", logic.getEmployee(order.getId_employee()));
        
        request.setAttribute("suggestedprice", logic.getSuggestedRetailPrice(partslist));
        request.setAttribute("costprice", partslist.getTotalprice());
        
        //if finalPrice was set during this request
        if (request.getParameterMap().containsKey("finalPrice"))
        {
            int finalPrice = validation.validateInteger(request.getParameter("finalPrice"), "Pris felt");
            //save finalprice to order here
            request.setAttribute("priceOffer", finalPrice);
            //then the above line can probably be deleted or changed with:
            //request.setAttribute("priceOffer", order.getFinalPrice);
        }

        
        return "viewOrder";
    }

}
