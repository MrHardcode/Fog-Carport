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
 * Sends user from viewOrder.jsp to partslist.jsp and populates it if need be.
 *
 * @author
 */
public class viewPartslist extends Command {

    public viewPartslist() {
    }

    @Override

    String execute(HttpServletRequest request, LogicFacade logic) throws UserException, DataException, AlgorithmException {
        int orderID = Integer.parseInt(request.getParameter("orderid"));
        OrderModel order = logic.getOrder(orderID);
        PartslistModel partslist = logic.getPartslistModel(order);
        
        if (order == null || partslist == null) {
            throw new UserException("You can't view drawing if you haven't generated the partslist first. See Issue #86");

        }
        request.setAttribute("partslistbom", partslist);
        return "partslist";
    }

}
