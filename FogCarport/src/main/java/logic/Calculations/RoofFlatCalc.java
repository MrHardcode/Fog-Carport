package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;

/**
 * This class handles materials needed for a flat roof on the carport.
 *
 * It is meant to return a PartslistModel with the items, which are then
 * appended to the 'master list' ("bill of materials").
 *
 * @see PartslistModel
 *
 * @author
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
 * !Roof parts have a 2 'wave' overlay (20cm) & 12 screws per cm^2.
 *
 * Tagpap roofing: Size dependant calculation
 *
 * Lægter: To be determined
 *
 *
 */
public class RoofFlatCalc
{

    /* Rules */
    private int plasticRoofExtensionStandard = 50; //5cm extension beyond carport length
    private int plasticRoofOverlapStandard = 200; //20cm overlap between two tiles
    private int plastictileScrewsStandard = 12;
    private int rafterWidthStandard = 500; //1 rafter per 500mm (50cm)
    private int rafterFittingsStandard = 2; //2 fittings per rafter
    private int rafterFittingScrewStandard = 9;


    /* database material IDs (height|width|length)*/
    private int plasticTileSmallID = 29; //0x109x3600
    private int plasticTileLargeID = 28; //0x109x6000
    private int plastictileScrew = 22; //200 pcs. a pack
    private int bandScrewsID = 21; //250 pcs. a pack
    private int bandID = 23; //0x0x10000
    private int fittingScrewsID = 21; //250 pcs. a pack
    private int fittingLeftID = 16;
    private int fittingRightID = 15;
    private int rafterSmallID = 5; // 45x195x4800
    private int rafterLargeID = 54; //45x195x6000
    private int fasciaWidthBottomID = 55; //25x200x3600
    private int fasciaLengthBottomID = 56; //25x200x5400
    private int fasciaWidthTopID = 57; //25x125x3600
    private int fasciaLengthTopID = 58; //25x125x5400
    private int bargeboardScrewsID = 20; //200 a pack

    /* Calculations */
    private int amountOfScrews; //total amount of screws needed

    /* Imports */
    private final DataFacade DAO; //data accessor

    public RoofFlatCalc()
    {
        amountOfScrews = 0;
        this.DAO = DataFacadeImpl.getInstance();
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
        PartslistModel roofMaterials = new PartslistModel(); //items to be returned to master list
        /* calculate always needed (independent) items */
        roofMaterials.addPartslist(calculateMainParts(order));
        /* calculate items based on type of roof tile */
        roofMaterials.addPartslist(calculateDependantParts(order));

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
        PartslistModel mainMaterials = new PartslistModel();

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
        mainMaterials.addPartslist(rafters);
        mainMaterials.addPartslist(fascias);
        mainMaterials.addPartslist(bargeboards);
        mainMaterials.addPartslist(bands);
        mainMaterials.addPartslist(fittings);

        return mainMaterials;
    }

    /**
     * Adds parts that depends on the roof of choice
     *
     * @param order
     * @return
     * @throws data.exceptions.AlgorithmException
     */
    protected PartslistModel calculateDependantParts(OrderModel order) throws AlgorithmException, LoginException
    {
        PartslistModel dependantParts = new PartslistModel();

        int roofSelection = order.getRoof_tiles_id();
        //the ID selected for roof tiles. 
        //0 = no roof/no choice. || 28,* 29 = plastic. 47, 48 = felt ("tagpap").

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
     *
     * @return
     */
    private PartslistModel calculatePlasticRoof(OrderModel order) throws LoginException
    {
        /* Set up return <model>*/
        PartslistModel plasticRoof = new PartslistModel();

        /* Get MaterialModel to return */

 /* Calculation begin */

 /* Update quantities */

 /* Update price */

 /* Update helptext */

 /* Add to <model> */
        plasticRoof.addPartslist(calculatePlasticTiles(order));

        /* Return <model>*/
        return plasticRoof;
    }

    /**
     * calculates materials needed for the flat felt roof.
     *
     * @param order
     * @return
     */
    private PartslistModel calculateFeltRoof(OrderModel order)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * calculates rafter ("spær") for carport roof
     *
     * we only care about width, then the customer customizes the rafter to
     * their liking.
     *
     * @param order order in question
     * @return returns partlistmodel of items needed
     */
    private PartslistModel calculateRafters(OrderModel order) throws LoginException
    {
        /* Set up return <model>*/
        PartslistModel rafters = new PartslistModel();
        /* Get MaterialModel to return */
        MaterialModel rafter = DAO.getMaterial(rafterLargeID); //45x195x6000

        /* Set up variables */
        int width = order.getWidth();

        /* Calculation begin */
        int rafterAmount = (width / rafterWidthStandard); //one rafter per 500mm
        int rafterRemainder = (width % rafterWidthStandard);
        while (rafterRemainder > 0)
        {
            rafterAmount++;
            rafterRemainder--;
        }

        /* Update quantities */
        rafter.setQuantity(rafterAmount);

        /* Update price */
        rafter.setPrice(rafter.getQuantity() * rafter.getPrice());

        /* Update helptext */
        rafter.setHelptext("Spær, monteres på rem");

        /* Add to <partslistmodel> */
        rafters.addMaterial(rafter);

        /* Return <partslistmodel>*/
        return rafters;
    }

    /**
     * calculates fascia ("stern") for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateFascias(OrderModel order) throws LoginException
    {
        /* Set up return PartslistModel */
        PartslistModel fascias = new PartslistModel();

        /* Initialize materials needed needed */
        MaterialModel fasciaLengthBottom = DAO.getMaterial(fasciaLengthBottomID);
        MaterialModel fasciaLengthTop = DAO.getMaterial(fasciaLengthTopID);
        MaterialModel fasciaWidthBottom = DAO.getMaterial(fasciaWidthBottomID);
        MaterialModel fasciaWidthTop = DAO.getMaterial(fasciaWidthTopID);

        /* set up variables */
        int width = order.getWidth();
        int length = order.getLength();

        /* Begin calculation, update quantities */
        fasciaLengthBottom = fasciaHelper(fasciaLengthBottom, length);
        fasciaLengthTop = fasciaHelper(fasciaLengthTop, length);
        fasciaWidthBottom = fasciaHelper(fasciaWidthBottom, width);
        fasciaWidthTop = fasciaHelper(fasciaWidthTop, width);

        //We have now calculated the quantity needed by length, but need to multiply by carport sides.
        //
        /* Update quantity */
        fasciaLengthBottom.setQuantity(fasciaLengthBottom.getQuantity() * 2); //2 lengths
        fasciaLengthTop.setQuantity(fasciaLengthTop.getQuantity() * 2); //2 lengths
        fasciaWidthBottom.setQuantity(fasciaWidthBottom.getQuantity() * 2); //2 widths
        //fasciaWidthTop is not updated, as we only add top fascia to the front, not the back. (due to water draining)

        /* Set helptext */
        fasciaLengthBottom.setHelptext("understernbrædder til siderne");
        fasciaLengthTop.setHelptext("oversternbrædder til siderne");
        fasciaWidthBottom.setHelptext("understernbrædder til for- & bagende");
        fasciaWidthTop.setHelptext("oversternbrædder til forenden");
        /* Add parts together */
        fascias.addMaterial(fasciaLengthBottom);
        fascias.addMaterial(fasciaLengthTop);
        fascias.addMaterial(fasciaWidthBottom);
        fascias.addMaterial(fasciaWidthTop);
        /* Update prices */
        fascias.getBillOfMaterials().forEach((material) ->
        {
            material.setPrice(material.getPrice() * material.getQuantity());
        });

        /* return partslist */
        return fascias;
    }

    private MaterialModel fasciaHelper(MaterialModel fascia, int dimension)
    {
        int fasciaQty = fascia.getQuantity();
        int remainingDimension = dimension;

        /* Calculate quantity */
        while (remainingDimension > 0)
        {
            fasciaQty++;
            remainingDimension -= fascia.getLength();
        }

        /* Update quantity */
        fascia.setQuantity(fasciaQty);

        /* return fascia */
        return fascia;
    }

    
    /**
     * calculates bargeboard ("vandbrædt") for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateBargeboard(OrderModel order)
    {
        /* Set up return <model>*/
        PartslistModel bargeboards = new PartslistModel();


        /* Get MaterialModel to return */
        

 /* Calculation begin */

 /* Update quantities */

 /* Update price */

 /* Update helptext */

 /* Add to <model> */

 /* Return <model>*/
        return bargeboards;
    }

    /**
     * calculate universalbeslag & screws for carport roof
     *
     * @param rafterAmount amount of rafters needed. calculated in earlier
     * method.
     * @return returns a list of materials (to later add to bill of materials)
     */
    private PartslistModel calculateFittings(PartslistModel rafters) throws LoginException
    {
        /* Rafter amount */
        int rafterAmount = rafters.getBillOfMaterials().get(0).getQuantity(); //hackish solution. update?

        /*PartsListModel to return */
        PartslistModel fittingsAndScrews = new PartslistModel();

        /* Get standards */
        int fittingStandard = this.rafterFittingsStandard; //2
        int screwStandard = this.rafterFittingScrewStandard; //9

        /* Calculation begin */
        int fittingsAmount = (rafterAmount * fittingStandard); //2 fittings per rafter
        //int screwAmount = (fittingsAmount*screwStandard); //9 screws per fitting

        /* Get materials from database */
        MaterialModel fittingRight = DAO.getMaterial(fittingRightID);
        MaterialModel fittingLeft = DAO.getMaterial(fittingLeftID);
        MaterialModel fittingScrews = DAO.getMaterial(fittingScrewsID);
        //amountOfScrews += (fittingsAmount * screwAmount);

        /* update quantities */
        fittingRight.setQuantity(fittingsAmount);
        fittingLeft.setQuantity(fittingsAmount);
        fittingScrews.setQuantity(1); //1 pack is 250
        //setScrewQty 

        /* update price */
        fittingRight.setPrice((fittingRight.getPrice() * fittingRight.getQuantity()));
        fittingLeft.setPrice((fittingLeft.getPrice() * fittingLeft.getQuantity()));
        //setScrewPrice 

        /* Update helptext */
        //fittingRight.setHelptext(helptext.get(fittingRight));
        //fittingLeft.setHelptext(helptext.get(fittingLeft));
        fittingRight.setHelptext("Til montering	af spær	på rem");
        fittingLeft.setHelptext("Til montering	af spær	på rem");
        fittingScrews.setHelptext("Til montering af universalbeslag + hulbånd");


        /* Add to PartsListModel */
        fittingsAndScrews.addMaterial(fittingRight);
        fittingsAndScrews.addMaterial(fittingLeft);
        fittingsAndScrews.addMaterial(fittingScrews);
        //addScrews 

        /* Return PartsListModel */
        return fittingsAndScrews;
    }

    /**
     * calculate hulbånd for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateBand(OrderModel order) throws LoginException
    {
        PartslistModel bandParts = new PartslistModel();
        int bandAmount = 1; //used to determine band quantity. we always want one.

        /*get MaterialModel to return */
        MaterialModel band = DAO.getMaterial(bandID);
        MaterialModel bandScrews = DAO.getMaterial(bandScrewsID);

        /* Calculation begin */
        int bandLength = band.getLength(); //10000mm (10m)
        int shedLength = order.getShed_length();
        int carportLength = order.getLength();

        //band runs from shed to front
        int bandCoverLength = (carportLength - shedLength); //band does not cover shed

        int bandEffectiveLength = bandCoverLength * 2; //we need to cover diagonally (two lengths)

        bandEffectiveLength -= bandLength; //we start at one, so lets remove bandLength from calculation.
        while (bandEffectiveLength >= 0) //old version: (bandEffectiveLength - bandLength >= 0)
        {
            ++bandAmount;
            bandEffectiveLength -= bandLength;
        }

        /* update quantities */
        band.setQuantity(bandAmount);
        bandScrews.setQuantity(1); // 250 a package
        //screws too (2 pr. spær crossed)

        /* update price */
        band.setPrice(band.getQuantity() * band.getPrice());
        /* Update helptext */
        band.setHelptext("Til vindkryds på spær");
        bandScrews.setHelptext("Til montering af universalbeslag + hulbånd");
        /* add to PartslistModel */
        bandParts.addMaterial(band);
        bandParts.addMaterial(bandScrews);

        /* Return PartslistModel */
        return bandParts;

    }

    /**
     * Calculates roof tiles (plastic) for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculatePlasticTiles(OrderModel order) throws LoginException
    {
        /* Set up return <partslistmodel>*/
        PartslistModel tileAndTileAccessories = new PartslistModel();

        /* Get MaterialModel to return */
        MaterialModel tileLarge = DAO.getMaterial(plasticTileLargeID); //109x6000
        MaterialModel tileSmall = DAO.getMaterial(plasticTileSmallID); //109x3600
        MaterialModel tileScrews = DAO.getMaterial(plastictileScrew);
        /* Set up variables */
        int remainingLength = order.getLength();
        //take into account that we need a 5cm extension per width for water drainage.
        int remainingWidth = (order.getWidth()) + (plasticRoofExtensionStandard * 2); //50mm (5cm) for 2 sides of the carport = 100mm (10cm) extra width for the whole carport.
        //take into account that we need a 2cm overlap between two tiles
        int tileLargeLength = (tileLarge.getLength()) - plasticRoofOverlapStandard; //-200mm for overlap
        int tileSmallLength = (tileSmall.getLength()) - plasticRoofOverlapStandard; //-200mm for overlap

        int largeQty = 0;
        int smallQty = 0;
        /* Calculation begin */

//        int largeQty = (remainingLength/tileLargeLength);
//        int smallQty = (int) Math.ceil((remainingLength%tileLargeLength) / tileSmallLength);
        while (remainingLength > 0 || remainingWidth > 0)
        {
            /* Add large tiles */
            while (remainingLength > tileLarge.getLength())
            {
                largeQty++;
                remainingLength -= tileLargeLength;
                remainingWidth -= tileLarge.getWidth();
            }
            /* Add small tiles */
            while (remainingLength > tileSmall.getLength())
            {
                smallQty++;
                remainingLength -= tileSmall.getLength();
                remainingWidth -= tileSmall.getWidth();
            }

            //last case where dimensions are bigger than 0, but smaller than tile.
            if (remainingLength > 0
                    && remainingLength < tileSmall.getLength()
                    || remainingWidth > 0
                    && remainingWidth < tileSmall.getWidth())
            {
                smallQty++;
                remainingLength -= tileSmall.getLength();
                remainingWidth -= tileSmall.getWidth();
            }

        }

        /* Update quantities */
        tileLarge.setQuantity(largeQty);
        tileSmall.setQuantity(smallQty);
        //need to update screws too (see rules)
        tileScrews.setQuantity(3);

        /* Update price */
        tileLarge.setPrice(tileLarge.getQuantity() * tileLarge.getPrice());
        tileSmall.setPrice(tileSmall.getQuantity() * tileSmall.getPrice());
        tileScrews.setPrice(tileScrews.getQuantity() * tileScrews.getPrice());

        /* Update helptext */
        tileLarge.setHelptext("tagplader monteres på spær");
        tileSmall.setHelptext("tagplader monteres på spær");
        tileScrews.setHelptext("Skruer til tagplader");
        /* Add to <partslistmodel> */
        tileAndTileAccessories.addMaterial(tileLarge);
        tileAndTileAccessories.addMaterial(tileSmall);
        tileAndTileAccessories.addMaterial(tileScrews);

        /* Return <partslistmodel>*/
        return tileAndTileAccessories;
    }

    /**
     * Calculates roof tiles (felt) ("tagpap") for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateFeltTiles(OrderModel order)
    {
        return null;
    }

}
