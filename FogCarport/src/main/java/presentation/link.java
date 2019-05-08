/*
 * 
 */
package presentation;

import data.exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 *
 * @author
 */
public class link extends Command
{

    public link()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        String link = request.getParameter("link");
        if (link != null && !link.isEmpty()){
            return link;
        } else {
            return "homepage";
        }
                
    }
    
}
