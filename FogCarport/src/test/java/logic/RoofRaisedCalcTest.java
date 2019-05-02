/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataFacade;
import data.DataFacadeImpl;
import data.models.OrderModel;
import data.models.PartslistModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Camilla
 */
public class RoofRaisedCalcTest {

    DataFacade DAO;

    public RoofRaisedCalcTest() {
    }

    @Before
    public void setUp() {
        DAO = DataFacadeImpl.getInstance();
    }

    /**
     * Test of getRoofStructure method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofStructure() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        for (int i = 0; i < 6; i++) {
            bomExp.addMaterial(DAO.getMaterial(7));
            bomExp.addMaterial(DAO.getMaterial(7));
            bomExp.addMaterial(DAO.getMaterial(7));
            bomExp.addMaterial(DAO.getMaterial(7));
        }
        for (int i = 0; i < 12; i++) {
            bomExp.addMaterial(DAO.getMaterial(12));
        }
        order.setWidth(3000);
        order.setIncline(20);
        order.setLength(4000);

        PartslistModel bomRes = raised.getRoofStructure(order);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
//    @Test
//    public void testGetRoofRaisedMaterials() throws Exception {
//        System.out.println("getRoofRaisedMaterials");
//        OrderModel order = null;
//        RoofRaisedCalc instance = new RoofRaisedCalc();
//        PartslistModel expResult = null;
//        PartslistModel result = instance.getRoofRaisedMaterials(order);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRoofTiles method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGetRoofTiles() {
//        System.out.println("getRoofTiles");
//        OrderModel order = null;
//        RoofRaisedCalc instance = new RoofRaisedCalc();
//        PartslistModel expResult = null;
//        PartslistModel result = instance.getRoofTiles(order);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMaterialsFromlength method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGetMaterialsFromlength() {
//        System.out.println("getMaterialsFromlength");
//        ArrayList<MaterialModel> materials = null;
//        int length = 0;
//        RoofRaisedCalc instance = new RoofRaisedCalc();
//        PartslistModel expResult = null;
//        PartslistModel result = instance.getMaterialsFromlength(materials, length);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of generateRafter method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGenerateRafter() throws Exception {
//        System.out.println("generateRafter");
//        int totalWidth = 0;
//        int incline = 0;
//        RoofRaisedCalc instance = new RoofRaisedCalc();
//        PartslistModel expResult = null;
//        PartslistModel result = instance.generateRafter(totalWidth, incline);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of generateLaths method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGenerateLaths() throws Exception {
//        System.out.println("generateLaths");
//        int orderLength = 0;
//        int totalWidth = 0;
//        int incline = 0;
//        RoofRaisedCalc instance = new RoofRaisedCalc();
//        PartslistModel expResult = null;
//        PartslistModel result = instance.generateLaths(orderLength, totalWidth, incline);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
