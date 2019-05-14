/*
 *  
 */
package presentation;

import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import data.models.OrderModel;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * Sends user from viewOrder.jsp to partslist.jsp and populates it if need be.
 * @author 
 */
public class viewPartslist extends Command
{

    public viewPartslist()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException, AlgorithmException
    {
        OrderModel order = (OrderModel) request.getAttribute("order");
        if (order != null){
            PartslistModel partslist = logic.getPartslistModel(order);
            request.setAttribute("bom", partslist);
            return "partslist";
        }
        return "viewOrder";
    }
    
}
