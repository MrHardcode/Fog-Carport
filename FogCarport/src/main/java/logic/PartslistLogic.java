package logic;

import data.models.MaterialModel;
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

    /*
    https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CAR01_HR.pdf
    Malte har brugt denne som udgangspunkt for skurlisten.
    */
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
    MaterialModel(int ID, String name, String description, int height, int length, int width)
    int quantity;
    private String helptext;
    */
    private void addShed(OrderModel order, PartslistModel bom)
    {
        MaterialModel stalddørsgreb = new MaterialModel(1212, "Stalddørsgreb", " 50x75 til dør i skur", 1, 0, 0);
        stalddørsgreb.setQuantity(1);
        stalddørsgreb.setUnit("sæt");
        bom.addMaterial(stalddørsgreb);
        
        
    }

    /*
    Tilføj tag-materialerne til Partslist.
    Task #28.
    */
    private void addRoof(OrderModel order, PartslistModel bom)
    {
        
    }

    /*
    Tilføj underkonstruktions-materialerne til Partslist.
    Task #31.
    */
    private void addBase(OrderModel order, PartslistModel bom)
    {
        
    }
}
