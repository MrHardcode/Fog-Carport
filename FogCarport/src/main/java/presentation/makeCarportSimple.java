package presentation;

import data.exceptions.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class makeCarportSimple extends presentation.Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException
    {
        String height = request.getParameter("height");
        String width  = request.getParameter("width");
        String length = request.getParameter("length");
        String shed   = request.getParameter("shed");
        
        // Below is just an idea of how it could work.
//        BOM bom = new BOM();
//        LogicFacade c = LogicFacadeImpl().getInstance();
//        bom = c.getSimpleBOM(height, width, length);
//        if ("y".equals(shed)){
//            c.addShed(bom);
//        }
//        
//        request.getSession().setAttribute("bom", bom);
//        
//        return "bom";
        return "bom";
    }
    
}
