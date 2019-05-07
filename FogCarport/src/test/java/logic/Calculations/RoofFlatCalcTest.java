package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test of RoofFlatCalc
 *
 * @see RoofFlatCalc
 *
 *
 * @author
 */
public class RoofFlatCalcTest
{

    DataFacade DAO;
    OrderModel testOrder; 

    public RoofFlatCalcTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
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
        testOrder = new OrderModel();
        //testing the carport from the brochure:
        //https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CP01_DUR.pdf
        testOrder.setHeight(2100);
        testOrder.setLength(7800);
        testOrder.setWidth(6000);
        testOrder.setShed_length(2100);
        testOrder.setShed_width(5300);
        testOrder.setRoof_tiles_id(28); //plastic tiles
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of calculateFlatRoofStructure method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateFlatRoofStructure() throws Exception
    {
        System.out.println("calculateFlatRoofStructure");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateFlatRoofStructure(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateMainParts method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateMainParts() throws Exception
    {
        System.out.println("calculateMainParts");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateMainParts(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDependantParts method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateDependantParts() throws Exception
    {
        System.out.println("calculateDependantParts");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateDependantParts(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculatePlasticRoof method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculatePlasticRoof() throws Exception
    {
        System.out.println("calculatePlasticRoof");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculatePlasticRoof(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateFeltRoof method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateFeltRoof()
    {
        System.out.println("calculateFeltRoof");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateFeltRoof(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateRafters method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateRafters() throws Exception
    {
        System.out.println("calculateRafters");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateRafters(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateFascias method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateFascias() throws Exception
    {
        System.out.println("calculateFascias");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateFascias(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of itemHelper method, of class RoofFlatCalc.
     */
    @Test
    public void testItemHelper()
    {
        System.out.println("itemHelper");
        MaterialModel material = null;
        int dimension = 0;
        RoofFlatCalc instance = new RoofFlatCalc();
        MaterialModel expResult = null;
        MaterialModel result = instance.itemHelper(material, dimension);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateBargeboard method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateBargeboard() throws Exception
    {
        System.out.println("calculateBargeboard");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateBargeboard(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateFittings method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateFittings() throws Exception
    {
        System.out.println("calculateFittings");
        PartslistModel rafters = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateFittings(rafters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateBand method, of class RoofFlatCalc.
     * 
     * This test expects 2 bands from method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateBandRegular() throws Exception
    {
        System.out.println("calculateBand");
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = new PartslistModel();
        PartslistModel result = instance.calculateBand(testOrder);

        MaterialModel expBand = DAO.getMaterial(23);
        MaterialModel expScrews = DAO.getMaterial(21);

        expBand.setQuantity(2);
        expScrews.setQuantity(1);
        expBand.setPrice(expBand.getQuantity() * expBand.getPrice());
        expBand.setHelptext("Til vindkryds på spær");
        expScrews.setHelptext("Til montering af universalbeslag + hulbånd");

        expResult.addMaterial(expBand);
        expResult.addMaterial(expScrews);

        System.out.println("Band QTY expected:\n" + expBand.toString());
        System.out.println("Band QTY actual:\n" + result.getBillOfMaterials().get(0).toString());
        assertEquals(expResult, result);
        
        /* 
        Explanation:
        We add one band per 10m (10.000mm) of distance to cover.
        One distance is two diagonals from shed to carport front.
        In this case we a shed of 2100mm length, so distance to cover is:
        ((OrderLength)-(ShedLength)*2)
        
        (7800-2100)*2 = 11.400
        */
    }
    
    /**
     * Test of calculateBand method, of class RoofFlatCalc.
     * 
     * This test should only calculate one band, due to us manipulating the shed length.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateBandSingle() throws Exception
    {
        System.out.println("calculateBand");
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = new PartslistModel();
        testOrder.setShed_length(6000);
        PartslistModel result = instance.calculateBand(testOrder);

        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 1);
        
        /* 
        Explanation:
        Instead of 11.400 from above method, having a shed with 2100 length,
        we add a shed of 6000mm length.
        Therefore the cover length will be 5400, which is below the threshhold. (10.000mm)
        This means that a second band is not added.
        */
    }
    
    
     /**
     * Test of calculateBand method, of class RoofFlatCalc.
     * 
     * This test should calculate three bands, due to us manipulating the dimensions.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateBandMultiple() throws Exception
    {
        System.out.println("calculateBand");
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = new PartslistModel();
        //shed_length = 2100
        testOrder.setLength(12101);
        PartslistModel result = instance.calculateBand(testOrder);

        assertEquals(result.getBillOfMaterials().get(0).getQuantity(), 3);
        
        /* 
        Explanation:
        here we have a really long carport right at the breakoff.
        ((OrderLength)-(ShedLength)*2)
        
        (12101-2100)*2 = 20002 = 3 bands
        
        (( because we need to cover more than two bands length (20.000) ))
        */
    }

    /**
     * Test of calculatePlasticTiles method, of class RoofFlatCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculatePlasticTiles() throws Exception
    {
        System.out.println("calculatePlasticTiles");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculatePlasticTiles(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateFeltTiles method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateFeltTiles()
    {
        System.out.println("calculateFeltTiles");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateFeltTiles(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
