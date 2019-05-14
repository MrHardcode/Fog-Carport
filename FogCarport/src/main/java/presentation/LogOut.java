package presentation;

import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;

/**
 *
 * @author Runi
 */
public class LogOut extends Command
{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException, AlgorithmException
    {
//        HttpSession session = request.getSession(false); //get current session
//        if (session != null)
//        {
//            request.getSession().invalidate(); //invalidate current session
//            request.getSession(); //force session check (== null), set new session
//            request.setAttribute("target", "login"); //send user to login page
//            request.setAttribute("message", "Successfully logged out");
//            //request.getRequestDispatcher("index.jsp");
//            //return "login";
//        }
       return "login";
    }

}
