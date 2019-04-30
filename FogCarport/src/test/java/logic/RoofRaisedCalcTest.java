/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

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
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc.
     */
    @Test
    public void testGetRoofRaisedMaterials() throws Exception {
//        System.out.println("getRoofRaisedMaterials");
//        OrderModel order = null;
//        RoofRaisedCalc instance = new RoofRaisedCalc();
//        PartslistModel expResult = null;
//        PartslistModel result = instance.getRoofRaisedMaterials(order);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }


    /**
     * Test of getRoofStructure method, of class RoofRaisedCalc.
     */
    @Test
    public void testGetRoofStructure() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        bomExp.addMaterial(DAO.getMaterial(6));
        order.setWidth(1800);
        order.setIncline(20);
        
        PartslistModel bomRes = raised.getRoofStructure(order);
        assertEquals(bomExp, bomRes);
    }
    
}
