package logic;

import data.models.PartslistModel;


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
    public PartslistModel getSimpleBOM(String height, String width, String length, String shed)
    {
        return PartslistLogic.getInstance().getSimpleBOM(height, length, width, shed);
    }
    
}
