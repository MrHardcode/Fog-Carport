/*
 *  
 */
package presentation;

import data.exceptions.LoginException;
import data.models.CustomerModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 *
 * @author 
 */
public class login extends Command
{

    public login()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        CustomerModel customer = logic.login(email, password);
        
        request.getSession().setAttribute("customer", customer);
        
        return "homepage";
    }
    
}
