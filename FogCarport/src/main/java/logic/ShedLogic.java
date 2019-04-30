/*
 *  
 */
package logic;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;

/**
 * Contains logic regarding the Bill of Materials for a shed in the carport.
 *
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

    /*
    https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CAR01_HR.pdf
    Going off of this with regards to assumptions.
    I assume that this method is only called if the stuff in order regarding shed is not null.
    Things to take into account: 
    Width of the shed
    Length of the shed
    Type of wood used for the sheds "beklædning"
    Type of wood used for the floor (if they even want a floor)
     */
    PartslistModel addShed(PartslistModel bom, OrderModel order) throws LoginException
    {
        DataFacade db = DataFacadeImpl.getInstance();

        boolean standard = false;
        if (standard == true)
        {
            simpleShed(bom);
        } else
        {

            // VARIABLES IF NOT STANDARD SHED:
            int width = order.getShed_width();
            int length = order.getShed_length();
            MaterialModel wood = db.getMaterial(order.getShed_walls_id());

            // MATERIALS NEEDED NO MATTER WHAT - DOOR
            addDoorMaterials(bom, wood, db);

            // IF FLOOR IS CHOSEN:
            if (order.getShed_floor_id() != 0)
            {
                MaterialModel floor = db.getMaterial(order.getShed_floor_id());
                // ADD X AMOUNT OF FLOOR DEPENDING ON WIDTH AND LENGTH HERE TO BOM
                addFloor(bom, floor, length, width);
            }

            // AND THE REST
            addMaterials(bom, wood, length, width, db);

        }

        return bom;
    }

    private void simpleShed(PartslistModel bom)
    {
        //<editor-fold defaultstate="collapsed" desc="MATERIALS FOR STANDARD SHED">
        // BELOW IS MATERIALS USED FOR THE SIMPLE ALGORITHM
        // KEEP THIS FOR THE BUTTON NAMED "Standard Redskabsrum" AS SHOWN IN VIDEO
        // So if you check the box called "standard redskabsrum" simply use this list of materials.
        /* Screws and misc. */
        MaterialModel stalddørsgreb = new MaterialModel(75, "Stalddørsgreb", "Stalddørsgreb 50x75", 1, 0, 0);
        stalddørsgreb.setHelptext("til dør i skur");
        stalddørsgreb.setQuantity(1);
        stalddørsgreb.setUnit("sæt");
        stalddørsgreb.setPrice(10);
        bom.addMaterial(stalddørsgreb);

        MaterialModel thængsel = new MaterialModel(390, "T-hængsel", "T-Hængsel 390 mm.", 1, 0, 0);
        thængsel.setHelptext("til dør i skur");
        thængsel.setQuantity(2);
        thængsel.setUnit("Stk.");
        thængsel.setPrice(10);
        bom.addMaterial(thængsel);

        MaterialModel skruer70 = new MaterialModel(70, "Skruer70", "4,5 x 70 mm. Skruer 200 stk.", 1, 0, 0);
        skruer70.setHelptext("til montering af yderste bræt ved beklædning");
        skruer70.setQuantity(3);
        skruer70.setUnit("Pk.");
        skruer70.setPrice(10);
        bom.addMaterial(skruer70);

        MaterialModel skruer50 = new MaterialModel(50, "Skruer50", "4,5 x 50 mm. Skruer 350 stk.", 1, 0, 0);
        skruer50.setHelptext("til montering af yderste bræt ved beklædning");
        skruer50.setQuantity(2);
        skruer50.setUnit("Pk.");
        skruer50.setPrice(10);
        bom.addMaterial(skruer50);

        /* Wood */
        MaterialModel bræt210 = new MaterialModel(210, "bræt", "19x100 mm. trykimp. Bræt", 100, 2100, 19);
        bræt210.setHelptext("Beklædning af skur 1 på 2");
        bræt210.setQuantity(148);
        bræt210.setUnit("Stk.");
        bræt210.setPrice(100);
        bom.addMaterial(bræt210);

        MaterialModel løsholt360 = new MaterialModel(360, "løsholt", "45x95 Reglar ubh.", 95, 3600, 45);
        løsholt360.setHelptext("Løsholter i gavle af skur");
        løsholt360.setQuantity(6);
        løsholt360.setUnit("Stk.");
        løsholt360.setPrice(123);
        bom.addMaterial(løsholt360);

        MaterialModel løsholt240 = new MaterialModel(240, "løsholt", "45x95 Reglar ubh.", 95, 2400, 45);
        løsholt240.setHelptext("Løsholter i siderne af skur");
        løsholt240.setQuantity(4);
        løsholt240.setUnit("Stk.");
        løsholt240.setPrice(112);
        bom.addMaterial(løsholt240);
        //</editor-fold>
    }

    /**
     * Adds materials to the Partslist for the floor, if selected.
     *
     * @param floor MaterialModel
     * @param length of the Shed.
     * @param width of the Shed.
     * @return PartslistModel
     */
    private void addFloor(PartslistModel bom, MaterialModel floor, int length, int width)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds always needed materials to the Partslist. Materials for the door,
     * etc. 2 vandrette stivere 38x73 2 lag beklædningsbrædder skråstiver lægte
     * dørgreb - stalddørsgreb - #17 material hængsler skruer til alt dette
     *
     * @param wood type of wood selected for the shed.
     * @return PartslistModel
     */
    private void addDoorMaterials(PartslistModel bom, MaterialModel wood, DataFacade db) throws LoginException
    {
        bom.addMaterial(db.getMaterial(17)); // Stalddørsgreb for the door.
    }

    /**
     * Materials for the rest. 12 brædder per 30cm. 9 skruer per bræt. 3x
     * 4,5x50mm og 6x 4,5x70mm. 1 løsholt 20 cm over jorden. 1 løsholt 110 cm
     * over jorden. 1 for hver anden stolpe. 45x95 1 ekstra løsholt i enderne,
     * fordi den øverste i sidderne er remmene løsholter monteres i vinkelbeslag
     * 4 beslagsskruer per beslagsflade.
     *
     * @param bom
     * @param wood
     * @param length
     * @param width
     */
    private void addMaterials(PartslistModel bom, MaterialModel wood, int length, int width, DataFacade db) throws LoginException
    {
        // Trykimp brædder til beklædning:
        int amountofwood = (12 * ((length / 300) + (width / 300))) * 2; // Two length sides and two width sides.
        wood.setQuantity(amountofwood);
        bom.addMaterial(wood);

        // Amount of Skruer 4,5x50mm used for beklædningsbrædder.
        int amountofskruer50 = 3 * amountofwood;
        MaterialModel skruer50 = db.getMaterial(27); // 300 in one pack.
        int restskruer = amountofskruer50 % 300;
        int amountofpacks = amountofskruer50 / 300;
        if (restskruer > 0)
        {
            amountofpacks++;
        }
        skruer50.setQuantity(amountofpacks);

        // Amount of Skruer 4,5x70mm used for beklædningsbrædder.
        int amountofskruer70 = 6 * amountofwood;
        MaterialModel skruer70 = db.getMaterial(26); // 300 in one pack.
        restskruer = amountofskruer70 % 400;
        amountofpacks = amountofskruer70 / 400;
        if (restskruer > 0)
        {
            amountofpacks++;
        }
        skruer70.setQuantity(amountofpacks);
        
        
        
    }
}