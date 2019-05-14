/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

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
     * Test of getScrews method, of class RoofRaisedCalc.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetScrews() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material20 = DAO.getMaterial(20);
        raised.screwCount = 754;
        
        material20.setQuantity(4);
        bomExp.addMaterial(material20);

        PartslistModel bomRes = raised.getScrews();
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getRoofTiles method, of class RoofRaisedCalc.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofTiles() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material33 = DAO.getMaterial(33);
        MaterialModel material40 = DAO.getMaterial(40);
        MaterialModel material32 = DAO.getMaterial(32);

        material33.setQuantity(134);
        material40.setQuantity(5);
        material32.setQuantity(1);
        bomExp.addMaterial(material33);
        bomExp.addMaterial(material40);
        bomExp.addMaterial(material32);
        
        order.setWidth(3000);
        order.setIncline(20);
        order.setLength(4000);
        order.setRoof_tiles_id(33);

        PartslistModel bomRes = raised.getRoofTiles(order);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc.
     */
    @Test
    public void testGetRoofRoofStructure() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material7 = DAO.getMaterial(7);
        MaterialModel material12 = DAO.getMaterial(12);
        MaterialModel material30 = DAO.getMaterial(30); 
        MaterialModel material3 = DAO.getMaterial(3);
        
        material7.setQuantity(28);
        material12.setQuantity(13);
        material30.setQuantity(7);
        material3.setQuantity(4);
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material30);
        bomExp.addMaterial(material12);
        bomExp.addMaterial(material3);

        order.setWidth(3000);
        order.setIncline(20);
        order.setLength(4000);

        PartslistModel bomRes = raised.getRoofStructure(order);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc.
     */
    @Test
    public void testGetMaterialsFromlength() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();
        MaterialModel material7 = DAO.getMaterial(7);
        materials.add(DAO.getMaterial(6)); // length 2400 mm
        materials.add(DAO.getMaterial(7)); // length 3600 mm
        material7.setQuantity(3);
        bomExp.addMaterial(material7);

        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 7500);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of generateRafter method, of class RoofRaisedCalc.
     */
    @Test
    public void testGenerateRafter() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material7 = DAO.getMaterial(7);
        material7.setQuantity(4);
        bomExp.addMaterial(material7);

        PartslistModel bomRes = raised.generateRafter(3600, 20);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of generatefasciaBoards method, of class RoofRaisedCalc.
     */
    @Test
    public void testGeneratefasciaBoards() throws LoginException{
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material3 = DAO.getMaterial(3);
        material3.setQuantity(4);
        bomExp.addMaterial(material3);

        PartslistModel bomRes = raised.generatefasciaBoards(3600, 20, 4000);
        assertEquals(bomExp, bomRes);
        
    }

    /**
     * Test of generateLaths method, of class RoofRaisedCalc.
     */
    @Test
    public void testGenerateLaths() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material12 = DAO.getMaterial(12);
        material12.setQuantity(13);
        bomExp.addMaterial(material12);

        PartslistModel bomRes = raised.generateLaths(4000, 3600, 20);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getCladding method, of class RoofRaisedCalc.
     */
    @Test
    public void testGetCladding() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        order.setWidth(7400);
        order.setIncline(20);
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material8 = DAO.getMaterial(8);
        
        material8.setQuantity(20);
        bomExp.addMaterial(material8);
                
        PartslistModel bomRes = raised.getCladding(order);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getCladdingMaterialCount method, of class RoofRaisedCalc.
     */
    @Test
    public void testGetCladdingMaterialCount() throws Exception {
        RoofRaisedCalc instance = new RoofRaisedCalc();
        int exp = 5;
        int res = instance.getCladdingMaterialCount(8000, 20, 0, 100, 4800);

        assertEquals(exp, res);

    }

}
