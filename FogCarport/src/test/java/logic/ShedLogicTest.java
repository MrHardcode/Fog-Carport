/*
 *  Malte Hviid-Magnussen
 */
package logic;

import data.DataFacade;
import data.DataFacadeImpl;
import data.models.MaterialModel;
import data.models.PartslistModel;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Malte
 */
public class ShedLogicTest
{
    
    public ShedLogicTest()
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
    }
    
    @After
    public void tearDown()
    {
    }
//
//    /**
//     * Test of addShed method, of class ShedLogic.
//     */
//    @Test
//    public void testAddShed() throws Exception
//    {
//        System.out.println("addShed");
//        PartslistModel bom = null;
//        OrderModel order = null;
//        ShedLogic instance = new ShedLogic();
//        PartslistModel expResult = null;
//        PartslistModel result = instance.addShed(bom, order);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of simpleShed method, of class ShedLogic.
//     */
//    @Test
//    public void testSimpleShed()
//    {
//        System.out.println("simpleShed");
//        PartslistModel bom = null;
//        ShedLogic instance = new ShedLogic();
//        instance.simpleShed(bom);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addFloor method, of class ShedLogic.
//     */
//    @Test
//    public void testAddFloor() throws Exception
//    {
//        System.out.println("addFloor");
//        PartslistModel bom = null;
//        MaterialModel floor = null;
//        int length = 0;
//        int width = 0;
//        DataFacade db = null;
//        ShedLogic instance = new ShedLogic();
//        instance.addFloor(bom, floor, length, width, db);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addDoorMaterials method, of class ShedLogic.
     */
    @Test
    public void testAddDoorMaterials() throws Exception
    {
        System.out.println("addDoorMaterials");
        DataFacade db = DataFacadeImpl.getInstance();
        
        // <editor-fold defaultstate="collapsed" desc="Materials for test.">
        PartslistModel test = new PartslistModel();
        MaterialModel stalddørsgreb = new MaterialModel();
        stalddørsgreb.setID(17);
        stalddørsgreb.setDescription("Stalddørsgreb 50x75");
        stalddørsgreb.setHeight(500);
        stalddørsgreb.setWidth(750);
        stalddørsgreb.setLength(0);
        stalddørsgreb.setPrice(85);
        stalddørsgreb.setUnit("Sæt");
        stalddørsgreb.setCategory("miscellaneous");
        stalddørsgreb.setQuantity(1);
        test.addMaterial(stalddørsgreb); // Stalddørsgreb for the door.
        
        MaterialModel laegte = new MaterialModel(); // 38x73mm taglægte.
        laegte.setID(12);
        laegte.setDescription("38x73 mm. taglægte T1");
        laegte.setHeight(38);
        laegte.setWidth(73);
        laegte.setLength(5400);
        laegte.setPrice(39);
        laegte.setUnit("Stk");
        laegte.setCategory("wood");
        laegte.setQuantity(1);
        test.addMaterial(laegte); // for the backside of the door.
        
        
        MaterialModel hængsel = new MaterialModel();
        hængsel.setID(18);
        hængsel.setDescription("T-hængsel 390mm");
        hængsel.setHeight(0);
        hængsel.setWidth(390);
        hængsel.setLength(0);
        hængsel.setPrice(55.85);
        hængsel.setUnit("Stk");
        hængsel.setCategory("miscellaneous");
        hængsel.setQuantity(2);
        test.addMaterial(hængsel); // T-hængsel for the door.
        // </editor-fold>
        
        PartslistModel bom = new PartslistModel();
        ShedLogic instance = new ShedLogic();
        instance.addDoorMaterials(bom, db);
        assertEquals(test, bom);
    }
//
//    /**
//     * Test of addMaterials method, of class ShedLogic.
//     */
//    @Test
//    public void testAddMaterials() throws Exception
//    {
//        System.out.println("addMaterials");
//        PartslistModel bom = null;
//        MaterialModel wood = null;
//        int length = 0;
//        int width = 0;
//        DataFacade db = null;
//        OrderModel order = null;
//        ShedLogic instance = new ShedLogic();
//        instance.addMaterials(bom, wood, length, width, db, order);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of posts method, of class ShedLogic.
//     */
//    @Test
//    public void testPosts() throws Exception
//    {
//        System.out.println("posts");
//        int length = 0;
//        OrderModel order = null;
//        int width = 0;
//        DataFacade db = null;
//        PartslistModel bom = null;
//        ShedLogic instance = new ShedLogic();
//        instance.posts(length, order, width, db, bom);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of reglar method, of class ShedLogic.
//     */
//    @Test
//    public void testReglar() throws Exception
//    {
//        System.out.println("reglar");
//        int width = 0;
//        DataFacade db = null;
//        PartslistModel bom = null;
//        int side = 0;
//        ShedLogic instance = new ShedLogic();
//        int expResult = 0;
//        int result = instance.reglar(width, db, bom, side);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addScrews method, of class ShedLogic.
//     */
//    @Test
//    public void testAddScrews()
//    {
//        System.out.println("addScrews");
//        PartslistModel bom = null;
//        DataFacade db = null;
//        MaterialModel screws = null;
//        int packamount = 0;
//        int screwamount = 0;
//        ShedLogic instance = new ShedLogic();
//        instance.addScrews(bom, db, screws, packamount, screwamount);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
    
}
