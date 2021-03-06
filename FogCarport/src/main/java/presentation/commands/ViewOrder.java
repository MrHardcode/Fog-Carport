/*
 *  
 */
package presentation.commands;

import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;
import presentation.Validation;

/**
 * View a single order.
 *
 * @author
 */
public class ViewOrder extends Command
{

    @Override

    public String execute(HttpServletRequest request, LogicFacade logic) throws DataException, UserException, AlgorithmException
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
                throw new UserException("Du har ikke tilladelse til at se denne ordre");
            }
        }
        
        // Creating partslist
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
