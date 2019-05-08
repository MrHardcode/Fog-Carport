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
        String msg = "Unknown command."; // Maybe elaborate this.
        if (request.getAttribute("target") == null){
            request.setAttribute("message", "Unknown Command.");
            return "homepage";
        } else {
            return (String) request.getAttribute("target");
        }
    }

}