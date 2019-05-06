package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;
import java.util.Collections;
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
    private int plasticRoofOverlapStanard = 200; //20cm overlap between two tiles
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
    private int fasciaBottomSmall = 55; //25x200x3600
    private int fasciaBottomLarge = 56; //25x200x5400
    private int fasciaTopSmall = 57; //25x125x3600
    private int fasciaTopLarge = 58; //25x125x5400

    /* Calculations */
    private int amountOfScrews; //total amount of screws needed

    /* Imports */
    private DataFacade DAO; //data accessor
    private PartslistModel roofMaterials; //items to be returned to master list

    public RoofFlatCalc()
    {
        amountOfScrews = 0;
        this.DAO = DataFacadeImpl.getInstance();
        this.roofMaterials = new PartslistModel();
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
        woodMaterials.addPartslist(fascias);
        woodMaterials.addPartslist(bargeboards);
        woodMaterials.addPartslist(bands);
        woodMaterials.addPartslist(fittings);

        return woodMaterials;

    }

    /**
     * Adds parts that depends on the roof of choice
     *
     * @param order
     * @return
     * @throws data.exceptions.AlgorithmException
     */
    protected PartslistModel calculateDependantParts(OrderModel order) throws AlgorithmException
    {
        PartslistModel dependantParts = new PartslistModel();

        int roofSelection = order.getRoof_tiles_id();
        //the ID selected for roof tiles. 
        //0 = no roof/no choice. || 28,* 29 = plastic. Other = felt ("tagpap").

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
    private PartslistModel calculatePlasticRoof(OrderModel order)
    {
        /* Set up return <model>*/
        PartslistModel plasticRoof = new PartslistModel();

        /* Get MaterialModel to return */

 /* Calculation begin */

 /* Update quantities */

 /* Update price */

 /* Update helptext */

 /* Add to <model> */

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
     * @param order order in question
     * @return returns partlistmodel of items needed
     */
    private PartslistModel calculateRafters(OrderModel order) throws LoginException
    {
        /* Set up return <model>*/
        PartslistModel rafters = new PartslistModel();
        /* Get MaterialModel to return */
        MaterialModel rafter = DAO.getMaterial(54);
        /* Calculation begin */

 /* Update quantities */

 /* Update price */

 /* Update helptext */

 /* Add to <model> */

 /* Return <model>*/
        return null;
    }

    /**
     * calculates fascia ("stern") for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateFascias(OrderModel order) throws LoginException
    {
        /* Initialize partslists needed */
        PartslistModel fasciasLengthTop = new PartslistModel(); //carport length top board
        //PartslistModel fasciasLengthBottom = new PartslistModel(); //carport length bottom board
        PartslistModel fasciasWidthTop = new PartslistModel(); //carport width top board
        //PartslistModel fasciasWidthBottom = new PartslistModel(); //carport width bottom board

        /* Add needed materials */
        fasciasLengthTop.addMaterial(DAO.getMaterial(56)); //25x200x5400
        fasciasLengthTop.addMaterial(DAO.getMaterial(58)); //25x125x5400 
        fasciasWidthTop.addMaterial(DAO.getMaterial(55)); //25x200x3600
        fasciasWidthTop.addMaterial(DAO.getMaterial(57)); //25x125x3600

        /* Begin calculation */
        itemHelper(fasciasLengthTop, order.getWidth());
        itemHelper(fasciasWidthTop, order.getLength());

//////        /* set up variables */
//////        int width = order.getWidth();
//////        int length = order.getLength();
//////
//////        /* Begin calculation, add to partslist */
//////        fasciaHelper(fascias, length);
//////        fasciaHelper(fascias, width);

        /* Add parts together */
        fasciasWidthTop.addPartslist(fasciasLengthTop);

        /* return partslist */
        return fasciasWidthTop;
    }

    /**
     * Helps calculating amount of Fascias depending on material length and
     * remaining length.
     *
     * @param remainingLength
     * @return
     * @throws LoginException
     */
    private PartslistModel fasciaHelper(PartslistModel fascias, int remainingLength) throws LoginException
    {
        //PartslistModel fascias = new PartslistModel(); //needs to initialize
        MaterialModel fascia = null;

        while (remainingLength > 0)
        {
            if (remainingLength < 4800) //would have been nice to use MaterialModel.getLength but then we would have to load it from db.
            {
                fascia = DAO.getMaterial(1); //length 4800
            }
            else if (remainingLength > 4800 && remainingLength < 5400)
            {
                fascia = DAO.getMaterial(2); //length 5400
            }
            else if (remainingLength > 5400)
            {
                fascia = DAO.getMaterial(3); //length 6000
            }

            if (fascia != null)
            {
                int qty = materialCalculateAmount(fascia, remainingLength);
                int fasciaStandard = rules.get("fasciaStandard"); //2 fascia per side of the house
                qty = (qty) * (fasciaStandard) * (2); //qty * 2 boards * 2 sides per carport
                fascia.setQuantity(qty);
                int lengthDifference = (remainingLength) - (fascia.getLength() * qty);
                remainingLength -= lengthDifference;
                fascias.addMaterial(fascia);
                fasciaHelper(fascias, remainingLength); //recursion
            }
        }
        return fascias;

//        while (remainingLength > fasciaLength) // || remainingLength > 0
//        {
//            amountOfFascia++;
//            remainingLength -= fasciaLength;
//        }
//
//        return amountOfFascia;
    }

    private PartslistModel itemHelper(PartslistModel items, int remainingLength) throws LoginException
    {
        /* sort collection of MaterialModels */
        ArrayList<MaterialModel> bom = items.getBillOfMaterials();
        bom.sort((m1, m2) ->
        {
            return m1.getLength() - m2.getLength(); //sort ascending
        });
        Collections.reverse(bom); //reverse to descending

        while (remainingLength > 0) //while the remaining length is bigger than 0
        {
            items.addPartslist(calculateMaterialAmount(items, remainingLength));
            //items.getBillOfMaterials().replaceAll((UnaryOperator<MaterialModel>) items.getBillOfMaterials());
            remainingLength -= items.getTotalLength();
        }
        return items;
    }

    private PartslistModel calculateMaterialAmount(PartslistModel items, int remainingLength)
    {
        ArrayList<MaterialModel> bom = items.getBillOfMaterials();

        while (remainingLength > 0)
        {
            /* The idea is here that we run through the materials from largest to smallest and add as needed */
            for (MaterialModel material : bom)
            {
                //if the remaining length is smaller than the smallest item
                //add one of smallest item
                //This is to avoid an endless loop and to end both this and 
                if (remainingLength < bom.get(bom.size() - 1).getLength())
                {
                    MaterialModel smallestItem = (bom.get(bom.size() - 1));
                    smallestItem.setQuantity(smallestItem.getQuantity() + 1);
                    remainingLength -= material.getLength();
                }
                if (remainingLength >= material.getLength())
                {
                    /* Continuously add item qty until remainingLength is lower than item length  */
                    while (remainingLength >= material.getLength())
                    {
                        int qty = material.getQuantity();
                        qty++;
                        material.setQuantity(qty);
                        remainingLength -= material.getLength();
                    }
                }
            }
        }
        return items;
    }

    /**
     * Calculates amount of the specific material needed to reach optimal
     * size/price usage.
     *
     * @param item item in question (MaterialModel)
     * @param remainingLength length needed to calculate
     * @return
     */
    private int materialCalculateAmount(MaterialModel item, int remainingLength)
    {
        int itemLength = item.getLength();
        int itemQty = item.getQuantity();

        while (remainingLength > 0 || remainingLength >= itemLength)
        {
            itemQty++;
            remainingLength -= itemLength;
        }

        if (remainingLength > 0 && remainingLength < 4800) //smallest value

        {
            return itemQty;
        }
        return 0;
    }

    /**
     * calculates bargeboard ("vandbrædt") for carport roof
     *
     * @param order
     * @return
     */
    private PartslistModel calculateBargeboard(OrderModel order)
    {
        return null;
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
        MaterialModel band = DAO.getMaterial(23);
        MaterialModel bandScrews = DAO.getMaterial(21);

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
        /* Set up return <model>*/
        PartslistModel tiles = new PartslistModel();

        /* Get MaterialModel to return */
        MaterialModel tileLarge = DAO.getMaterial(28); //109x6000
        MaterialModel tileSmall = DAO.getMaterial(29); //109x3600

        /* Set up variables */
        int remainingLength = order.getLength();
        int remainingWidth = order.getWidth();
        int largeQty = 0;
        int smallQty = 0;

        /* Calculation begin */
        //take into account that we need a 5cm extension per tile
        int estimatedTiles = (remainingLength / tileLarge.getLength()) + 1;
        //take into account that we need a 2cm overlap between two tiles

        while (remainingLength > 0 || remainingWidth > 0)
        {
            /* Add large tiles */
            while (remainingLength > tileLarge.getLength())
            {
                largeQty++;
                remainingLength -= tileLarge.getLength();
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

 /* Update price */

 /* Update helptext */
        tileLarge.setHelptext("tagplader monteres på spær");
        tileSmall.setHelptext("tagplader monteres på spær");
        /* Add to <model> */

 /* Return <model>*/
        return null;
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
