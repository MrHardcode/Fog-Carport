/*
 * 
 */
package presentation.commands;

import data.exceptions.UserException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;
import presentation.Validation;

/**
 * Makes sure user always passes through FrontController, even when we just need
 * to redirect (link) user.
 *
 * @author
 */
public class Link extends Command
{

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws UserException
    {
        Validation validation = new Validation();
        return validation.validateString(request.getParameter("link"), "Link");
    }

}
