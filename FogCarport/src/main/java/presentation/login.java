/*
 *  
 */
package presentation;

import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * Login Method. This is called after you hit "log ind" on the login.jsp. You're
 * then either confirmed as a valid user, or rejected and sent back to the login
 * page.
 *
 * @author
 */
public class login extends Command
{

    public login()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws UserException, DataException
    {
        Validation validation = new Validation();
        String email = validation.validateString(request.getParameter("email"), "Email"); // Get the email from the Parameters 
        String password = validation.validateString(request.getParameter("password"), "Password"); // Get the password from the Parameters

        CustomerModel customer = null;
        EmployeeModel employee = null;
        try
        {
            /* Log in customer */
            customer = logic.login(email, password);
            request.getSession().setAttribute("customer", customer);

        }
        catch (UserException ux)
        {
            /* if customer login fails, try to log in Employee instead */
            employee = logic.empLogin(email, password);
            
            request.getSession().setAttribute("employee", employee);
        }

        if (customer != null)
        {

            List<Integer> ids = logic.getOrderIds(customer.getId());

            if (ids.isEmpty())
            {
                request.setAttribute("message", "Ingen ordrer fundet. Når du engang har bestilt, vil din ordre vises her.");
            }

            request.setAttribute("ids", ids);
        }
        else if (employee != null)
        {
            List<Integer> allOrders = logic.getAllOrderIds();
            request.setAttribute("ids", allOrders);
        }

        return "allOrders";

    }

}
