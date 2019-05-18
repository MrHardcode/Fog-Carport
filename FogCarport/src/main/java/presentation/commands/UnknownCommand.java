package presentation.commands;

import data.exceptions.UserException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * Unknown Command. Throws Exception.
 */
class UnknownCommand extends Command
{
    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws UserException
    {
        if (request.getAttribute("target") == null){
            return "login";
        } else {
            return (String) request.getAttribute("target");
        }
    }

}