/*
 *  
 */
package logic;

import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;

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

    /*
    https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CAR01_HR.pdf
    Going off of this with regards to assumptions.
    Things to take into account: 
    Width of the shed
    Length of the shed
    Type of wood used for the sheds "beklædning"
    Type of wood used for the floor (if they even want a floor)
    */
    PartslistModel addShed(PartslistModel bom, OrderModel order)
    {
        boolean standard = false;
        if (standard == true) {
        // BELOW IS MATERIALS USED FOR THE SIMPLE ALGORITHM 
        // KEEP THIS FOR THE BUTTON NAMED "Standard Redskabsrum" AS SHOWN IN VIDEO
        //<editor-fold defaultstate="collapsed" desc="MATERIALS FOR STANDARD SHED">
        /* Screws and misc. */
        MaterialModel stalddørsgreb = new MaterialModel(75, "Stalddørsgreb", "Stalddørsgreb 50x75", 1, 0, 0);
        stalddørsgreb.setHelptext("til dør i skur");

        MaterialModel thængsel = new MaterialModel(390, "T-hængsel", "T-Hængsel 390 mm.", 1, 0, 0);
        thængsel.setHelptext("til dør i skur");

        MaterialModel skruer70 = new MaterialModel(70, "Skruer70", "4,5 x 70 mm. Skruer 200 stk.", 1, 0, 0);
        skruer70.setHelptext("til montering af yderste bræt ved beklædning");

        MaterialModel skruer50 = new MaterialModel(50, "Skruer50", "4,5 x 50 mm. Skruer 350 stk.", 1, 0, 0);
        skruer50.setHelptext("til montering af yderste bræt ved beklædning");

        /* Wood */
        MaterialModel bræt210 = new MaterialModel(210, "bræt", "19x100 mm. trykimp. Bræt", 100, 2100, 19);
        bræt210.setHelptext("Beklædning af skur 1 på 2");

        MaterialModel løsholt360 = new MaterialModel(360, "løsholt", "45x95 Reglar ubh.", 95, 3600, 45);
        løsholt360.setHelptext("Løsholter i gavle af skur");

        MaterialModel løsholt240 = new MaterialModel(240, "løsholt", "45x95 Reglar ubh.", 95, 2400, 45);
        løsholt240.setHelptext("Løsholter i siderne af skur");
        //</editor-fold>
        } else {
        // width and length in mm currently. 
        // In video the steps are 0.9, 1.2, 1.5, 1.8, 2.1, 2.4, 2.7, 3.0, 3.3, 3.6 in meters
        // VARIABLES IF NOT STANDARD SHED:
        // Should be replaced with variables based on user input.
        int width = 2400;
        int length = 2400; 
        MaterialModel wood = new MaterialModel(); // replace with something like order.getShedWood();
        // IF FLOOR IS CHOSEN:
        /* if (order.getShedFloor() != null){
            MaterialModel floor = new MaterialModel(); // replace with something like order.getShedFloor();
            // ADD X AMOUNT OF FLOOR DEPENDING ON WIDTH AND LENGTH HERE TO BOM
        } */
        
        }
        
        return bom;
    }
}
