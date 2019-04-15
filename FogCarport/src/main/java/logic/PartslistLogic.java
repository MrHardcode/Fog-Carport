package logic;

import data.models.OrderModel;
import data.models.PartslistModel;

/**
 * Udregner Styklisten.
 * Skal måske deles op i flere klasser? 1 til skur, 1 til tag, 1 til underkonstruktionen.
 */
class PartslistLogic
{
    
    private static PartslistLogic instance = null;

    public synchronized static PartslistLogic getInstance()
    {
        if (instance == null)
        {
            instance = new PartslistLogic();
        }
        return instance;
    }

    PartslistModel getSimpleBOM(String height, String length, String width, String shed)
    {
        PartslistModel bom = new PartslistModel();
        boolean s = false;
        int h = Integer.parseInt(height);
        int l = Integer.parseInt(length);
        int w = Integer.parseInt(width);
        if ("y".equals(shed))
        {
            s = true;
        }
        OrderModel order = new OrderModel(h, l, w, s);
        if (s==true){
            addShed(order, bom);
        }
        addRoof(order, bom);
        addBase(order, bom);
        return bom;
    }

    /*
    Tilføj skur-materialerne til PartsList.
    Task #26.
    */
    private void addShed(OrderModel order, PartslistModel bom)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Tilføj tag-materialerne til Partslist.
    Task #28.
    */
    private void addRoof(OrderModel order, PartslistModel bom)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Tilføj underkonstruktions-materialerne til Partslist.
    Task #31.
    */
    private void addBase(OrderModel order, PartslistModel bom)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
