package logic;

import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.List;

public class LogicFacadeImpl implements LogicFacade {

    private static LogicFacadeImpl instance = null;

    public synchronized static LogicFacadeImpl getInstance() {
        if (instance == null) {
            instance = new LogicFacadeImpl();
        }
        return instance;
    }

    /*
    Returns a simple partslist.
    Only takes into account height, width, length, and whether or not you want a shed.
     */
    @Override
    public PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException {
        return PartslistLogic.getInstance().getSimpleBOM(height, length, width, shed);
    }

    @Override
    public List<MaterialModel> addShed(List<MaterialModel> bom, OrderModel order) throws LoginException
    {
        return ShedLogic.getInstance().addShed(bom, order);
    }

}
