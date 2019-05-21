
package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.DataException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

/**
 *
 * @author 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class BaseCalcTest
{
    //The IDs of the materials in the DB
    private final int postID = 4;
    private final int strapID = 54;
    private final int boltID = 24;
    
    //DataFacade needed to fetch materials from DB
    private DataFacade db = DataFacadeImpl.getInstance();
    
    //The instance of the Base Calculator has to be static for the test to work. 
    //Otherwise a new instance will be made every time a test runs which will make 
    //other tests fail because some internal fields in the instance will be reset
    private static BaseCalc bc = new BaseCalc();
    
    //These are the fields used by all the tests. These fields are updated by the 
    //parameters in the Collection below
    private MaterialModel post;
    private MaterialModel strap;
    private MaterialModel bolts;
    private PartslistModel bom;
    private OrderModel order;
    private int expectedBolts, strapAmount, expectedStraps, expectedPosts, cLength, cWidth, sLength, sWidth, postDistance;
    
    //This String is used when we fetch materials from the DB
    private final String helptext = "base";

    //Collection of parameters used by the constructor to update the test values 
    //which the test methods use
    @Parameterized.Parameters
    public static Collection getTestParameters() {
        return Arrays.asList(new Object[][]{
            //bolts, strapsx2, posts, measurements
            /*0*/{20, 3, 3, 10, 7500, 3000, 200, 2000, 2750}, /*1*/{20, 3, 3, 10, 7500, 2000, 200, 1200, 2750}, 
            /*2*/{20, 3, 3, 11, 7500, 3000, 200, 3000, 2750}, /*3*/{20, 3, 3, 10, 7500, 2000, 200, 2000, 2750},
            /*4*/{12, 3, 3, 7, 5500, 4000, 1950, 4000, 2750}, /*5*/{12, 3, 3, 8, 5500, 5000, 1950, 1500, 2750},
            /*6*/{20, 3, 3, 10, 7500, 3000, 200, 3000, 3100}, /*7*/{20, 3, 3, 10, 7500, 3000, 200, 1500, 3100},
            /*8*/{12, 1, 1, 4, 2000, 2000, 0, 0, 3100},       /*9*/{20, 4, 4, 8, 7500, 3100, 0, 0, 3100}
        });
    }

    //constructor uses @Parameters
    public BaseCalcTest(int n0, int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8) throws Exception {
        expectedBolts = n0;
        strapAmount = n1;
        expectedStraps = n2;
        expectedPosts = n3;
        cLength = n4;
        cWidth = n5;
        sLength = n6;
        sWidth = n7;
        postDistance = n8;
        order = new OrderModel(2100, n4, n5);
        order.setShed_length(n6);
        order.setShed_width(n7);
        bom = new PartslistModel();
        if (n8 == 3100)
        {
            order.setIncline(0);
        }
        else
        {
            order.setIncline(15);
        }
        try
        {
            post = db.getMaterial(postID, "base");
            strap = db.getMaterial(strapID, "base");
            bolts = db.getMaterial(boltID, "base");
        } catch (DataException ex)
        {
            System.out.println("Test class for base calculator failed to access DB");
            Logger.getLogger(BaseCalcTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        post.setQuantity(n3);
        strap.setQuantity(n2);
        bolts.setQuantity(n0);
        bom.addMaterial(post);
        bom.addMaterial(strap);
        bom.addMaterial(bolts);
    }
    
    /**
     * This test tests the calculation of posts.
     * The Base Algorithm calculates the amount of posts needed in the carport base construction. 
     * This test tests the method that calculate the amount of posts needed to build a carport 
     * with the given dimensions. The method needs the dimensions of the carport as well as 
     * the maximum distance allowed between two posts (this distance is calculated by the 
     * main method based on the type of roof chosen by the user)
     */
    @Test
    public void test1CalcPosts()
    {
        int result = bc.calcPosts(cLength, cWidth, sLength, sWidth, postDistance);
        assertEquals(expectedPosts, result);
    }
    
    /**
     * This test tests the first material added to the Partslist in the Base Algorithm.
     * This test tests the first material out of three materials added to the Partslist
     * @throws Exception 
     */
    @Test
    public void testAddBaseFirstMat() throws Exception
    {
        PartslistModel result = bc.addBase(order);
        assertEquals(bom.getBillOfMaterials().get(0).getQuantity(), result.getBillOfMaterials().get(0).getQuantity());
    }
    
    /**
     * This test tests the second material added to the Partslist in the Base Algorithm.
     * This test tests the second material out of three materials added to the Partslist
     * @throws Exception 
     */
    @Test
    public void testAddBaseSecondMat() throws Exception
    {
        PartslistModel result = bc.addBase(order);
        assertEquals(bom.getBillOfMaterials().get(1).getQuantity(), result.getBillOfMaterials().get(1).getQuantity());
    }
    
    /**
     * This test tests the third material added to the Partslist in the Base Algorithm.
     * This test tests the third material out of the three materials added to the Partslist
     * @throws Exception 
     */
    @Test
    public void testAddBaseThirdMat() throws Exception
    {
        PartslistModel result = bc.addBase(order);
        assertEquals(bom.getBillOfMaterials().get(2).getQuantity(), result.getBillOfMaterials().get(2).getQuantity());
    }
    
    /**
     * This test tests the calculation of straps.
     * The method that calculates the amount straps needed in the base construction 
     * needs the dimensions of the carport as well as a MaterialModel that holds the dimensions 
     * of the strap that is used to build the base construction
     */
    @Test
    public void test2CalcStraps()
    {
        int result = bc.calcStraps(cLength, cWidth, strap);
        assertEquals(expectedStraps, result);
    }

    /**
     * This tests tests the calculation of bolts.
     * This method must run after test2CalcStraps() has run. The method that calculates the amount of
     * bolts needs information created by the method that calculates the amount of 
     * straps - hence the name "test3" and "test2". 
     */
    public void test3CalcBolts()
    {
        int result = bc.calcBolts(strapAmount);
        assertEquals(expectedBolts, result);
    }
    
}
