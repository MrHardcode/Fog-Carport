/*
 *  Malte Hviid-Magnussen
 */
package presentation;

import data.exceptions.LoginException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;
import logic.LogicFacadeImpl;

/**
 *
 * @author Malte
 */
public class viewAllOrders extends Command
{

    public viewAllOrders()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        List<Integer> ids = LogicFacadeImpl.getInstance().getAllOrderIds();
        request.getSession().setAttribute("ids", ids);
        return "allOrders";
    }
    
}
