/*
 *  
 */
package presentation;

import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.OrderModel;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * View a single order.
 *
 * @author
 */
public class viewOrder extends Command
{

    public viewOrder()
    {
    }

    @Override

    String execute(HttpServletRequest request, LogicFacade logic) throws DataException, UserException, AlgorithmException
    {

        Validation validation = new Validation();
        int id = validation.validateInteger(request.getParameter("orderid"), "Order id");

        // Get an order by id from database and partslist.
        OrderModel order = logic.getOrder(id);
        PartslistModel partslist = logic.getPartslistModel(order);
        double suggestedPrice = (double) logic.getSuggestedRetailPrice(partslist);

        if (request.getParameterMap().containsKey("finalPrice")) //if finalPrice was set by an Employee during this request
        {
            //(finalPrice is the new price offer from the salesman)
            int finalPrice = validation.validateInteger(request.getParameter("finalPrice"), "Pris felt");
            logic.updateOrderPrice(id, finalPrice);
            order.setPrice(finalPrice);
        }

        if (order.getStatus().equals("Finalized")) //if order is already done, ignore all else
        {
        }
        else if (order.getPrice() == -1) //else if there was NOT set a new offer && order price is still set to -1
        {
            //-1 is the default price value in database
            logic.updateOrderPrice(id, suggestedPrice); //set suggested as default price
            order.setPrice(suggestedPrice);
        }
        else if (order.getPrice() != suggestedPrice)
        {
            //show special price offer
            request.setAttribute("priceOffer", order.getPrice());
        }

        // Place values used by viewOrder on request.
        request.setAttribute("order", order);
        request.setAttribute("tile", logic.getMaterial(order.getRoof_tiles_id(), "roof").getDescription());
        request.setAttribute("shedwalls", logic.getMaterial(order.getShed_walls_id(), "shed").getDescription());
        request.setAttribute("shedfloor", logic.getMaterial(order.getShed_floor_id(), "shed").getDescription());
        request.setAttribute("customer", logic.getCustomer(order.getId_customer()));
        request.setAttribute("employee", logic.getEmployee(order.getId_employee()));

        request.setAttribute("suggestedprice", suggestedPrice);
        request.setAttribute("costprice", partslist.getTotalprice());

        return "viewOrder";
    }

}
