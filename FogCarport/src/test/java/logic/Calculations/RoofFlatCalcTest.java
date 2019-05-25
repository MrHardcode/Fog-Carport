package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * Test of RoofFlatCalc
 *
 * The algorithm was made to match the example given by Fog.
 *
 * That means it strives to get the same values available here:
 *
 * https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CP01_DUR.pdf
 *
 * @see RoofFlatCalc
 *
 *
 * @author
 */
public class RoofFlatCalcTest
{

    DataFacade DAO;
    static OrderModel testOrder;
    private final String helptext = "roof";
    static int rafterCount = 0;

    public RoofFlatCalcTest() throws DataException
    {
        testOrder = new OrderModel();
        //testing the carport from the brochure:
        //https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CP01_DUR.pdf
        testOrder.setHeight(2100);
        testOrder.setLength(7800);
        testOrder.setWidth(6000);
        testOrder.setShed_length(2100);
        testOrder.setShed_width(5300);
        testOrder.setRoof_tiles_id(29); //plastic tiles
        RoofFlatCalc instance = new RoofFlatCalc();
        instance.calculateRafters(testOrder);
        rafterCount = instance.rafterCount; //needed for other calculations
    }

    @BeforeClass
    public static void setUpClass() throws DataException
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
        DAO = DataFacadeImpl.getInstance();
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of calculateRafters method, of class RoofFlatCalc.
     *
     * Explanation: (!!the actual width is 6100)
     *
     * This is simple. We add one rafter per 500mm width.
     *
     * The order length perfectly matches up to the material length - 6m.
     *
     * (6000/500)=12.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateRafters() throws Exception
    {
        System.out.println("calculateRafters");
        OrderModel order = testOrder;
        RoofFlatCalc instance = new RoofFlatCalc();
        instance.rafterCount = 0;
        PartslistModel result = instance.calculateRafters(order);
        System.out.println("RAFTER: " + result.getBillOfMaterials().get(0));

        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 15);
    }

    /**
     * Test of calculateRafters method, of class RoofFlatCalc.
     *
     * Explanation:
     *
     * We don't have any actual data from fog on odd widths.
     *
     * They only have 1 rafter available and they do not customize the length.
     *
     * Basically, whenever the width is longer than the rafter length (6000) we
     * multiply by 2.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateRaftersOddWidth() throws Exception
    {
        System.out.println("calculateRaftersOddWidth");
        OrderModel order = testOrder;
        order.setWidth(8525);
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel result = instance.calculateRafters(order);
        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 30);
    }

    /**
     * Test of calculateFascias method, of class RoofFlatCalc.
     *
     * Please see the .pdf for material breakdown.
     *
     * The basic explanation of this is that we need the following:
     *
     * 2 lower boards for each side (side1,side2,front,back) of the carport.
     *
     * = 8 total. (position 0,1 in partslist)
     *
     * 2 top boards for the front (position 2 in partslist)
     *
     * 4 top boards for the sides (side1,side2) (position 3 in partslist)
     *
     * Due to water drainage the back does NOT have top boards.
     *
     * These boards have varying lengths, widths and heights.
     *
     * There are two types of materials, length being the most important.
     *
     * The lengths (5400, 3600) are handled by the algorithm.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateFascias() throws Exception
    {
        System.out.println("calculateFascias");
        OrderModel order = testOrder;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel result = instance.calculateFascias(order);
        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 4); //fasciaLengthBottom
        assertEquals(result.getBillOfMaterials().get(1).getQuantity(), 4); //fasciaLengthTop
        assertEquals(result.getBillOfMaterials().get(2).getQuantity(), 4); //fasciaWidthBottom
        assertEquals(result.getBillOfMaterials().get(3).getQuantity(), 2); //fasciaWidthTop
    }

    /**
     * Test of calculateBargeboard method, of class RoofFlatCalc.
     *
     * Explanation:
     *
     * The algorithm handles lengths.
     *
     * We need two boards per side = 4 (due to length)
     *
     * We need two boards for the front = 2 (due to length)
     *
     * No boards for the back. Ever.
     *
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateBargeboard() throws Exception
    {
        System.out.println("calculateBargeboard");
        OrderModel order = testOrder;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel result = instance.calculateBargeboard(order);
        System.out.println("bargeboard 1: " + result.getBillOfMaterials().get(0));
        System.out.println("bargeboard 2: " + result.getBillOfMaterials().get(1));
        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 4);

        assertEquals(result.getBillOfMaterials().get(1).getQuantity(), 2);
    }

    /**
     * Test of calculateFittings method, of class RoofFlatCalc.
     *
     * Explanation:
     *
     * We need 2 fittings per rafter, 1 right and 1 left.
     *
     * partslistmodel position 0 = right
     *
     * partslistmodel position 1 = left
     *
     * (position 3 = screws)
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateFittings() throws Exception
    {
        System.out.println("calculateFittings");
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel rafters = instance.calculateRafters(testOrder);
        PartslistModel result = instance.calculateFittings(rafterCount);
        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 15);
        assertEquals(result.getBillOfMaterials().get(1).getQuantity(), 15);
    }

    /**
     * Test of calculateBand method, of class RoofFlatCalc.
     *
     * This test expects 2 bands from method.
     *
     * Explanation: We add one band per 10m (10.000mm) of distance to cover. One
     * distance is two diagonals from shed to carport front. In this case we a
     * shed of 2100mm length, so distance to cover is:
     * ((OrderLength)-(ShedLength)*2)
     *
     * (7800-2100)*2 = 11.400
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateBand() throws Exception
    {
        System.out.println("calculateBand");
        RoofFlatCalc instance = new RoofFlatCalc();
        instance.rafterCount = rafterCount;
        PartslistModel expResult = new PartslistModel();
        PartslistModel result = instance.calculateBand(testOrder);

        MaterialModel expBand = DAO.getMaterial(23, helptext);
        MaterialModel expScrews = DAO.getMaterial(21, helptext);

        expBand.setQuantity(2);
        expScrews.setQuantity(1);
        expBand.setPrice(expBand.getQuantity() * expBand.getPrice());
        expBand.setHelptext("Til vindkryds på spær");
        expScrews.setHelptext("Til montering af universalbeslag + toplægte");

        expResult.addMaterial(expBand);
        expResult.addMaterial(expScrews);

        System.out.println("Band expected:\n" + expBand.toString());
        System.out.println("Band actual:\n" + result.getBillOfMaterials().get(0).toString());
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateBand method, of class RoofFlatCalc.
     *
     * This test should only calculate one band, due to us manipulating the shed
     * length.
     *
     * Explanation:
     *
     * Instead of the 11.400 cover length from testCalculateBand, which had a
     * shed with 2100 length, in this test we add a shed of 6000mm length.
     * Therefore the cover length will be 5400, which is below the threshold.
     * (10.000mm) This means that a second band is not added.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateBandSingle() throws Exception
    {
        System.out.println("calculateBandSingle");
        OrderModel order = testOrder;
        RoofFlatCalc instance = new RoofFlatCalc();
        instance.rafterCount = rafterCount;
        order.setShed_length(6000);
        PartslistModel result = instance.calculateBand(order);
        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 1);
    }

    /**
     * Test of calculateBand method, of class RoofFlatCalc.
     *
     * This test should calculate three bands, due to us manipulating the
     * dimensions.
     *
     * Explanation: here we have a really long carport right at the breakoff.
     * ((OrderLength)-(ShedLength)*2)
     *
     * (12101-2100)*2 = 20002 = 3 bands
     *
     * (( because we need to cover more than two bands length (20.000) ))
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateBandMultiple() throws Exception
    {
        System.out.println("calculateBandMultiple");
        OrderModel order = testOrder;
        RoofFlatCalc instance = new RoofFlatCalc();
        instance.rafterCount = rafterCount;
        //shed_length = 2100
        order.setLength(12102);
        PartslistModel result = instance.calculateBand(order);

        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 3);
    }

    /**
     * Test of calculatePlasticTiles method, of class RoofFlatCalc.
     *
     * Explanation: order is 7900 long, 6100 wide. (Width is +100 due to tile
     * extension) the tiles are respectively 5800x890 & 3400x890 (-200 due to
     * tile overlap)
     *
     * To cover one length we need two tiles; one large, one small. (total: 1,
     * 1) (5800+3400) = 9200 is more than enough to cover the 7800 length.
     *
     * We need to cover for the whole roof, so we calculate by the width. this
     * gives us the calculation (6100/890) = 6.85. Normally we would round up,
     * but it is not needed, as every tile (even the ones at the roof end) has a
     * 200mm overlap. * There is more than enough material.
     *
     * This brings the total to 6,6.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculatePlasticTiles() throws Exception
    {
        System.out.println("calculatePlasticTiles");
        OrderModel order = testOrder;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel result = instance.calculatePlasticTiles(order);
        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 6);
        assertEquals(result.getBillOfMaterials().get(1).getQuantity(), 6);
    }

    /**
     * Test of getScrews method, of class RoofFlatCalc.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetScrews() throws Exception
    {
        System.out.println("getScrews");
        int screwID = 21;
        int screwPackSize = 200;
        int screwAmount = 205; //90
        RoofFlatCalc instance = new RoofFlatCalc();
        instance.rafterCount = rafterCount;
        MaterialModel result = instance.getScrews(screwID, screwPackSize, screwAmount);
        assertEquals(result.getQuantity(), 2);
    }

    /**
     * Test of getScrews method, of class RoofFlatCalc. Expecting Exception
     *
     * @throws java.lang.Exception
     */
    @Test(expected = AlgorithmException.class)
    public void testExceptionGetScrews() throws Exception
    {
        System.out.println("getScrewsException");
        int screwID = 0;
        int screwPackSize = 0;
        int screwAmount = 0; //should throw exception
        RoofFlatCalc instance = new RoofFlatCalc();
        MaterialModel expResult = null; //never reaches this so it doesn't its value.
        MaterialModel result = instance.getScrews(screwID, screwPackSize, screwAmount);
        assertEquals(expResult, result);
    }

    /**
     * Test exception throwing of wrong order info.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = AlgorithmException.class)
    public void testExceptionCalculateFlatRoofStructure() throws Exception
    {
        System.out.println("CalculateFlatRoofStructureException");
        OrderModel order = testOrder;
        order.setIncline(5); //should throw exception, only incline 0 allowed.
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null; //never reaches this so it doesn't its value.
        PartslistModel result = instance.calculateFlatRoofStructure(order);
        assertEquals(expResult, result);
    }

    /* NOT PLANNED TO ADD FOR NOW */
//    /**
//     * Test of calculateFeltTiles method, of class RoofFlatCalc.
//     */
//    @Test
//    public void testCalculateFeltTiles()
//    {
//        System.out.println("calculateFeltTiles");
//        OrderModel order = testOrder;
//        RoofFlatCalc instance = new RoofFlatCalc();
//        PartslistModel expResult = null;
//        PartslistModel result = instance.calculateFeltTiles(order);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
