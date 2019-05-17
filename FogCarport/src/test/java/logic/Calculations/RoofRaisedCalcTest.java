
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
     * Test of getRoofRaisedMaterials method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofRoofStructure() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material7 = DAO.getMaterial(7);
        MaterialModel material6 = DAO.getMaterial(6);
        MaterialModel material30 = DAO.getMaterial(30);
        MaterialModel material12 = DAO.getMaterial(12);
        MaterialModel material13 = DAO.getMaterial(13);
        MaterialModel material1 = DAO.getMaterial(1);

        material7.setQuantity(7);
        material6.setQuantity(21);
        material30.setQuantity(7);
        material12.setQuantity(12);
        material13.setQuantity(1);
        material1.setQuantity(4);
        
        bomExp.addMaterial(material7);
        bomExp.addMaterial(material6);
        bomExp.addMaterial(material30);
        bomExp.addMaterial(material12);
        bomExp.addMaterial(material13);
        bomExp.addMaterial(material1);

        order.setWidth(3000);
        order.setIncline(20);
        order.setLength(4000);

        PartslistModel bomRes = raised.getRoofStructure(order);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getMaterialsFromlength method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialsFromlength() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        ArrayList<MaterialModel> materials = new ArrayList();
        MaterialModel material7 = DAO.getMaterial(7);
        MaterialModel material6 = DAO.getMaterial(6);
        materials.add(DAO.getMaterial(6)); // length 2400 mm
        materials.add(DAO.getMaterial(7)); // length 3600 mm
        material7.setQuantity(7);
        bomExp.addMaterial(material7);
        material6.setQuantity(1);
        bomExp.addMaterial(material6);

        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 26100);
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
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material7 = DAO.getMaterial(7);
        material7.setQuantity(3);
        bomExp.addMaterial(material7);
        MaterialModel material6 = DAO.getMaterial(6);
        material6.setQuantity(2);
        bomExp.addMaterial(material6);

        PartslistModel bomRes = raised.generateRafter(4600, 20);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of generatefasciaBoards method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGeneratefasciaBoards() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material1 = DAO.getMaterial(1);
        material1.setQuantity(4);
        bomExp.addMaterial(material1);
        MaterialModel material3 = DAO.getMaterial(3);
        material3.setQuantity(2);
        bomExp.addMaterial(material3);

        PartslistModel bomRes = raised.generatefasciaBoards(4500, 35, 7500);
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
        order.setWidth(3800);
        order.setIncline(25);
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material8 = DAO.getMaterial(8);
        MaterialModel material9 = DAO.getMaterial(9);

        material8.setQuantity(12);
        material9.setQuantity(1);
        bomExp.addMaterial(material8);
        bomExp.addMaterial(material9);

        PartslistModel bomRes = raised.generateCladding(order);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of getCladdingMaterialCount method, of class RoofRaisedCalc.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCladdingMaterialCount() throws Exception {
        RoofRaisedCalc instance = new RoofRaisedCalc();
        int exp = 2429;
        int res = instance.getCladdingMaterialCount(2600, 20, 0);
        assertEquals(exp, res);
    }
}
