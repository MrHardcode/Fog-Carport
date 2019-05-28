package logic;

import data.models.MaterialModel;
import data.models.PartslistModel;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * No longer in used (Was used to test PartslistLogic (The "simple algorithm")
 * for roof_flat_calc.
 *
 * @author runin
 */
@Deprecated
@Ignore("Ignoring deprecated test [PartslistLogicTest].")
public class PartslistLogicTest
{

    /* Screws, miscellaneous*/
    MaterialModel strapScrews = new MaterialModel(999, "std. skrue", "4,5 x 60mm.", 0, 0, 0);
    MaterialModel strapBolts = new MaterialModel(998, "bræddebolt", "10 x 120mm.", 0, 0, 0);


    /*Wood*/
    MaterialModel post = new MaterialModel(997, "Stolpe", "97x97mm trykimp.", 97, 3000, 97);
    MaterialModel strap = new MaterialModel(996, "spærtræ ubh.", "45x195mm.", 195, 6000, 45);

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
     * Test of getSimpleBOM method, of class PartslistLogic.
     */
    @Test
    public void testGetSimpleBOM() throws Exception
    {
        String height = "210"; //cm
        String length = "320"; //cm
        String width = "240"; //cm -- i usually test at 2200mm but had to check at 2400mm due to restrictions. (partslistlogic line 65)
        String shed = "n";
        //String heightmm = "2100"; //mm for testing
        String lengthMM = "3200"; //mm for testing
        String widthMM = "2400"; //mm for testing
        PartslistLogic instance = new PartslistLogic();
        PartslistModel expResult = new PartslistModel();

        /*
        1 post per 1000mm (100cm/1m) (length)
        1 strap per side of the carport (4x) AND per 6000cm (600cm/6m) 
        4 screws per strap
        2 bolts per strap
         */
        int postAmountLength = Integer.parseInt(lengthMM) / 1000; //per meter
        int postAmountWidth = Integer.parseInt(widthMM) / 1000; //per meter
        int totalPostAmount = (postAmountLength * 2) + postAmountWidth; //3 of 4 sides needs to be covered
        totalPostAmount = totalPostAmount - 2; //due to corner posts we remove two posts from total count

        double strapAmount = ((double) (Integer.parseInt(lengthMM)) / 6000); //amount of straps. One strap needed per 600cm/6m of length.
        int strapAmountRoundedUp = (int) Math.ceil(strapAmount); //We round up the strap amount so that the full strap length is covered. (customer must customize this themselves)
        int totalStrapAmount = (strapAmountRoundedUp * 4); //Total amount of straps calculated for all posts, for the whole carport. There are 4 sides of which all need straps.

        /* Update quantity */
        post.setQuantity(totalPostAmount);
        strap.setQuantity(totalStrapAmount);
        strapScrews.setQuantity(totalStrapAmount * 4); //4 per strap
        strapBolts.setQuantity(totalStrapAmount * 2); //2 per strap

        /* Update prices based on quantities */
        strapScrews.setPrice(1 * strapScrews.getQuantity()); //1 screw is 1 DKK
        strapBolts.setPrice(5 * strapBolts.getQuantity()); //1 bolt is 5 DKK
        post.setPrice(175 * post.getQuantity()); //1 post is 175 DKK
        strap.setPrice(95 * strap.getQuantity()); // 1 strap is 95 DKK

        /* Add materials */
        expResult.addMaterial(post);
        expResult.addMaterial(strap);
        expResult.addMaterial(strapScrews);
        expResult.addMaterial(strapBolts);

        PartslistModel result = instance.getSimpleBOM(height, length, width, shed);

        /* Testing */
        //assertEquals(expResult, result);
        assertTrue(expResult.getBillOfMaterials().containsAll(result.getBillOfMaterials())); //did everything go as planned?

        /* is algorithm and test case the same? (see output)*/
        //expResult display
        System.out.println("Expected (test):");
        for (MaterialModel material : expResult.getBillOfMaterials())
        {
            System.out.println("\n      " + material.toString());
        }
        System.out.println("Expected total price: " + expResult.getTotalprice());
        System.out.println("________\nResult (algorithm): ");
        //result display
        for (MaterialModel material : result.getBillOfMaterials())
        {
            System.out.println("\n      " + material.toString());
        }
        System.out.println("Result total price: " + result.getTotalprice());

        /*Is size the same? */
        assertEquals(expResult.getBillOfMaterials().size(), result.getBillOfMaterials().size()); //size is the same?
        //if size (tested above) is the same, lets test and compare their quantities
        for (int i = 0; i < result.getBillOfMaterials().size(); i++)
        {
            assertEquals(result.getBillOfMaterials().get(i).getQuantity(), expResult.getBillOfMaterials().get(i).getQuantity());
        }

        /*Is input order the same?*/
        assertTrue(expResult.getBillOfMaterials().containsAll(result.getBillOfMaterials()));
        assertEquals(result.getBillOfMaterials().get(0), expResult.getBillOfMaterials().get(0));
        assertEquals(result.getBillOfMaterials().get(1), expResult.getBillOfMaterials().get(1));
        assertEquals(result.getBillOfMaterials().get(2), expResult.getBillOfMaterials().get(2));
        assertEquals(result.getBillOfMaterials().get(3), expResult.getBillOfMaterials().get(3));

    }
}
