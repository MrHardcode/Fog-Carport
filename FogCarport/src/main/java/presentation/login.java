/*
 *  
 */
package presentation;

import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 *
 * @author 
 */
public class login extends Command
{

    public login()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException, AlgorithmException
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
    }
    
}
