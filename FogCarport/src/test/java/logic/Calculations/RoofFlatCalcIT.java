package logic.Calculations;

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
 * @author 
 */
public class RoofFlatCalcIT
{
    
    public RoofFlatCalcIT()
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
        OrderModel order = new OrderModel();
        order.setHeight(2100);
        order.setLength(7200);
        order.setWidth(3600);
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
     * Test of calculateMiscellaneous method, of class RoofFlatCalc.
     */
    @Test
    public void testCalculateMiscellaneous()
    {
        System.out.println("calculateMiscellaneous");
        OrderModel order = null;
        RoofFlatCalc instance = new RoofFlatCalc();
        PartslistModel expResult = null;
        PartslistModel result = instance.calculateMiscellaneous(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
