/*
 *  Malte Hviid-Magnussen
 */
package logic;

import data.models.PartslistModel;

/**
 *
 * @author Malte
 */
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
    Made in first sprint.
    Only takes into account height, width, length, and whether or not you want a shed.
    */
    @Override
    public PartslistModel getSimpleBOM(String height, String width, String length, String shed)
    {
        return PartslistLogic.getInstance().getSimpleBOM(height, length, width, shed);
    }
    
}
