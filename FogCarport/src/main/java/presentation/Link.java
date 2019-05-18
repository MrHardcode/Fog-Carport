/*
 * 
 */
package presentation;

import data.exceptions.UserException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 *
 * @author
 */
public class Link extends Command
{
    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws UserException
    {
        Validation validation = new Validation();
        return validation.validateString(request.getParameter("link"), "Link");  
    }
    
}
