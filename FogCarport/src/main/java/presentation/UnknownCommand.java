package presentation;

import data.exceptions.UserException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * Unknown Command. Throws Exception.
 */
class UnknownCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws UserException
    {
        /* If there is nothing in the "target" attribute, send user to homepage. */
        if (request.getAttribute("target") == null){
            return "";
        } else {
            return (String) request.getAttribute("target");
        }
    }

}