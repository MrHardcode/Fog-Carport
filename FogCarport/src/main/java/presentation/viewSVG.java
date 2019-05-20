/*
 *  
 */
package presentation;


import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.OrderModel;
import data.models.PartslistModel;
import javax.servlet.http.HttpServletRequest;
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

    String execute(HttpServletRequest request, LogicFacade logic) throws UserException, DataException, AlgorithmException

    {
        Validation validate = new Validation();
        int orderID = validate.validateInteger(request.getParameter("orderid"), "Order ID");
        OrderModel order = logic.getOrder(orderID);
        PartslistModel bom = logic.getPartslistModel(order);
        
        String svgbase = logic.getSVGbase(bom, order);
        request.setAttribute("svgbase", svgbase);
        
        String svgbaseArrowLength = logic.getSVGbaseArrowLength(bom, order, 0);
        String svgbaseArrowLengthExtra = logic.getSVGbaseArrowLength(bom, order, order.getIncline());
        String svgbaseArrowWidth = logic.getSVGbaseArrowWidth(bom, order);
        String svgbaseLabelWidth = logic.getSVGbaseLabelWidth(bom, order);
        String svgbaseLabelLength = logic.getSVGbaseLabelLength(bom, order, 0);
        String svgbaseLabelLengthExtra = logic.getSVGbaseLabelLength(bom, order, order.getIncline());
        
        request.setAttribute("svgbaseArrowWidth", svgbaseArrowWidth);
        request.setAttribute("svgbaseArrowLengthExtra", svgbaseArrowLengthExtra);
        request.setAttribute("svgbaseArrowLength", svgbaseArrowLength);
        request.setAttribute("svgbaseLabelWidth", svgbaseLabelWidth);
        request.setAttribute("svgbaseLabelLength", svgbaseLabelLength);
        request.setAttribute("svgbaseLabelLengthExtra", svgbaseLabelLengthExtra);
        
        String svgroof = logic.getSVGroof(order);
        request.setAttribute("svgroof", svgroof);
        
        request.setAttribute("ID", orderID);
        return "viewSVG";
    }

}
