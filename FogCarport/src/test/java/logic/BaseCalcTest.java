/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Asger
 */
@RunWith(Parameterized.class)
public class BaseCalcTest
{
    private BaseCalc bc = new BaseCalc();

    private int expected, cLength, cWidth, sLength, sWidth, postDistance;

    @Parameterized.Parameters
    public static Collection getTestParameters() {
        return Arrays.asList(new Object[][]{
            {10, 7500, 3000, 200, 2000, 2750}, {10, 7500, 2000, 200, 1200, 2750}, 
            {11, 7500, 3000, 200, 3000, 2750}, {10, 7500, 2000, 200, 2000, 2750},
            {7, 5500, 4000, 1950, 4000, 2750}, {8, 5500, 5000, 1950, 1500, 2750},
            {10, 7500, 3000, 200, 3000, 3100}, {10, 7500, 3000, 200, 1500, 3100}});
    }

    //constructor uses @Parameters
    public BaseCalcTest(int n1, int n2, int n3, int n4, int n5, int n6) {
        expected = n1;
        cLength = n2;
        cWidth = n3;
        sLength = n4;
        sWidth = n5;
        postDistance = n6;
    }
    
    /**
     * Test of calcPostsRaisedRoof method, of class BaseCalc.
     */
    @Test
    public void testCalcPostsRaisedRoof()
    {
        int result = bc.calcPosts(cLength, cWidth, sLength, sWidth, postDistance);
        assertEquals(expected, result);
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
//    /**
//     * Test of calcPostsFlatRoof method, of class BaseCalc.
//     */
//    @Test
//    public void testCalcPostsFlatRoof()
//    {
//        System.out.println("calcPostsFlatRoof");
//        int cLength = 0;
//        int cWidth = 0;
//        boolean shedContact = false;
//        int sLength = 0;
//        BaseCalc instance = new BaseCalc();
//        int expResult = 0;
//        int result = instance.calcPostsFlatRoof(cLength, cWidth, shedContact, sLength);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of calcStraps method, of class BaseCalc.
//     */
//    @Test
//    public void testCalcStraps()
//    {
//        System.out.println("calcStraps");
//        int cLength = 0;
//        int cWidth = 0;
//        BaseCalc instance = new BaseCalc();
//        int expResult = 0;
//        int result = instance.calcStraps(cLength, cWidth);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of calcBolts method, of class BaseCalc.
//     */
//    @Test
//    public void testCalcBolts()
//    {
//        System.out.println("calcBolts");
//        int postAmount = 0;
//        int strapAmount = 0;
//        BaseCalc instance = new BaseCalc();
//        int expResult = 0;
//        int result = instance.calcBolts(postAmount, strapAmount);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
}
