package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.HashMap;

/**
 * This class handles materials needed for a flat roof on the carport.
 *
 * It is meant to return a PartslistModel with the items, which are then
 * appended to the 'master list' ("bill of materials").
 *
 * @see PartslistModel
 *
 * @author Runi
 *
 * Material used for creation:
 * https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CP01_DUR.pdf
 *
 * Material rules:
 *
 * Spær: Every 50cm
 *
 * Stern: 8x (two per building side: one under, one over)
 *
 *
 * Vandbrædt: 3x (size: 19x100. 1x front, 1x each side)
 *
 * Universalbeslag: 2x per spær. (Remember: Right/Left orientation) (9 screws
 * per beslag)
 *
 * Hulbånd: 1x (10m). 2 screws pr. spær
 *
 * !Plastic roofing:
 *
 * !Outermost parts must extend 5cm beyond its Spær to account for water.
 *
 * !Roof parts have a 2 'wave' overlay (10cm?) 12 screws per cm^2.
 *
 * Tagpap roofing: Size dependant calculation
 *
 * Lægter: To be determined
 *
 *
 */
public class RoofFlatCalc
{

    private int amountOfScrews; //total amount of screws needed
    private DataFacade DAO; //data accessor
    private PartslistModel roofMaterials; //items to be returned to master list
    Rules rules;
    Helptext helptext;
//    private static RoofFlatCalc instance = null;
//    /**
//     * Singleton pattern
//     *
//     * @return returns a new RoofFlatCalc or the current one. (if available)
//     */
//    public synchronized static RoofFlatCalc getInstance()
//    {
//        if (instance == null)
//        {
//            instance = new RoofFlatCalc();
//        }
//        return instance;
//    }
//    /**
//     * Testing constructor
//     * @param dataF
//     * @param roofMaterials
//     * @param rules 
//     */
//    public RoofFlatCalc(DataFacade dataF, PartslistModel roofMaterials, HashMap<String, Integer> rules)
//    {
//        this.amountOfScrews = 0;
//        this.dataF = dataF;
//        this.roofMaterials = roofMaterials;
//        this.rules = rules;
//    }

    public RoofFlatCalc()
    {
        amountOfScrews = 0;
        this.DAO = DataFacadeImpl.getInstance();
        this.roofMaterials = new PartslistModel();
        rules = new Rules();
        helptext = new Helptext();
    }

    /**
     * Master calculation; takes use of other methods to calculate all the parts
     * needed for a flat roof.
     *
     * @param order
     * @return
     * @throws data.exceptions.AlgorithmException
     * @throws data.exceptions.LoginException
     */
    public PartslistModel calculateFlatRoofStructure(OrderModel order) throws AlgorithmException, LoginException
    {
        /* calculate always needed (independent) items */
        roofMaterials.addPartslist(calculateMainParts(order));
        /* calculate items based on type of roof tile */
        roofMaterials.addPartslist(calculateDependantParts(order, order.getRoof_tiles_id()));
        /* calculate other */
        roofMaterials.addPartslist(calculateMiscellaneous(order));

        return roofMaterials;
    }

    /**
     *
     * Calculates main parts that are generally always needed for the flat roof
     * part of the construction.
     *
     * @param order order in question
     *
     * @return
     * @throws data.exceptions.LoginException
     */
    protected PartslistModel calculateMainParts(OrderModel order) throws LoginException
    {
        PartslistModel woodMaterials = new PartslistModel();

        /* Get materials */
        //MaterialModel bargeboards = DAO.getMaterial(54); //update id
        //MaterialModel bands = DAO.getMaterial(54); //update id
        /* set helptext */
 /* Calculate amount of materials needed */
        PartslistModel rafters = calculateRafters(order);
        PartslistModel fascias = calculateFascias(order);
        PartslistModel bargeboards = calculateBargeboard(order);
        PartslistModel bands = calculateBand(order);
        PartslistModel fittings = calculateFittings(rafters);

        /* update quantities */
        // rafters.setQuantity(rafters);
        //fascias.setQuantity(fascias);
        // bargeboards.setQuantity(bargeboards);
        // bands.setQuantity(bands);
        // fittings.setQuantity(fittings);
        /* Add material*/
        woodMaterials.addPartslist(rafters);

        return woodMaterials;

    }

    /**
     * Adds parts that depends on the roof of choice
     *
     * @param order
     * @param roofSelection the ID selected for roof tiles. 0 = no roof. || 28,
     * 29 = plastic. Other = felt ("tagpap").
     * @return
     * @throws data.exceptions.AlgorithmException
     */
    protected PartslistModel calculateDependantParts(OrderModel order, int roofSelection) throws AlgorithmException
    {
        PartslistModel dependantParts = new PartslistModel();
        switch (roofSelection) //could also be done with multiple if-statements
        {
            //plastic roof
            case 28:
            case 29:
                dependantParts.addPartslist(calculatePlasticRoof(order));

                break;
            //felt roof
            case 47:
            case 48:
                dependantParts.addPartslist(calculateFeltRoof(order));
                break;
            default:
                throw new AlgorithmException(1, "Error #1: No suitable roof ID selected");
        }
        return dependantParts;
    }
    
    /**
     * Calculates materials needed for the flat plastic roof
     * @return 
     */
    private PartslistModel calculatePlasticRoof(OrderModel order)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * calculates materials needed for the flat felt roof.
     * @param order
     * @return 
     */
    private PartslistModel calculateFeltRoof(OrderModel order)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected PartslistModel calculateMiscellaneous(OrderModel order)
    {
        PartslistModel miscMaterials = new PartslistModel();

        return miscMaterials;
    }

    /**
     * calculates rafter ("spær") for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateRafters(OrderModel order) throws LoginException
    {
        MaterialModel rafters = DAO.getMaterial(54);

    }

    /**
     * calculates fascia ("stern") for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateFascias(OrderModel order) throws LoginException
    {
        /* set up variables */
        int width = order.getWidth();
        int length = order.getLength();
        int fasciaStandard = rules.get("fasciaStandard"); //2 fascia per side of the house

        /* get materials from DB */
        MaterialModel fascia360 = DAO.getMaterial(54);

        fascia360.getLength();

    }

    /**
     * calculates bargeboard ("vandbrædt") for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateBargeboard(OrderModel order)
    {

    }

    /**
     * calculate universalbeslag & screws for carport roof
     *
     * @param rafterAmount
     * @return
     */
    private PartslistModel calculateFittings(int rafterAmount) throws LoginException
    {
        /*PartsListModel to return */
        PartslistModel fittingsAndScrews = new PartslistModel();

        /* Get standards */
        int fittingStandard = rules.get("rafterFittings"); //2
        int screwStandard = rules.get("fittingScrews"); //9

        /* Calculation begin */
        int fittingsAmount = (rafterAmount * fittingStandard); //2 fittings per rafter
        int screwAmount = (fittingsAmount*screwStandard); //9 screws per fitting
        
        /* Get materials from database */
        MaterialModel fittingRight = DAO.getMaterial(15);
        MaterialModel fittingLeft = DAO.getMaterial(16);
        //amountOfScrews+=(fittingRight+fittingLeft)*screwAmount;
        getScrew or above

        /* update quantities */
        fittingRight.setQuantity(fittingsAmount);
        fittingLeft.setQuantity(fittingsAmount);
        setScrewQty

        /* update price */
        fittingRight.setPrice((fittingRight.getPrice() * fittingRight.getQuantity()));
        fittingLeft.setPrice((fittingLeft.getPrice() * fittingLeft.getQuantity()));
        setScrewPrice
                
        /* Update helptext */
        //fittingRight.setHelptext(helptext.get(fittingRight));
        //fittingLeft.setHelptext(helptext.get(fittingLeft));
        fittingRight.setHelptext("Til montering	af spær	på rem");
        fittingLeft.setHelptext("Til montering	af spær	på rem");


        /* Add to PartsListModel */
        fittingsAndScrews.addMaterial(fittingRight);
        fittingsAndScrews.addMaterial(fittingLeft);
        addScrews
        
        /* Return PartsListModel */
        return fittingsAndScrews;
    }

    /**
     * calculate hulbånd for carport roof
     *
     * @param order
     * @return
     */
    private MaterialModel calculateBand(OrderModel order) throws LoginException
    {
        /*get MaterialModel to return */
        MaterialModel band = DAO.getMaterial(23);

        /* Calculation begin */
        int bandLength = band.getLength(); //10000mm (10m)
        int shedLength = order.getShed_length(); //band runs from shed to front
        int carportLength = order.getLength();
        
        int bandCoverLength = (carportLength-shedLength);
        
        /* update quantities */
       
        //screws too (2 pr. spær)

        /* update price */
        
                
        /* Update helptext */
        
        


       
        
        /* Return materialModel */
        return band;
    }

    /**
     * Calculates roof tiles (plastic) for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculatePlasticTiles(OrderModel order)
    {

    }

    /**
     * Calculates roof tiles (felt) ("tagpap") for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateFeltTiles(OrderModel order)
    {

    }


    private static class Rules extends HashMap<String, Integer>
    {

        public Rules()
        {
            this.put("rafterLength", 500); //1 rafter per 500mm (50cm)
            this.put("fasciaStandard", 2); //2 boards per side (one lower, one upper) = 8 boards total.
            this.put("bargeStandard", 3); //1 board for every side except back. (due to carport tilt)
            this.put("rafterFittings", 2); //2 fittings per rafter
            this.put("fittingScrews", 9); // 9 screws per fitting

            this.put("PlasticTileExtend", 50); //plastic tiles extend 50mm (5cm) beyond the roof edge
            this.put("PlasticTileOverlap", 100); //Plastic tiles overlap eachother approximately 100mm (10cm)
            this.put("PlasticTileScrews", 12); //12 screws per cm^2

            /*this.put("band", 10); */ //hulbånd not necessary
        }
    }

    private class Helptext extends HashMap<MaterialModel, String>
    {

        public Helptext() throws LoginException
        {
            this.put(DAO.getMaterial(15), "whatup");
        }

    }

}
