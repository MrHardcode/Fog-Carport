package presentation;

import data.exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * Unknown Command. Throws Exception.
 */
class UnknownCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        if (request.getAttribute("target") == null){
            return "login";
        } else {
            return (String) request.getAttribute("target");
        }
    }

}