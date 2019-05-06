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
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

/**
 *
 * @author Asger
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class BaseCalcTest
{
    private final int strapID = 54;
    private DataFacade db = DataFacadeImpl.getInstance();
    private BaseCalc bc;
    private MaterialModel strap;

    private int expectedBolts, strapAmount, expectedStraps, expectedPosts, cLength, cWidth, sLength, sWidth, postDistance;

    @Parameterized.Parameters
    public static Collection getTestParameters() {
        return Arrays.asList(new Object[][]{
            /*0*/{20, 3, 3 ,10, 7500, 3000, 200, 2000, 2750}//, /*1*/{0, 0, 3, 10, 7500, 2000, 200, 1200, 2750}, 
//            /*2*/{0, 0, 3, 11, 7500, 3000, 200, 3000, 2750}, /*3*/{0, 0, 3, 10, 7500, 2000, 200, 2000, 2750},
//            /*4*/{0, 0, 3, 7, 5500, 4000, 1950, 4000, 2750}, /*5*/{0, 0, 3, 8, 5500, 5000, 1950, 1500, 2750},
//            /*6*/{0, 0, 3, 10, 7500, 3000, 200, 3000, 3100}, /*7*/{0, 0, 3, 10, 7500, 3000, 200, 1500, 3100},
//            /*8*/{0, 0, 1, 4, 2000, 2000, 0, 0, 3100}, /*9*/{0, 0, 4, 8, 7500, 3100, 0, 0, 3100}
        });
    }

    //constructor uses @Parameters
    public BaseCalcTest(int n0, int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        expectedBolts = n0;
        strapAmount = n1;
        expectedStraps = n2;
        expectedPosts = n3;
        cLength = n4;
        cWidth = n5;
        sLength = n6;
        sWidth = n7;
        postDistance = n8;
        bc = new BaseCalc();
        try
        {
            strap = db.getMaterial(strapID);
        } catch (LoginException ex)
        {
            System.out.println("Test class for base calculator failed to access DB");
            Logger.getLogger(BaseCalcTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Test of calcPostsRaisedRoof method, of class BaseCalc.
     */
    @Test
    public void test1CalcPosts()
    {
        System.out.println("Test 1");
        int result = bc.calcPosts(cLength, cWidth, sLength, sWidth, postDistance);
        assertEquals(expectedPosts, result);
    }
    
    //    /**
//     * Test of addBase method, of class BaseCalc.
//     */
//    @Test
//    public void testAddBase() throws Exception
//    {
//        System.out.println("addBase");
//        PartslistModel bom = null;
//        OrderModel order = null;
//        BaseCalc instance = new BaseCalc();
//        PartslistModel expResult = null;
//        PartslistModel result = instance.addBase(bom, order);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of calcMaterials method, of class BaseCalc.
//     */
//    @Test
//    public void testCalcMaterials() throws Exception
//    {
//        System.out.println("calcMaterials");
//        PartslistModel bom = null;
//        int cLength = 0;
//        int cWidth = 0;
//        int sLength = 0;
//        int sWidth = 0;
//        boolean heavyRoof = false;
//        DataFacade db = null;
//        BaseCalc instance = new BaseCalc();
//        instance.calcMaterials(bom, cLength, cWidth, sLength, sWidth, heavyRoof, db);
//        fail("The test case is a prototype.");
//    }
    
//
//
    /**
     * Test of calcStraps method, of class BaseCalc.
     */
    @Test
    public void test2CalcStraps()
    {
        System.out.println("Test 2");
        int result = bc.calcStraps(cLength, cWidth, strap);
        assertEquals(expectedStraps, result);
    }

    /**
     * Test of calcBolts method, of class BaseCalc.
     */
    @Test
    public void test3CalcBolts()
    {
        System.out.println("Test 3");
        int result = bc.calcBolts(strapAmount);
        assertEquals(expectedBolts, result);
    }
    
}
