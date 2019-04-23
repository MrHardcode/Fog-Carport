/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author runin
 */
public class PartslistLogicTest
{

    /* Screws, miscellaneous*/
    MaterialModel strapScrews = new MaterialModel(999, "std. skrue", "4,5 x 60mm.", 0, 0, 0);
    MaterialModel strapBolts = new MaterialModel(998, "bræddebolt", "10 x 120mm.", 0, 0, 0);


    /*Wood*/
    MaterialModel post = new MaterialModel(997, "Stolpe", "97x97mm trykimp.", 3000, 97, 97);
    MaterialModel strap = new MaterialModel(996, "spærtræ ubh.", "45x195mm.", 6000, 195, 45);

    public PartslistLogicTest()
    {
        strapScrews.setHelptext("Skruer til montering af rem og stolpe");
        strapScrews.setUnit("stk.");

        strapBolts.setHelptext("Bolte til montering af rem og stolpe");
        strapBolts.setUnit("stk.");

        post.setHelptext("nedgraves 90cm i jord");
        post.setUnit("stk.");

        strap.setHelptext("remme, monteres på stolpe");
        strap.setUnit("stk.");
    }

    /**
     * Test of getInstance method, of class PartslistLogic.
     */
    @Test
    public void testGetInstance()
    {
        System.out.println("getInstance");
        PartslistLogic expResult = null;
        PartslistLogic result = PartslistLogic.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSimpleBOM method, of class PartslistLogic.
     */
    @Test
    public void testGetSimpleBOM() throws Exception
    {
        System.out.println("getSimpleBOM");
        String height = "2100";
        String length = "3200";
        String width = "2200";
        String shed = "n";
        PartslistLogic instance = new PartslistLogic();
        PartslistModel expResult = new PartslistModel();

        /*
        1 post per 1000mm (100cm/1m) (length)
        1 strap per side of the carport (4x) AND per 6000cm (600cm/6m) 
        4 screws per strap
        2 bolts per strap
        */
        int postAmountLength = Integer.parseInt(length) / 1000; //per meter
        int postAmountWidth = Integer.parseInt(width) / 1000; //per meter
        int totalPostAmount = (postAmountLength * 2) + postAmountWidth; //3 of 4 sides needs to be covered
        totalPostAmount = totalPostAmount - 2; //due to corner posts we remove two posts
        for (int i = 0; i < totalPostAmount; i++)
        {
            expResult.addMaterial(post);
        }

        PartslistModel result = instance.getSimpleBOM(height, length, width, shed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBase method, of class PartslistLogic.
     */
    @Test
    public void testAddBase()
    {
        System.out.println("addBase");
        OrderModel order = null;
        PartslistModel bom = null;
        PartslistLogic instance = new PartslistLogic();
        instance.addBase(order, bom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
