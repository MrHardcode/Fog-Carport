package presentation;

import data.exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Unknown Command. Throws Exception.
 */
class UnknownCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException
    {
        String msg = "Unknown command."; // Maybe elaborate this.
        throw new LoginException(msg);
    }

}