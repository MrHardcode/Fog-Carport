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
    private final int postID = 4;
    private final int strapID = 54;
    private final int boltID = 24;
    private DataFacade db = DataFacadeImpl.getInstance();
    private static BaseCalc bc = new BaseCalc();
    private MaterialModel post;
    private MaterialModel strap;
    private MaterialModel bolts;
//    static int count = 0;
    private PartslistModel bom;
    private OrderModel order;
    private int expectedBolts, strapAmount, expectedStraps, expectedPosts, cLength, cWidth, sLength, sWidth, postDistance;

    @Parameterized.Parameters
    public static Collection getTestParameters() {
        return Arrays.asList(new Object[][]{
            //bolts, strapsx2, posts, measurements
            /*0*/{20, 3, 3, 10, 7500, 3000, 200, 2000, 2750}, /*1*/{20, 3, 3, 10, 7500, 2000, 200, 1200, 2750}, 
            /*2*/{20, 3, 3, 11, 7500, 3000, 200, 3000, 2750}, /*3*/{20, 3, 3, 10, 7500, 2000, 200, 2000, 2750},
            /*4*/{12, 3, 3, 7, 5500, 4000, 1950, 4000, 2750}, /*5*/{12, 3, 3, 8, 5500, 5000, 1950, 1500, 2750},
            /*6*/{20, 3, 3, 10, 7500, 3000, 200, 3000, 3100}, /*7*/{20, 3, 3, 10, 7500, 3000, 200, 1500, 3100},
            /*8*/{12, 1, 1, 4, 2000, 2000, 0, 0, 3100}, /*9*/{20, 4, 4, 8, 7500, 3100, 0, 0, 3100}
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
            post = db.getMaterial(postID);
            strap = db.getMaterial(strapID);
            bolts = db.getMaterial(boltID);
        } catch (LoginException ex)
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
    
    @Test
    public void test1CalcPosts()
    {
        int result = bc.calcPosts(cLength, cWidth, sLength, sWidth, postDistance);
        assertEquals(expectedPosts, result);
    }
    
    @Test
    public void testAddBaseFirstMat() throws Exception
    {
        PartslistModel result = bc.addBase(new PartslistModel(), order);
//        System.out.println("Orderdetails test nr." + count + ": \nOrder length: " + order.getLength() 
//                            + "\nOrder width: " + order.getWidth()
//                            + "\nShed length: " + order.getShed_length()
//                            + "\nShed width: " + order.getShed_width()
//                            + "\nPost distance: " + postDistance + "\n");
//        ++count;
        assertEquals(bom.getBillOfMaterials().get(0).getQuantity(), result.getBillOfMaterials().get(0).getQuantity());
    }
    
    @Test
    public void testAddBaseSecondMat() throws Exception
    {
        PartslistModel result = bc.addBase(new PartslistModel(), order);
        assertEquals(bom.getBillOfMaterials().get(1).getQuantity(), result.getBillOfMaterials().get(1).getQuantity());
    }
    
    @Test
    public void testAddBaseThirdMat() throws Exception
    {
        PartslistModel result = bc.addBase(new PartslistModel(), order);
        assertEquals(bom.getBillOfMaterials().get(2).getQuantity(), result.getBillOfMaterials().get(2).getQuantity());
    }
    
    @Test
    public void test2CalcStraps()
    {
        int result = bc.calcStraps(cLength, cWidth, strap);
        assertEquals(expectedStraps, result);
    }

    public void test3CalcBolts()
    {
        int result = bc.calcBolts(strapAmount);
        assertEquals(expectedBolts, result);
    }
    
}
