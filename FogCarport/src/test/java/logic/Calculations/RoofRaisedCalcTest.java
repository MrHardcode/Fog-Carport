//
//package logic.Calculations;
//
//import data.DataFacade;
//import data.DataFacadeImpl;
//import data.models.MaterialModel;
//import data.models.OrderModel;
//import data.models.PartslistModel;
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//
///**
// *
// * @author 
// */
//public class RoofRaisedCalcTest {
//
//    DataFacade DAO;
//
//    public RoofRaisedCalcTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() {
//        DAO = DataFacadeImpl.getInstance();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//    /**
//     * Test of getScrews method, of class RoofRaisedCalc.
//     * @throws java.lang.Exception
//     */
//    @Test
//    public void testGetScrews() throws Exception {
//        RoofRaisedCalc raised = new RoofRaisedCalc();
//        PartslistModel bomExp = new PartslistModel();
//        MaterialModel material20 = DAO.getMaterial(20);
//        raised.screwCount = 754;
//        for (int i = 0; i < 4; i++) {
//            bomExp.addMaterial(material20);
//        }
//        PartslistModel bomRes = raised.getScrews();
//        assertEquals(bomExp, bomRes);
//    }
//
//    /**
//     * Test of getRoofTiles method, of class RoofRaisedCalc.
//     * @throws java.lang.Exception
//     */
//    @Test
//    public void testGetRoofTiles() throws Exception {
//        RoofRaisedCalc raised = new RoofRaisedCalc();
//        OrderModel order = new OrderModel();
//        PartslistModel bomExp = new PartslistModel();
//        MaterialModel material33 = DAO.getMaterial(33);
//        MaterialModel material40 = DAO.getMaterial(40);
//
//        for (int i = 0; i < 134; i++) {
//            bomExp.addMaterial(material33);
//        }
//        for (int i = 0; i < 5; i++) {
//            bomExp.addMaterial(material40);
//        }
//        bomExp.addMaterial(DAO.getMaterial(32));
//
//        order.setWidth(3000);
//        order.setIncline(20);
//        order.setLength(4000);
//        order.setRoof_tiles_id(33);
//
//        PartslistModel bomRes = raised.getRoofTiles(order);
//        assertEquals(bomExp, bomRes);
//    }
//
//    /**
//     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGetRoofRaisedMaterials() throws Exception {
//        RoofRaisedCalc raised = new RoofRaisedCalc();
//        OrderModel order = new OrderModel();
//        PartslistModel bomExp = new PartslistModel();
//        MaterialModel material7 = DAO.getMaterial(7);
//        MaterialModel material12 = DAO.getMaterial(12);
//        MaterialModel material30 = DAO.getMaterial(30);
//        for (int i = 0; i < 7; i++) {
//            bomExp.addMaterial(material7);
//            bomExp.addMaterial(material7);
//            bomExp.addMaterial(material7);
//            bomExp.addMaterial(material7);
//            bomExp.addMaterial(material30);
//        }
//        for (int i = 0; i < 13; i++) {
//            bomExp.addMaterial(material12);
//        }
//        order.setWidth(3000);
//        order.setIncline(20);
//        order.setLength(4000);
//
//        PartslistModel bomRes = raised.getRoofStructure(order);
//        assertEquals(bomExp, bomRes);
//
//    }
//
//    /**
//     * Test of getMaterialsFromlength method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGetMaterialsFromlength() throws Exception {
//        RoofRaisedCalc raised = new RoofRaisedCalc();
//        PartslistModel bomExp = new PartslistModel();
//        ArrayList<MaterialModel> materials = new ArrayList();
//        MaterialModel material7 = DAO.getMaterial(7);
//        materials.add(DAO.getMaterial(6)); // length 2400 mm
//        materials.add(DAO.getMaterial(7)); // length 3600 mm
//        
//        for (int i = 0; i < 3; i++) {
//            bomExp.addMaterial(material7);
//        }
//        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 7500);
//        assertEquals(bomExp, bomRes);
//    }
//
//    /**
//     * Test of generateRafter method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGenerateRafter() throws Exception {
//        RoofRaisedCalc raised = new RoofRaisedCalc();
//        PartslistModel bomExp = new PartslistModel();
//        MaterialModel material7 = DAO.getMaterial(7);
//
//        for (int i = 0; i < 4; i++) {
//            bomExp.addMaterial(material7);
//
//        }
//        PartslistModel bomRes = raised.generateRafter(3600, 20);
//        assertEquals(bomExp, bomRes);
//    }
//
//    /**
//     * Test of generateLaths method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGenerateLaths() throws Exception {
//        RoofRaisedCalc raised = new RoofRaisedCalc();
//        PartslistModel bomExp = new PartslistModel();
//        MaterialModel material12 = DAO.getMaterial(12);
//
//        for (int i = 0; i < 13; i++) {
//            bomExp.addMaterial(material12);
//        }
//
//        PartslistModel bomRes = raised.generateLaths(4000, 3600, 20);
//        assertEquals(bomExp, bomRes);
//    }
//
//    /**
//     * Test of getCladding method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGetCladding() throws Exception {
//        RoofRaisedCalc raised = new RoofRaisedCalc();
//        OrderModel order = new OrderModel();
//        order.setWidth(7400);
//        order.setIncline(20);
//        PartslistModel bomExp = new PartslistModel();
//        MaterialModel material8 = DAO.getMaterial(8);
//
//        for (int i = 0; i < 20; i++) {
//            bomExp.addMaterial(material8);
//        }
//        PartslistModel bomRes = raised.getCladding(order);
//        assertEquals(bomExp, bomRes);
//    }
//
//    /**
//     * Test of getCladdingMaterialCount method, of class RoofRaisedCalc.
//     */
//    @Test
//    public void testGetCladdingMaterialCount() throws Exception {
//        RoofRaisedCalc instance = new RoofRaisedCalc();
//        int exp = 5;
////                getCladdingMaterialCount(totalWidth, incline, offset, materialWidth, materialLength)
//        int res = instance.getCladdingMaterialCount(8000, 20, 0, 100, 4800);
//
//        assertEquals(exp, res);
//
//    }
//
//
//}
