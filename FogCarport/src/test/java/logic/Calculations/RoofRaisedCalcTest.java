
package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.AlgorithmException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 
 */
public class RoofRaisedCalcTest {

    DataFacade DAO;
    private final String helptext = "roof";

    public RoofRaisedCalcTest() {
    }

    @Before
    public void setUp() {
        DAO = DataFacadeImpl.getInstance();
    }

    /**
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc min values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofRaisedMaterialsMIN() throws Exception{
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material35 = DAO.getMaterial(35, helptext);
        MaterialModel material42 = DAO.getMaterial(42, helptext);
        MaterialModel material32 = DAO.getMaterial(32, helptext);
        MaterialModel material7 = DAO.getMaterial(7, helptext);
        MaterialModel material6 = DAO.getMaterial(6, helptext);
        MaterialModel material30 = DAO.getMaterial(30, helptext);
        MaterialModel material12 = DAO.getMaterial(12, helptext);
        MaterialModel material1 = DAO.getMaterial(1, helptext);
        MaterialModel material8 = DAO.getMaterial(8, helptext);
        MaterialModel material10 = DAO.getMaterial(10, helptext);
        MaterialModel material20 = DAO.getMaterial(20, helptext);        
        
        material35.setQuantity(14);
        material42.setQuantity(2);
        material32.setQuantity(2);
        material7.setQuantity(5);
        material6.setQuantity(15);
        material30.setQuantity(5);
        material12.setQuantity(6);
        material1.setQuantity(4);
        material8.setQuantity(1);
        material10.setQuantity(1);
        material20.setQuantity(5);        
        
        bomExp.addMaterial(material35);
        bomExp.addMaterial(material42);
        bomExp.addMaterial(material32);
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);
        bomExp.addMaterial(material30);
        bomExp.addMaterial(material12);
        bomExp.addMaterial(material1);
        bomExp.addMaterial(material8);
        bomExp.addMaterial(material10);
        bomExp.addMaterial(material20);

        order.setWidth(2400);
        order.setIncline(5);
        order.setLength(2400);
        order.setRoof_tiles_id(35);

        PartslistModel bomRes = raised.getRoofRaisedMaterials(order);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc max values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofRaisedMaterialsMAX() throws Exception{
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material38 = DAO.getMaterial(38, helptext);
        MaterialModel material45 = DAO.getMaterial(45, helptext);
        MaterialModel material32 = DAO.getMaterial(32, helptext);
        MaterialModel material7 = DAO.getMaterial(7, helptext);
        MaterialModel material6 = DAO.getMaterial(6, helptext);
        MaterialModel material30 = DAO.getMaterial(30, helptext);
        MaterialModel material12 = DAO.getMaterial(12, helptext);
        MaterialModel material3 = DAO.getMaterial(3, helptext);
        MaterialModel material1 = DAO.getMaterial(1, helptext);
        MaterialModel material8 = DAO.getMaterial(8, helptext);
        MaterialModel material10 = DAO.getMaterial(10, helptext);
        MaterialModel material20 = DAO.getMaterial(20, helptext);        
        
        material38.setQuantity(697);
        material45.setQuantity(18);
        material32.setQuantity(2);
        material7.setQuantity(50);
        material6.setQuantity(40);
        material30.setQuantity(10);
        material12.setQuantity(52);
        material3.setQuantity(4);
        material1.setQuantity(2);
        material8.setQuantity(84);
        material10.setQuantity(1);
        material20.setQuantity(14);        
        
        bomExp.addMaterial(material38);
        bomExp.addMaterial(material45);
        bomExp.addMaterial(material32);
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);
        bomExp.addMaterial(material30);
        bomExp.addMaterial(material12);
        bomExp.addMaterial(material3);
        bomExp.addMaterial(material1);
        bomExp.addMaterial(material8);
        bomExp.addMaterial(material10);
        bomExp.addMaterial(material20);

        order.setWidth(7200);
        order.setIncline(45);
        order.setLength(7200);
        order.setRoof_tiles_id(38);

        PartslistModel bomRes = raised.getRoofRaisedMaterials(order);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc with order = null.
     * @throws java.lang.Exception
     */
    @Test (expected = AlgorithmException.class)
    public void testGetRoofRaisedMaterialsFAILnull() throws Exception{
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = null;
        raised.getRoofRaisedMaterials(order);
        fail("AlgorithmException wasn't thrown");
    }
    
    /**
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc with order.getLength = zero.
     * @throws java.lang.Exception
     */
    @Test (expected = AlgorithmException.class)
    public void testGetRoofRaisedMaterialsFAILzeroLength() throws Exception{
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        order.setWidth(7200);
        order.setIncline(45);
        order.setLength(0);
        order.setRoof_tiles_id(38);
        raised.getRoofRaisedMaterials(order);
        fail("AlgorithmException wasn't thrown");
    }
    
    /**
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc with order.getWidth = zero.
     * @throws java.lang.Exception
     */
    @Test (expected = AlgorithmException.class)
    public void testGetRoofRaisedMaterialsFAILzeroWidth() throws Exception{
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        order.setWidth(0);
        order.setIncline(45);
        order.setLength(3500);
        order.setRoof_tiles_id(38);
        raised.getRoofRaisedMaterials(order);
        fail("AlgorithmException wasn't thrown");
    }
    
    /**
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc with order.getIncline = zero.
     * @throws java.lang.Exception
     */
    @Test (expected = AlgorithmException.class)
    public void testGetRoofRaisedMaterialsFAILzeroIncline() throws Exception{
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        order.setWidth(400);
        order.setIncline(0);
        order.setLength(3500);
        order.setRoof_tiles_id(38);
        raised.getRoofRaisedMaterials(order);
        fail("AlgorithmException wasn't thrown");
    }
    
    /**
     * Test of getScrews method, of class RoofRaisedCalc normal amount.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetScrewsNORMAL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material20 = DAO.getMaterial(20, helptext);
        raised.screwCount = 754;

        material20.setQuantity(4);
        bomExp.addMaterial(material20);

        PartslistModel bomRes = raised.getScrews();
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getScrews method, of class RoofRaisedCalc where amount is 1.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetScrewsMIN() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material20 = DAO.getMaterial(20, helptext);
        raised.screwCount = 1;

        material20.setQuantity(1);
        bomExp.addMaterial(material20);

        PartslistModel bomRes = raised.getScrews();
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getScrews method, of class RoofRaisedCalc big amount.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetScrewsMANY() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material20 = DAO.getMaterial(20, helptext);
        raised.screwCount = 10001;

        material20.setQuantity(51);
        bomExp.addMaterial(material20);

        PartslistModel bomRes = raised.getScrews();
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getScrews method, of class RoofRaisedCalc where amount is less than 1.
     * @throws java.lang.Exception
     */
    @Test (expected = AlgorithmException.class)
    public void testGetScrewsFAIL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        raised.screwCount = 0;
        raised.getScrews();
        fail("AlgorithmException wasn't thrown");
    }

    /**
     * Test of getRoofTiles method, of class RoofRaisedCalc normal values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofTilesNORMAL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material33 = DAO.getMaterial(33, helptext);
        MaterialModel material40 = DAO.getMaterial(40, helptext);
        MaterialModel material32 = DAO.getMaterial(32, helptext);

        material33.setQuantity(134);
        material40.setQuantity(5);
        material32.setQuantity(2);
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
     * Test of getRoofTiles method, of class RoofRaisedCalc min values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofTilesMIN() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material35 = DAO.getMaterial(35, helptext);
        MaterialModel material42 = DAO.getMaterial(42, helptext);
        MaterialModel material32 = DAO.getMaterial(32, helptext);

        material35.setQuantity(14);
        material42.setQuantity(2);
        material32.setQuantity(2);
        bomExp.addMaterial(material35);
        bomExp.addMaterial(material42);
        bomExp.addMaterial(material32);

        order.setWidth(2400);
        order.setIncline(5);
        order.setLength(2400);
        order.setRoof_tiles_id(35);

        PartslistModel bomRes = raised.getRoofTiles(order);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getRoofTiles method, of class RoofRaisedCalc max values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofTilesMAX() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material39 = DAO.getMaterial(39, helptext);
        MaterialModel material46 = DAO.getMaterial(46, helptext);
        MaterialModel material32 = DAO.getMaterial(32, helptext);

        material39.setQuantity(50);
        material46.setQuantity(18);
        material32.setQuantity(2);
        bomExp.addMaterial(material39);
        bomExp.addMaterial(material46);
        bomExp.addMaterial(material32);

        order.setWidth(7200);
        order.setIncline(45);
        order.setLength(7200);
        order.setRoof_tiles_id(39);

        PartslistModel bomRes = raised.getRoofTiles(order);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of RoofRoofStructure method, of class RoofRaisedCalc normal values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofRoofStructureNORMAL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material7 = DAO.getMaterial(7, helptext);
        MaterialModel material6 = DAO.getMaterial(6, helptext);
        MaterialModel material30 = DAO.getMaterial(30, helptext);
        MaterialModel material12 = DAO.getMaterial(12, helptext);
        MaterialModel material13 = DAO.getMaterial(13, helptext);
        MaterialModel material1 = DAO.getMaterial(1, helptext);
        MaterialModel material2 = DAO.getMaterial(2, helptext);

        material7.setQuantity(8);
        material6.setQuantity(32);
        material30.setQuantity(8);
        material12.setQuantity(16);
        material13.setQuantity(1);
        material1.setQuantity(2);
        material2.setQuantity(2);
        
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);
        bomExp.addMaterial(material30);
        bomExp.addMaterial(material12);
        bomExp.addMaterial(material13);
        bomExp.addMaterial(material1);
        bomExp.addMaterial(material2);

        order.setWidth(3400);
        order.setIncline(15);
        order.setLength(5200);

        PartslistModel bomRes = raised.getRoofStructure(order);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of RoofRoofStructure method, of class RoofRaisedCalc min values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofRoofStructureMIN() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();

        MaterialModel material7 = DAO.getMaterial(7, helptext);
        MaterialModel material6 = DAO.getMaterial(6, helptext);
        MaterialModel material30 = DAO.getMaterial(30, helptext);
        MaterialModel material12 = DAO.getMaterial(12, helptext);
        MaterialModel material1 = DAO.getMaterial(1, helptext);

        material7.setQuantity(5);
        material6.setQuantity(15);
        material30.setQuantity(5);
        material12.setQuantity(6);
        material1.setQuantity(4);
        
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);
        bomExp.addMaterial(material30);
        bomExp.addMaterial(material12);
        bomExp.addMaterial(material1);

        order.setWidth(2400);
        order.setIncline(5);
        order.setLength(2400);

        PartslistModel bomRes = raised.getRoofStructure(order);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of RoofRoofStructure method, of class RoofRaisedCalc max values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofRoofStructureMAX() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material7 = DAO.getMaterial(7, helptext);
        MaterialModel material6 = DAO.getMaterial(6, helptext);
        MaterialModel material30 = DAO.getMaterial(30, helptext);
        MaterialModel material12 = DAO.getMaterial(12, helptext);
        MaterialModel material3 = DAO.getMaterial(3, helptext);
        MaterialModel material1 = DAO.getMaterial(1, helptext);

        material7.setQuantity(50);
        material6.setQuantity(40);
        material30.setQuantity(10);
        material12.setQuantity(52);
        material3.setQuantity(4);
        material1.setQuantity(2);
        
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);
        bomExp.addMaterial(material30);
        bomExp.addMaterial(material12);
        bomExp.addMaterial(material3);
        bomExp.addMaterial(material1);

        order.setWidth(7200);
        order.setIncline(45);
        order.setLength(7200);

        PartslistModel bomRes = raised.getRoofStructure(order);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc normal length.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialsFromlengthNORMAL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();

        MaterialModel material6 = DAO.getMaterial(6, helptext);
        MaterialModel material7 = DAO.getMaterial(7, helptext);
        materials.add(material6); 
        materials.add(material7); 
        
        material7.setQuantity(7);
        material6.setQuantity(1);
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);

        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 26100);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc negative length.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialsFromlengthNEGATIVE() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();
        MaterialModel material3 = DAO.getMaterial(3, helptext); 
        MaterialModel material6 = DAO.getMaterial(6, helptext); 
        MaterialModel material7 = DAO.getMaterial(7, helptext); 
        MaterialModel material8 = DAO.getMaterial(8, helptext); 
        MaterialModel material10 = DAO.getMaterial(10, helptext); 
        
        materials.add(material3);
        materials.add(material6); 
        materials.add(material7);
        materials.add(material8); 
        materials.add(material10); 
        
        PartslistModel bomRes = raised.getMaterialsFromlength(materials, -1);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc zero length.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialsFromlengthZERO() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();
        MaterialModel material3 = DAO.getMaterial(3, helptext); 
        MaterialModel material6 = DAO.getMaterial(6, helptext); 
        MaterialModel material7 = DAO.getMaterial(7, helptext); 
        MaterialModel material8 = DAO.getMaterial(8, helptext); 
        MaterialModel material10 = DAO.getMaterial(10, helptext); 
        
        materials.add(material3);
        materials.add(material6); 
        materials.add(material7);
        materials.add(material8); 
        materials.add(material10); 
        
        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 0);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc smallest acceptable length.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialsFromlengthMIN() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();
        MaterialModel material3 = DAO.getMaterial(3, helptext); 
        MaterialModel material6 = DAO.getMaterial(6, helptext); 
        MaterialModel material7 = DAO.getMaterial(7, helptext); 
        MaterialModel material8 = DAO.getMaterial(8, helptext); 
        MaterialModel material10 = DAO.getMaterial(10, helptext); 
        
        materials.add(material3);
        materials.add(material6); 
        materials.add(material7);
        materials.add(material8); 
        materials.add(material10); 
        
        material10.setQuantity(1);
        bomExp.addMaterial(material10);

        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 1);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc small length.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialsFromlengthSMALL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();
        MaterialModel material3 = DAO.getMaterial(3, helptext); 
        MaterialModel material6 = DAO.getMaterial(6, helptext); 
        MaterialModel material7 = DAO.getMaterial(7, helptext); 
        MaterialModel material8 = DAO.getMaterial(8, helptext); 
        MaterialModel material10 = DAO.getMaterial(10, helptext); 
        
        materials.add(material3);
        materials.add(material6); 
        materials.add(material7);
        materials.add(material8); 
        materials.add(material10); 
        
        material3.setQuantity(7);
        material6.setQuantity(1);
        material7.setQuantity(7);
        material8.setQuantity(7);
        material10.setQuantity(1);
        
        bomExp.addMaterial(material6);

        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 2101);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc big length.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialsFromlengthBIG() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();
        MaterialModel material3 = DAO.getMaterial(3, helptext); 
        MaterialModel material6 = DAO.getMaterial(6, helptext); 
        MaterialModel material7 = DAO.getMaterial(7, helptext); 
        MaterialModel material8 = DAO.getMaterial(8, helptext); 
        MaterialModel material10 = DAO.getMaterial(10, helptext); 
        
        materials.add(material3);
        materials.add(material6); 
        materials.add(material7);
        materials.add(material8); 
        materials.add(material10); 
        
        material3.setQuantity(8);
        material7.setQuantity(1);
        
        bomExp.addMaterial(material3);
        bomExp.addMaterial(material7);

        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 51146);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc empty material list.
     * @throws java.lang.Exception
     */
    @Test (expected = AlgorithmException.class)
    public void testGetMaterialsFromlengthFAILemptyList() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        ArrayList<MaterialModel> materials = new ArrayList();
        raised.getMaterialsFromlength(materials, 9000);
        fail("AlgorithmException wasn't thrown");
    }
    
    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc materialLength = zero.
     * @throws java.lang.Exception
     */
    @Test (expected = AlgorithmException.class)
    public void testGetMaterialsFromlengthFAILmaterialLengthZero() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();
        MaterialModel material14 = DAO.getMaterial(14, helptext); 
        
        materials.add(material14);
        material14.setQuantity(1);
        bomExp.addMaterial(material14);
        
        raised.getMaterialsFromlength(materials, 8000);
        fail("AlgorithmException wasn't thrown");
    }

    /**
     * Test of addPartslistWithMaterialsQuantity method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddPartslistWithMaterialsQuantity() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();

        PartslistModel bomExp = new PartslistModel();
        MaterialModel material12E = DAO.getMaterial(12, helptext);
        MaterialModel material30E = DAO.getMaterial(30, helptext);
        MaterialModel material3E = DAO.getMaterial(3, helptext);
        material12E.setQuantity(9);
        material30E.setQuantity(9);
        material3E.setQuantity(9);
        bomExp.addMaterial(material12E);
        bomExp.addMaterial(material30E);
        bomExp.addMaterial(material3E);
        
        PartslistModel bomRes = new PartslistModel();
        MaterialModel material12R = DAO.getMaterial(12, helptext);
        MaterialModel material30R = DAO.getMaterial(30, helptext);
        MaterialModel material3R = DAO.getMaterial(3, helptext);
        material12R.setQuantity(4);
        material30R.setQuantity(3);
        material3R.setQuantity(7);
        bomRes.addMaterial(material12R);
        bomRes.addMaterial(material30R);
        bomRes.addMaterial(material3R);
        
        PartslistModel bomAdd = new PartslistModel();
        MaterialModel material12A = DAO.getMaterial(12, helptext);
        MaterialModel material30A = DAO.getMaterial(30, helptext);
        MaterialModel material3A = DAO.getMaterial(3, helptext);
        material12A.setQuantity(5);
        material30A.setQuantity(6);
        material3A.setQuantity(2);
        bomAdd.addMaterial(material12A);
        bomAdd.addMaterial(material30A);
        bomAdd.addMaterial(material3A);
        
        raised.addPartslistWithMaterialsQuantity(bomAdd, bomRes);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of generateRafter method, of class RoofRaisedCalc normal values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGenerateRafterNORMAL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();

        MaterialModel material7 = DAO.getMaterial(7, helptext);
        MaterialModel material6 = DAO.getMaterial(6, helptext);
        material7.setQuantity(3);
        material6.setQuantity(2);
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);

        PartslistModel bomRes = raised.generateRafter(4600, 20);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of generateRafter method, of class RoofRaisedCalc min values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGenerateRafterMIN() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material7 = DAO.getMaterial(7, helptext);
        MaterialModel material6 = DAO.getMaterial(6, helptext);
        material7.setQuantity(1);
        material6.setQuantity(3);
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);

        PartslistModel bomRes = raised.generateRafter(2400, 5);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of generateRafter method, of class RoofRaisedCalc max values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGenerateRafterMAX() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();

        MaterialModel material7 = DAO.getMaterial(7, helptext);
        MaterialModel material6 = DAO.getMaterial(6, helptext);
        material7.setQuantity(5);
        material6.setQuantity(2);
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);

        PartslistModel bomRes = raised.generateRafter(7200, 45);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of generatefasciaBoards method, of class RoofRaisedCalc normal values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGeneratefasciaBoardsNORMAL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material1 = DAO.getMaterial(1, helptext);
        MaterialModel material3 = DAO.getMaterial(3, helptext);
        material1.setQuantity(4);
        material3.setQuantity(2);
        bomExp.addMaterial(material1);
        bomExp.addMaterial(material3);

        PartslistModel bomRes = raised.generatefasciaBoards(4500, 35, 7500);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of generatefasciaBoards method, of class RoofRaisedCalc min values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGeneratefasciaBoardsMIN() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material1 = DAO.getMaterial(1, helptext);
        material1.setQuantity(4);
        bomExp.addMaterial(material1);

        PartslistModel bomRes = raised.generatefasciaBoards(2400, 5, 2400);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of generatefasciaBoards method, of class RoofRaisedCalc max values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGeneratefasciaBoardsMAX() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material1 = DAO.getMaterial(1, helptext);
        MaterialModel material2 = DAO.getMaterial(2, helptext);
        MaterialModel material3 = DAO.getMaterial(3, helptext);
        material1.setQuantity(2);
        material2.setQuantity(2);
        material3.setQuantity(2);
        bomExp.addMaterial(material2);
        bomExp.addMaterial(material3);
        bomExp.addMaterial(material1);

        PartslistModel bomRes = raised.generatefasciaBoards(7200, 45, 7200);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of generateLaths method, of class RoofRaisedCalc normal values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGenerateLathsNORMAL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();

        MaterialModel material12 = DAO.getMaterial(12, helptext);
        MaterialModel material13 = DAO.getMaterial(13, helptext);
        material12.setQuantity(19);
        material13.setQuantity(1);
        bomExp.addMaterial(material12);
        bomExp.addMaterial(material13);

        PartslistModel bomRes = raised.generateLaths(6100, 3700, 20);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of generateLaths method, of class RoofRaisedCalc min values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGenerateLathsMIN() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material12 = DAO.getMaterial(12, helptext);
        material12.setQuantity(5);
        bomExp.addMaterial(material12);

        PartslistModel bomRes = raised.generateLaths(2400, 2400, 5);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of generateLaths method, of class RoofRaisedCalc max values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGenerateLathsMAX() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material12 = DAO.getMaterial(12, helptext);
        MaterialModel material13 = DAO.getMaterial(13, helptext);
        material12.setQuantity(49);
        material13.setQuantity(1);
        bomExp.addMaterial(material12);
        bomExp.addMaterial(material13);

        PartslistModel bomRes = raised.generateLaths(7200, 7200, 45);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getCladding method, of class RoofRaisedCalc normal values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCladdingNORMAL() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        order.setWidth(3800);
        order.setIncline(25);
        PartslistModel bomExp = new PartslistModel();

        MaterialModel material8 = DAO.getMaterial(8, helptext);
        MaterialModel material9 = DAO.getMaterial(9, helptext);

        material8.setQuantity(12);
        material9.setQuantity(1);
        bomExp.addMaterial(material8);
        bomExp.addMaterial(material9);

        PartslistModel bomRes = raised.generateCladding(order);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getCladding method, of class RoofRaisedCalc min values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCladdingMIN() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        order.setWidth(2400);
        order.setIncline(5);
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material8 = DAO.getMaterial(8, helptext);
        MaterialModel material10 = DAO.getMaterial(10, helptext);

        material8.setQuantity(1);
        material10.setQuantity(1);
        bomExp.addMaterial(material8);
        bomExp.addMaterial(material10);

        PartslistModel bomRes = raised.generateCladding(order);
        assertEquals(bomExp, bomRes);
    }
    
    /**
     * Test of getCladding method, of class RoofRaisedCalc max values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCladdingMAX() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        order.setWidth(7200);
        order.setIncline(45);
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material8 = DAO.getMaterial(8, helptext);
        MaterialModel material10 = DAO.getMaterial(10, helptext);

        material8.setQuantity(84);
        material10.setQuantity(1);
        bomExp.addMaterial(material8);
        bomExp.addMaterial(material10);

        PartslistModel bomRes = raised.generateCladding(order);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getCladdingMaterialCount method, of class RoofRaisedCalc with normal values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCladdingMaterialCountNORMAL() throws Exception {
        RoofRaisedCalc instance = new RoofRaisedCalc();
        int exp = 11186;
        int res = instance.getCladdingMaterialCount(4300, 35, 0);
        assertEquals(exp, res);
    }
    
    /**
     * Test of getCladdingMaterialCount method, of class RoofRaisedCalc with min values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCladdingMaterialCountMIN() throws Exception {
        RoofRaisedCalc instance = new RoofRaisedCalc();
        int exp = 464;
        int res = instance.getCladdingMaterialCount(2400, 5, 0);
        assertEquals(exp, res);
    }
    
    /**
     * Test of getCladdingMaterialCount method, of class RoofRaisedCalc with max values.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCladdingMaterialCountMAX() throws Exception {
        RoofRaisedCalc instance = new RoofRaisedCalc();
        int exp = 42780;
        int res = instance.getCladdingMaterialCount(7200, 45, 0);
        assertEquals(exp, res);
    }
}
