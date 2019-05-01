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
     */
    @Test
    public void testGetRoofStructure() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        bomExp.addMaterial(DAO.getMaterial(7));
        bomExp.addMaterial(DAO.getMaterial(7));
        bomExp.addMaterial(DAO.getMaterial(7));
        bomExp.addMaterial(DAO.getMaterial(7));
        order.setWidth(3000);
        order.setIncline(20);
        
        PartslistModel bomRes = raised.getRoofStructure(order);
        assertEquals(bomExp, bomRes);
    }
    
}
