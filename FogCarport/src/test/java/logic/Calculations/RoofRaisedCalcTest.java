
package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.LoginException;
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
     * Test of getScrews method, of class RoofRaisedCalc.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetScrews() throws Exception {
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
     * Test of getRoofTiles method, of class RoofRaisedCalc.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRoofTiles() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        OrderModel order = new OrderModel();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material33 = DAO.getMaterial(33, helptext);
        MaterialModel material40 = DAO.getMaterial(40, helptext);
        MaterialModel material32 = DAO.getMaterial(32, helptext);

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
        MaterialModel material7 = DAO.getMaterial(7, helptext);
        MaterialModel material12 = DAO.getMaterial(12, helptext);
        MaterialModel material30 = DAO.getMaterial(30, helptext);
        MaterialModel material3 = DAO.getMaterial(3, helptext);

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
        MaterialModel material7 = DAO.getMaterial(7, helptext);
        materials.add(DAO.getMaterial(6, helptext)); // length 2400 mm
        materials.add(DAO.getMaterial(7, helptext)); // length 3600 mm
        material7.setQuantity(3);
        bomExp.addMaterial(material7);

        PartslistModel bomRes = raised.getMaterialsFromlength(materials, 7500);
        assertEquals(bomExp, bomRes);
    }

    @Test
    public void testAddPartslistWithMaterialsQuantity() throws LoginException {
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
     * Test of generateRafter method, of class RoofRaisedCalc.
     */
    @Test
    public void testGenerateRafter() throws Exception {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material7 = DAO.getMaterial(7, helptext);
        material7.setQuantity(4);
        bomExp.addMaterial(material7);

        PartslistModel bomRes = raised.generateRafter(3600, 20);
        assertEquals(bomExp, bomRes);
    }

    /**
     * Test of generatefasciaBoards method, of class RoofRaisedCalc.
     */
    @Test
    public void testGeneratefasciaBoards() throws LoginException {
        RoofRaisedCalc raised = new RoofRaisedCalc();
        PartslistModel bomExp = new PartslistModel();
        MaterialModel material3 = DAO.getMaterial(3, helptext);
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
        MaterialModel material12 = DAO.getMaterial(12, helptext);
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
        MaterialModel material8 = DAO.getMaterial(8, helptext);

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
