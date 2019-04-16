package presentation;

import data.exceptions.LoginException;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LogicFacadeImpl;

public class makeCarportSimple extends presentation.Command
{

    /*
    Command used by .jsp to get the simple version of the PartsList. 
    Made in first sprint.
    */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException
    {
        String height = request.getParameter("height");
        String length = request.getParameter("length");
        String width  = request.getParameter("width");
        String shed   = request.getParameter("shed");
        
        PartslistModel bom = LogicFacadeImpl.getInstance().getSimpleBOM(height, length, width,  shed);
        request.getSession().setAttribute("bom", bom);
        
        return "partslist";
    }
    
}
