package logic;

import data.DataFacadeImpl;
import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.List;
import logic.Calculations.BaseCalc;
import logic.Calculations.RoofFlatCalc;
import logic.Calculations.RoofRaisedCalc;
import logic.Calculations.ShedLogic;
import logic.drawings.SVGDrawingBase;
import logic.drawings.SVGDrawingFlatRoof;
import logic.drawings.SVGDrawingRaisedRoof;
import logic.drawings.SVGDrawingShed;

public class LogicFacadeImpl implements LogicFacade
{

    private static LogicFacadeImpl instance = null;

    public synchronized static LogicFacadeImpl getInstance()
    {
        if (instance == null)
        {
            instance = new LogicFacadeImpl();
        }
        return instance;
    }

//    /*
//    Returns a simple partslist.
//    Only takes into account height, width, length, and whether or not you want a shed.
//     */
//    @Override
//    public PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException
//    {
//        return PartslistLogic.getInstance().getSimpleBOM(height, length, width, shed);
//    }
//
//    @Override
//    public PartslistModel getBOM() throws LoginException
//    {
//        return PartslistLogic.getInstance().getBOM();
//    }
    @Override
    public List<Integer> getAllOrderIds() throws DataException
    {
        return DataFacadeImpl.getInstance().getAllOrderIds();
    }

    @Override
    public OrderModel getOrder(int id) throws DataException
    {
        return DataFacadeImpl.getInstance().getOrder(id);
    }

    @Override
    public MaterialModel getMaterial(int id, String helptext) throws DataException
    {
        return DataFacadeImpl.getInstance().getMaterial(id, helptext);
    }

    @Override
    public CustomerModel getCustomer(int id) throws DataException
    {
        return DataFacadeImpl.getInstance().getCustomer(id);
    }

    @Override
    public EmployeeModel getEmployee(int id) throws UserException
    {
        return DataFacadeImpl.getInstance().getEmployee(id);
    }

    @Override
    public void createCustomer(CustomerModel customer) throws UserException
    {
        DataFacadeImpl.getInstance().createCustomer(customer);
    }

    @Override
    public void createEmployee(EmployeeModel employee) throws UserException
    {
        DataFacadeImpl.getInstance().createEmployee(employee);
    }

    @Override
    public void createOrder(OrderModel order) throws DataException
    {
        DataFacadeImpl.getInstance().createOrder(order);
    }

    // Mother methods that calls all the partslist calculator logic and returns a partslistmodel.
    @Override
    public PartslistModel getPartslistModel(OrderModel order) throws DataException, AlgorithmException
    {
        PartslistModel partslistmodel = new PartslistModel();
        // Add Shed
        if (order.getShed_width() != 0 && order.getShed_length() != 0)
        {
            ShedLogic shed = new ShedLogic();
            partslistmodel.addPartslist(shed.addShed(order));
        }
        if (order.getIncline() == 0)
        {
            // Add flat roof
            RoofFlatCalc flatroof = new RoofFlatCalc();
            partslistmodel.addPartslist(flatroof.calculateFlatRoofStructure(order));
        }
        else
        {
            // Add raised roof
            RoofRaisedCalc raisedroof = new RoofRaisedCalc();
            partslistmodel.addPartslist(raisedroof.getRoofRaisedMaterials(order));
        }
        // Add base
        BaseCalc basecalc = new BaseCalc();
        partslistmodel.addPartslist(basecalc.addBase(order));

        return partslistmodel;
    }

    // Mother method that calls the main parts of partslist SVG drawings for shed and base.
    @Override
    public String getSVGbase(PartslistModel bom, OrderModel order)
    {
        // BEGINNING
        String SVG = "";

        // #1 NESTED SVG FOR SOME PADDING: 
        SVG += " <svg x=\"100\" y=\"100\"> ";

        // SHED ALSO HAS ITS OWN NESTING WITHIN. NOW SHED IS RELATIVE TO NEST #1
        if (order.getShed_width() != 0 && order.getShed_length() != 0 && order.getShed_walls_id() != 0)
        {
            SVGDrawingShed shed = new SVGDrawingShed();
            SVG += shed.getShedDrawing(order);
        }
        // ADD BASE DRAWING
        SVGDrawingBase base = new SVGDrawingBase(order, bom);
        SVG += base.getBaseDrawing(order);

        // #1 NESTING END 
        SVG += " </svg> ";

        // END
        SVG += "";

        return SVG;
    }

    @Override
    public String getSVGbaseArrowLength(PartslistModel bom, OrderModel order, int extraDistance)
    {
        SVGDrawingBase base = new SVGDrawingBase(order, bom);
        String SVG = "";
        SVG += base.getLengthArrow(extraDistance);
        return SVG;
    }

    @Override
    public String getSVGbaseArrowWidth(PartslistModel bom, OrderModel order, int extraDistance)
    {
        SVGDrawingBase base = new SVGDrawingBase(order, bom);
        String SVG = "";
        SVG += base.getWidthArrow(extraDistance);
        return SVG;
    }

    @Override
    public String getSVGbaseLabelWidth(PartslistModel bom, OrderModel order, int extraDistance)
    {
        SVGDrawingBase base = new SVGDrawingBase(order, bom);
        String SVG = "";
        SVG += base.getWidthLabel(extraDistance);
        return SVG;
    }

    @Override
    public String getSVGbaseLabelLength(PartslistModel bom, OrderModel order, int extraDistance)
    {
        SVGDrawingBase base = new SVGDrawingBase(order, bom);
        String SVG = "";
        SVG += base.getLengthLabel(extraDistance);
        return SVG;
    }

    // Mother method that calls all the partslist SVG drawings for shed and base.
    @Override
    public String getSVGroof(OrderModel order) throws DataException, AlgorithmException
    {
        if (order.getIncline() == 0)
        {
            SVGDrawingFlatRoof roof = new SVGDrawingFlatRoof();
            return roof.getFlatRoofDrawing(order);
        }
        else
        {
            SVGDrawingRaisedRoof roof = new SVGDrawingRaisedRoof();
            return roof.getRaisedRoofDrawing(order);
        }
    }

    @Override
    public CustomerModel login(String email, String password) throws UserException
    {
        return DataFacadeImpl.getInstance().login(email, password);
    }

    @Override
    public List<Integer> getOrderIds(int id) throws DataException
    {
        return DataFacadeImpl.getInstance().getOrderIds(id);
    }

    @Override
    public void payOrder(int id) throws DataException
    {
        DataFacadeImpl.getInstance().payOrder(id);
    }

    @Override
    public EmployeeModel empLogin(String name, String password) throws UserException
    {
        return DataFacadeImpl.getInstance().empLogin(name, password);
    }

}
