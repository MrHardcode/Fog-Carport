
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

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException, AlgorithmException
    {
        
        return "createUser";
    }
    
}
