/*
 * 
 */
package presentation;

import data.exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 *
 * @author
 */
public class link extends Command
{

    public link()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        Validation validation = new Validation();
        return validation.validateString(request.getParameter("link"), "Link");  
    }
    
}
