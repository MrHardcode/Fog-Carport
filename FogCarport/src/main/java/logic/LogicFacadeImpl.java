package logic;

import data.DataFacadeImpl;
import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
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

    /*
    Returns a simple partslist.
    Only takes into account height, width, length, and whether or not you want a shed.
     */
    @Override
    public PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException
    {
        return PartslistLogic.getInstance().getSimpleBOM(height, length, width, shed);
    }

    @Override
    public PartslistModel getBOM() throws LoginException
    {
        return PartslistLogic.getInstance().getBOM();
    }

    @Override
    public List<Integer> getAllOrderIds() throws LoginException
    {
        return DataFacadeImpl.getInstance().getAllOrderIds();
    }

    @Override
    public OrderModel getOrder(int id) throws LoginException
    {
        return DataFacadeImpl.getInstance().getOrder(id);
    }

    @Override
    public MaterialModel getMaterial(int id) throws LoginException
    {
        return DataFacadeImpl.getInstance().getMaterial(id);
    }

    @Override
    public CustomerModel getCustomer(int id) throws LoginException
    {
        return DataFacadeImpl.getInstance().getCustomer(id);
    }

    @Override
    public EmployeeModel getEmployee(int id) throws LoginException
    {
        return DataFacadeImpl.getInstance().getEmployee(id);
    }

    @Override
    public void createCustomer(CustomerModel customer) throws LoginException
    {
        DataFacadeImpl.getInstance().createCustomer(customer);
    }

    @Override
    public void createEmployee(EmployeeModel employee) throws LoginException
    {
        DataFacadeImpl.getInstance().createEmployee(employee);
    }

    @Override
    public void createOrder(OrderModel order) throws LoginException
    {
        DataFacadeImpl.getInstance().createOrder(order);
    }

    // Mother methods that calls all the partslist calculator logic and returns a partslistmodel.
    @Override
    public PartslistModel getPartslistModel(OrderModel order) throws LoginException, AlgorithmException
    {
        PartslistModel partslistmodel = new PartslistModel();
        // Add Shed
        if (order.getShed_width() != 0 && order.getShed_length() != 0 && order.getShed_walls_id() != 0)
        {
            ShedLogic shed = new ShedLogic();
            partslistmodel.addPartslist(shed.addShed(partslistmodel, order));
        }
        if (order.getIncline() == 0)
        {
            // Add flat roof
            RoofFlatCalc flatroof = new RoofFlatCalc();
            partslistmodel.addPartslist(flatroof.calculateFlatRoofStructure(order));
        } else
        {
            // Add raised roof
            RoofRaisedCalc raisedroof = new RoofRaisedCalc();
            partslistmodel.addPartslist(raisedroof.getRoofRaisedMaterials(order));
        }
        // Add base
        BaseCalc basecalc = new BaseCalc();
        partslistmodel.addPartslist(basecalc.addBase(partslistmodel, order));

        return partslistmodel;
    }

    // Mother method that calls all the partslist SVG logic and returns the SVG string.
    @Override
    public String getSVG(OrderModel order)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
