/*
 *  Malte Hviid-Magnussen
 */
package logic;

import data.DataFacade;
import data.DataFacadeImpl;
import data.models.OrderModel;
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
        boolean s = false;
        if ("y".equals(shed)){
            s = true;
        }
        int h = Integer.parseInt(height);
        int l = Integer.parseInt(length);
        int w = Integer.parseInt(width);
        OrderModel order = new OrderModel(h, l, w, s);
        DataFacade db = new DataFacadeImpl();
        return db.getBOM(order);
    }
    
}
