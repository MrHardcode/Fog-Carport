package presentation.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;

/**
 * Command that handles log out (from the log out button in the navbar)
 * Should be optimized if possible. session.invalidate does NOT seem to work as intended.
 * 
 * @author 
 */
public class LogOut extends Command
{

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) 
    {
        HttpSession session = request.getSession(false); //get current session
        if (session != null)
        {
            session.invalidate(); //invalidate current session
            request.setAttribute("target", "login"); //send user to login page
            request.setAttribute("message", "Du er nu logget ud.");
        }
       return "login";
    }

}
