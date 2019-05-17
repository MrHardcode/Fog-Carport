
package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
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
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofRoofStructure() throws Exception {
        System.out.println("START OF METHOD CALL for GetRoofRoofStructure");
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
        System.out.println("END OF METHOD CALL");
        System.out.println(" ");
        System.out.println(" ");
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialsFromlength() throws Exception {
        System.out.println("START OF METHOD CALL for GetMaterialsFromlength");
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();
        MaterialModel material7 = DAO.getMaterial(7);
        materials.add(DAO.getMaterial(6)); // length 2400 mm
        materials.add(DAO.getMaterial(7)); // length 3600 mm
        material7.setQuantity(3);
        bomExp.addMaterial(material7);

        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 7500);
        
//        System.out.println("***************************************");
//        for (int i = 0; i < bomRes.getBillOfMaterials().size(); i++) {
//            System.out.println("***");
//            System.out.println("Material ID: " + bomRes.getBillOfMaterials().get(i).getID());
//            System.out.println("Material Quantity: " + bomRes.getBillOfMaterials().get(i).getQuantity());
//            System.out.println("Length of same materials combined: " + bomRes.getBillOfMaterials().get(i).getLength()*bomRes.getBillOfMaterials().get(i).getQuantity());
//            
//        }
//        System.out.println("***************************************");
        System.out.println("END OF METHOD CALL");
        System.out.println(" ");
        System.out.println(" ");
        assertEquals(bomExp, bomRes);
    }

    @Test
    public void testAddPartslistWithMaterialsQuantity() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();

        PartslistModel bomExp = new PartslistModel();
        MaterialModel material12E = DAO.getMaterial(12);
        MaterialModel material30E = DAO.getMaterial(30);
        MaterialModel material3E = DAO.getMaterial(3);
        material12E.setQuantity(9);
        material30E.setQuantity(9);
        material3E.setQuantity(9);
        bomExp.addMaterial(material12E);
        bomExp.addMaterial(material30E);
        bomExp.addMaterial(material3E);
        
        PartslistModel bomRes = new PartslistModel();
        MaterialModel material12R = DAO.getMaterial(12);
        MaterialModel material30R = DAO.getMaterial(30);
        MaterialModel material3R = DAO.getMaterial(3);
        material12R.setQuantity(4);
        material30R.setQuantity(3);
        material3R.setQuantity(7);
        bomRes.addMaterial(material12R);
        bomRes.addMaterial(material30R);
        bomRes.addMaterial(material3R);
        
        PartslistModel bomAdd = new PartslistModel();
        MaterialModel material12A = DAO.getMaterial(12);
        MaterialModel material30A = DAO.getMaterial(30);
        MaterialModel material3A = DAO.getMaterial(3);
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
     * Test of generateRafter method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGenerateRafter() throws Exception {
        System.out.println("START OF METHOD CALL for GenerateRafter");
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material7 = DAO.getMaterial(7);
        material7.setQuantity(4);
        bomExp.addMaterial(material7);

        PartslistModel bomRes = raised.generateRafter(3600, 20);
        System.out.println("END OF METHOD CALL");
        System.out.println(" ");
        System.out.println(" ");
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of generatefasciaBoards method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGeneratefasciaBoards() throws Exception {
        System.out.println("START OF METHOD CALL for GeneratefasciaBoards");
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material3 = DAO.getMaterial(3);
        material3.setQuantity(4);
        bomExp.addMaterial(material3);

        PartslistModel bomRes = raised.generatefasciaBoards(3600, 20, 4000);
        System.out.println("END OF METHOD CALL");
        System.out.println(" ");
        System.out.println(" ");
        assertEquals(bomExp, bomRes);

    }

    /**
     * Test of generateLaths method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGenerateLaths() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material12 = DAO.getMaterial(12);
        material12.setQuantity(19);
        bomExp.addMaterial(material12);
        MaterialModel material13 = DAO.getMaterial(13);
        material13.setQuantity(1);
        bomExp.addMaterial(material13);

        PartslistModel bomRes = raised.generateLaths(6100, 3700, 20);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getCladding method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
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
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCladdingMaterialCount() throws Exception {
        RoofRaisedCalc instance = new RoofRaisedCalc();
        int exp = 5;
        int res = instance.getCladdingMaterialCount(8000, 20, 0, 100, 4800);
        assertEquals(exp, res);

    }

}
