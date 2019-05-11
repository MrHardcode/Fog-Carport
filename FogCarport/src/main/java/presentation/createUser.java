
package presentation;

import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 *
 * @author 
 */
public class createUser extends Command
{

    public createUser()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException, AlgorithmException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
