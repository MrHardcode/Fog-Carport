package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
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
 * Tagpap roofing: To be determined
 *
 * Lægter: To be determined
 *
 *
 */
public class RoofFlatCalc
{

    private int amountOfScrews; //total amount of screws needed
    private DataFacade dataF; //data accessor
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
        this.dataF = DataFacadeImpl.getInstance();
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
     */
    PartslistModel calculateRoof(OrderModel order)
    {
        roofMaterials.addPartslist(calculateWood(order));
        roofMaterials.addPartslist(calculateMiscellaneous(order));

        return roofMaterials;
    }

    protected PartslistModel calculateWood(OrderModel order)
    {
        PartslistModel woodMaterials = new PartslistModel();

        return woodMaterials;

    }

    protected PartslistModel calculateMiscellaneous(OrderModel order)
    {
        PartslistModel miscMaterials = new PartslistModel();

        return miscMaterials;
    }

    private int calculateFittings(int rafterAmount)
    {

    }

}
