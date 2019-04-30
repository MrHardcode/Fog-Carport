package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.AlgorithmException;
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
 * Hulbånd: 1x (10m)
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

    private HashMap<String, Integer> rules;

    private static RoofFlatCalc instance = null;

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
        this.rules = new HashMap<>();
        rules.put("rafterFittings", 2); //2 fittings per rafter
        rules.put("fittingScrews", 9);
    }

    /**
     * Master calculation; takes use of other methods to calculate all the parts
     * needed for a flat roof.
     *
     * @param order
     * @return
     * @throws data.exceptions.AlgorithmException
     */
    public PartslistModel calculateFlatRoofStructure(OrderModel order) throws AlgorithmException
    {

        roofMaterials.addPartslist(calculateMainParts(order));
        roofMaterials.addPartslist(calculateDependantParts(order, order.getRoof_tiles_id()));
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
     */
    protected PartslistModel calculateMainParts(OrderModel order)
    {
        PartslistModel woodMaterials = new PartslistModel();
        
        return woodMaterials;

    }

    /**
     * Adds parts that depends on the roof of choice
     *
     * @param order
     * @param roofSelection the ID selected for roof tiles. 0 = no roof. || 28,
     * 29 = plastic. Other = felt ("tagpap").
     * @return
     */
    protected PartslistModel calculateDependantParts(OrderModel order, int roofSelection) throws AlgorithmException
    {
        PartslistModel dependantParts = new PartslistModel();
        switch (roofSelection) //could also be done with multiple if-statements
        {
            //plastic roof
            case 28:
            case 29:

                break;
            //felt roof
            case 47:
            case 48:
                break;
            default:
                throw new AlgorithmException(1, "Error #1: No suitable roof ID selected");
        }
        return dependantParts;
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
    private int calculateRafters(OrderModel order)
    {

    }

    /**
     * calculates fascia ("stern") for carport roof
     *
     * @param order
     * @return
     */
    private int calculateFascias(OrderModel order)
    {

    }

    /**
     * calculates bargeboard ("vandbrædt") for carport roof
     *
     * @param order
     * @return
     */
    private int calculateBargeboard(OrderModel order)
    {

    }

    /**
     * calculate universalbeslag for carport roof
     *
     * @param rafterAmount
     * @return
     */
    private int calculateFittings(int rafterAmount)
    {

    }

    /**
     * calculate hulbånd for carport roof
     *
     * @param order
     * @return
     */
    private int calculateBand(OrderModel order)
    {

    }

    /**
     * Calculates roof tiles (plastic) for carport roof
     *
     * @param order
     * @return
     */
    private int calculatePlasticTiles(OrderModel order)
    {

    }

    /**
     * Calculates roof tiles (felt) ("tagpap") for carport roof
     *
     * @param order
     * @return
     */
    private int calculateFeltTiles(OrderModel order)
    {

    }

}
