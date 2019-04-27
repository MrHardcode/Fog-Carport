/*
 *  
 */
package logic;

import data.models.MaterialModel;
import data.models.OrderModel;
import java.util.List;

/**
 * Contains logic regarding the Bill of Materials for a shed in the carport.
 * @author 
 */
public class ShedLogic
{
    private static ShedLogic instance = null;

    public synchronized static ShedLogic getInstance()
    {
        if (instance == null)
        {
            instance = new ShedLogic();
        }
        return instance;
    }

    List<MaterialModel> addShed(List<MaterialModel> bom, OrderModel order)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
