package presentation;

import data.exceptions.LoginException;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;
import logic.LogicFacadeImpl;

public class makeCarportSimple extends presentation.Command
{

    /*
    Command used by .jsp to get the simple version of the PartsList. 
    Made in first sprint.
    */
    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        String height = "210";
        String length = request.getParameter("length");
        String width  = request.getParameter("width");
        String shed   = request.getParameter("shed");
        
        PartslistModel bom = logic.getSimpleBOM(height, length, width, shed);
        request.getSession().setAttribute("bom", bom);
        
        return "partslist";
    }
    
}
