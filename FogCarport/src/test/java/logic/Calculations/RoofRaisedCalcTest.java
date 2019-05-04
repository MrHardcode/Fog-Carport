/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Calculations;

import logic.Calculations.RoofRaisedCalc;
import data.DataFacade;
import data.DataFacadeImpl;
import data.models.MaterialModel;
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
        MaterialModel material7 = DAO.getMaterial(7);
        MaterialModel material12 = DAO.getMaterial(12);
        MaterialModel material30 = DAO.getMaterial(30);
        for (int i = 0; i < 6; i++) {
            bomExp.addMaterial(material7);
            bomExp.addMaterial(material7);
            bomExp.addMaterial(material7);
            bomExp.addMaterial(material7);
            bomExp.addMaterial(material30);
        }
        for (int i = 0; i < 14; i++) {
            bomExp.addMaterial(material12);
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
    /**
     * Test of getRoofTiles method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofTiles() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material33 = DAO.getMaterial(33);
        MaterialModel material40 = DAO.getMaterial(40);

        for (int i = 0; i < 134; i++) {
            bomExp.addMaterial(material33);
        }
        for (int i = 0; i < 5; i++) {
            bomExp.addMaterial(material40);
        }
        bomExp.addMaterial(DAO.getMaterial(32));

        order.setWidth(3000);
        order.setIncline(20);
        order.setLength(4000);
        order.setRoof_tiles_id(33);

        PartslistModel bomRes = raised.getRoofTiles(order);
        assertEquals(bomExp, bomRes);
    }
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
