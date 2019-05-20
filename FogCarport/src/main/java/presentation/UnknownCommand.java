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
        if (request.getAttribute("target") == null){
            return "homepage";
        } else {
            return (String) request.getAttribute("target");
        }
    }

}