package presentation.commands;

//package presentation;
//


// NOT IN USE IN EITHER PRODUCTION OR DEVELOPMENT, WAS USED IN THE BEGINNING OF THE PROJECT

//import data.exceptions.LoginException;
//import data.models.PartslistModel;
//import javax.servlet.http.HttpServletRequest;
//import logic.LogicFacade;
//
//public class makeCarportSimple extends presentation.Command
//{
//
//    /*
//    Command used by .jsp to get the simple version of the PartsList. 
//    Made in first sprint.
//    */
//    @Override
//    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
//    {
//        String height = "210";
//        String length = request.getParameter("length");
//        String width  = request.getParameter("width");
//        String shed   = request.getParameter("shed");
//        String shedLength = "";
//        String shedWidth = "";
//        String shedFloorID = "";
//        String shedWallID = "";
//        if (shed != null)
//        {
//            shedLength = request.getParameter("shed-length");
//            shedWidth = request.getParameter("shed-width");
//            shedFloorID = request.getParameter("shed-floor-id");
//            shedWallID = request.getParameter("shed-wall-id");
//        }
//        PartslistModel bom = logic.getSimpleBOM(height, length, width, shed);
//        request.getSession().setAttribute("bom", bom);
//        
//        return "partslist";
//    }
//    
//}
