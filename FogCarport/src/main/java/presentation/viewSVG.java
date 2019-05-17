/*
 *  
 */
package presentation;


import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.OrderModel;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;

/**
 *
 * @author
 */
public class viewSVG extends Command
{

    public viewSVG(){
    }

    @Override

    String execute(HttpServletRequest request, LogicFacade logic) throws UserException, DataException

    {
        int orderID = Integer.parseInt(request.getParameter("orderid"));
        OrderModel order = logic.getOrder(orderID);
        PartslistModel bom = logic.getPartslistModel(order);
        
        if (order == null || bom == null){
            throw new UserException("You can't view drawing if you haven't generated the partslist first. See Issue #86");
        }
        
        String svgbase = logic.getSVGbase(bom, order);
        request.setAttribute("svgbase", svgbase);
        
        String svgbaseArrowLength = logic.getSVGbaseArrowLength(bom, order, 0);
        String svgbaseArrowLengthExtra = logic.getSVGbaseArrowLength(bom, order, 15);
        String svgbaseArrowWidth = logic.getSVGbaseArrowWidth(bom, order);
        String svgbaseLabelWidth = logic.getSVGbaseLabelWidth(bom, order);
        String svgbaseLabelLength = logic.getSVGbaseLabelLength(bom, order, 0);
        String svgbaseLabelLengthExtra = logic.getSVGbaseLabelLength(bom, order, 10);
        
        request.setAttribute("svgbaseArrowWidth", svgbaseArrowWidth);
        request.setAttribute("svgbaseArrowLengthExtra", svgbaseArrowLengthExtra);
        request.setAttribute("svgbaseArrowLength", svgbaseArrowLength);
        request.setAttribute("svgbaseLabelWidth", svgbaseLabelWidth);
        request.setAttribute("svgbaseLabelLength", svgbaseLabelLength);
        request.setAttribute("svgbaseLabelLengthExtra", svgbaseLabelLengthExtra);
        
        String svgroof = logic.getSVGroof(order);
        request.setAttribute("svgroof", svgroof);
        
        return "viewSVG";
    }

}
