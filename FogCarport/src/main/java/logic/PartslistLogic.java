package logic;

import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;

/**
 * Udregner Styklisten. Skal måske deles op i flere klasser? 1 til skur, 1 til
 * tag, 1 til underkonstruktionen.
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
    
    Beklædning - 16x100 - Trykimprægneret
    Vindskede - 25x150 - Trykimprægneret
    Lægte - 38x73 - T1
    Stern - 25x150 - Trykimprægneret
    Tag - Tagsten - Beton - 20gr.
    Spær - 45x95 - Reglar
    Rem - 45 x 195 - Spærtræ
    Stolpe - 100x100 - Trykimprægneret
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
        if (s == true)
        {
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
        /* Beslag og skruer */
        MaterialModel stalddørsgreb = new MaterialModel(75, "Stalddørsgreb", "Stalddørsgreb 50x75", 1, 0, 0);
        stalddørsgreb.setHelptext("til dør i skur");
        stalddørsgreb.setQuantity(1);
        stalddørsgreb.setUnit("sæt");
        bom.addMaterial(stalddørsgreb);

        MaterialModel thængsel = new MaterialModel(390, "T-hængsel", "T-Hængsel 390 mm.", 1, 0, 0);
        thængsel.setHelptext("til dør i skur");
        thængsel.setQuantity(2);
        thængsel.setUnit("Stk.");
        bom.addMaterial(thængsel);

        MaterialModel skruer70 = new MaterialModel(70, "Skruer70", "4,5 x 70 mm. Skruer 200 stk.", 1, 0, 0);
        skruer70.setHelptext("til montering af yderste bræt ved beklædning");
        skruer70.setQuantity(3);
        skruer70.setUnit("Pk.");
        bom.addMaterial(skruer70);

        MaterialModel skruer50 = new MaterialModel(50, "Skruer50", "4,5 x 50 mm. Skruer 350 stk.", 1, 0, 0);
        skruer50.setHelptext("til montering af yderste bræt ved beklædning");
        skruer50.setQuantity(2);
        skruer50.setUnit("Pk.");
        bom.addMaterial(skruer50);

        /* Træ */
        MaterialModel bræt210 = new MaterialModel(210, "bræt", "19x100 mm. trykimp. Bræt", 100, 2100, 19);
        bræt210.setHelptext("Beklædning af skur 1 på 2");
        bræt210.setQuantity(148);
        bræt210.setUnit("Stk.");
        bom.addMaterial(bræt210);
        
        MaterialModel løsholt360 = new MaterialModel(360, "løsholt", "45x95 Reglar ubh.", 95, 3600, 45);
        løsholt360.setHelptext("Løsholter i gavle af skur");
        løsholt360.setQuantity(6);
        løsholt360.setUnit("Stk.");
        bom.addMaterial(løsholt360);
        
        MaterialModel løsholt240 = new MaterialModel(240, "løsholt", "45x95 Reglar ubh.", 95, 2400, 45);
        løsholt240.setHelptext("Løsholter i siderne af skur");
        løsholt240.setQuantity(4);
        løsholt240.setUnit("Stk.");
        bom.addMaterial(løsholt240);
        
        

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
