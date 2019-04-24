package logic;

import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;

/**
 * Calculates the partslist. Maybe some of this should be in seperate classes?
 * Like, divide shed, roof and bottom into 3 classes once we reach the advanced
 * algorithm.
 */
class PartslistLogic
{

    private static PartslistLogic instance = null;

    public synchronized static PartslistLogic getInstance()
    {
        if (instance == null)
        {
            instance = new PartslistLogic();
        }
        return instance;
    }

    /*
    https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CAR01_HR.pdf
    Malte used this link as a springboard for the simple bill of materials.
    
    Beklædning - 16x100 - Trykimprægneret
    Vindskede - 25x150 - Trykimprægneret
    Lægte - 38x73 - T1
    Stern - 25x150 - Trykimprægneret
    Tag - Tagsten - Beton - 20gr.
    Spær - 45x95 - Reglar
    Rem - 45 x 195 - Spærtræ
    Stolpe - 100x100 - Trykimprægneret
     */
    PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException
    {
        boolean hasShed = false;
        int _height = 0;
        int _length = 0;
        int _width = 0;
        // If any of the inputs are null or empty, then throw an error.
        if (height == null || length == null || width == null || height.isEmpty() || length.isEmpty() || width.isEmpty())
        {
            // Should maybe be something like a ShopException. 
            throw new LoginException("Input fields can't be empty.");
        }
        else // If inputs are okay, we change string to int.
        {
            _height = Integer.parseInt(height);
            _length = Integer.parseInt(length);
            _width = Integer.parseInt(width);
            // Change the CM input from Customer to MM.
            _height = _height * 10;
            _length = _length * 10;
            _width  = _width  * 10;
        }
        if ("y".equals(shed)) // The name of checkbox is shed, the value is "y" if selected. 
        // If the checkbox wasn't selected, then shed == null.
        // So we can check for null by doing it like this.
        // If you do shed.equals("y") then it throws a nullpointerexception.
        {
            hasShed = true;
        }
        // If input is out of bounds, then throw an error. 
        if (_height < 2000 || _height > 3000 || _length < 2400 || _length > 7200 || _width < 2400 || _width > 7200)
        {
            // Should maybe be something like a ShopException.
            throw new LoginException("Fields have to be within bounds.");
        }
        else // Else create the partslist
        {
            PartslistModel bom = new PartslistModel();
            OrderModel order = new OrderModel(_height, _length, _width, hasShed);
            if (hasShed == true) // If they want a shed then add it to the partslist.
            {
                addShed(order, bom);
            }
            addRoof(order, bom);
            addBase(order, bom);
            return bom;
        }
    }

    /*
    Add shed materials to bill of materials.
    Task #26. Malte.
    MaterialModel(int ID, String name, String description, int height, int length, int width)
    int quantity;
    private String helptext;
     */
    private void addShed(OrderModel order, PartslistModel bom)
    {
        /* Screws and misc. */
        MaterialModel stalddørsgreb = new MaterialModel(75, "Stalddørsgreb", "Stalddørsgreb 50x75", 1, 0, 0);
        stalddørsgreb.setHelptext("til dør i skur");
        stalddørsgreb.setQuantity(1);
        stalddørsgreb.setUnit("sæt");
        stalddørsgreb.setPrice(10);
        bom.addMaterial(stalddørsgreb);

        MaterialModel thængsel = new MaterialModel(390, "T-hængsel", "T-Hængsel 390 mm.", 1, 0, 0);
        thængsel.setHelptext("til dør i skur");
        thængsel.setQuantity(2);
        thængsel.setUnit("Stk.");
        thængsel.setPrice(10);
        bom.addMaterial(thængsel);

        MaterialModel skruer70 = new MaterialModel(70, "Skruer70", "4,5 x 70 mm. Skruer 200 stk.", 1, 0, 0);
        skruer70.setHelptext("til montering af yderste bræt ved beklædning");
        skruer70.setQuantity(3);
        skruer70.setUnit("Pk.");
        skruer70.setPrice(10);
        bom.addMaterial(skruer70);

        MaterialModel skruer50 = new MaterialModel(50, "Skruer50", "4,5 x 50 mm. Skruer 350 stk.", 1, 0, 0);
        skruer50.setHelptext("til montering af yderste bræt ved beklædning");
        skruer50.setQuantity(2);
        skruer50.setUnit("Pk.");
        skruer50.setPrice(10);
        bom.addMaterial(skruer50);

        /* Wood */
        MaterialModel bræt210 = new MaterialModel(210, "bræt", "19x100 mm. trykimp. Bræt", 100, 2100, 19);
        bræt210.setHelptext("Beklædning af skur 1 på 2");
        bræt210.setQuantity(148);
        bræt210.setUnit("Stk.");
        bræt210.setPrice(100);
        bom.addMaterial(bræt210);

        MaterialModel løsholt360 = new MaterialModel(360, "løsholt", "45x95 Reglar ubh.", 95, 3600, 45);
        løsholt360.setHelptext("Løsholter i gavle af skur");
        løsholt360.setQuantity(6);
        løsholt360.setUnit("Stk.");
        løsholt360.setPrice(123);
        bom.addMaterial(løsholt360);

        MaterialModel løsholt240 = new MaterialModel(240, "løsholt", "45x95 Reglar ubh.", 95, 2400, 45);
        løsholt240.setHelptext("Løsholter i siderne af skur");
        løsholt240.setQuantity(4);
        løsholt240.setUnit("Stk.");
        løsholt240.setPrice(112);
        bom.addMaterial(løsholt240);
    }

    /*
    Add roof materials to the partslist.
    Task #28. Asger.
     */
    private void addRoof(OrderModel order, PartslistModel bom)
    {
        calculateRoofParts(order, bom);
    }

    private void calculateRoofParts(OrderModel order, PartslistModel bom)
    {
        //Screws, miscellaneous
        MaterialModel raftScrews = new MaterialModel(620, "skrue", "4,5 x 40mm.", 0, 0, 0);
        raftScrews.setHelptext("Skruer til montering af spær på rem");
        raftScrews.setUnit("stk.");
        
        MaterialModel roofScrews = new MaterialModel(621, "skrue", "4,5 x 35mm.", 0, 0, 0);
        roofScrews.setHelptext("Skruer til montering af tagplast på spær");
        roofScrews.setUnit("stk.");
        
        MaterialModel roofScrewRings = new MaterialModel(622, "Tætningsring", "Gummiring 5 cm diameter", 0, 0, 0);
        roofScrewRings.setHelptext("Gummiring til tætning omkring tagskure");
        roofScrewRings.setUnit("stk.");
        
        MaterialModel fittings = new MaterialModel(600, "spærbeslag", "4cm brede beslag m. hul til 6 skruer", 0, 0, 0);
        fittings.setHelptext("Beslag til montering af spær på rem");
        fittings.setUnit("stk.");
        
        MaterialModel fittingConnectors = new MaterialModel(601, "spærbeslag - forlænger", "4cm brede beslag m. hul til 6 skruer", 0, 0, 0);
        fittingConnectors.setHelptext("Beslag til samling af spær hvis taget er længere end en enkelt spær");
        fittingConnectors.setUnit("stk.");
        
        //Wood
        MaterialModel rafts = new MaterialModel(680, "spærtræ ubh.", "45x195mm.", 5000, 195, 45);
        rafts.setHelptext("remme, monteres på stolpe");
        rafts.setUnit("stk.");
        
        //Roof
        MaterialModel plasticPanels = new MaterialModel(690, "Plastic tagplade", "Standard plasttag", 1000, 800, 5);
        plasticPanels.setHelptext("Monteres m. 4 skruer + ringe");
        plasticPanels.setUnit("stk.");
        
        /*
        Rules
        
        1 raft pr 800mm (80 cm) width
        1 raft pr 5000mm (500 cm) length
        If the carport is longer than 5m (5000mm): +2 fitting connector pr. main raft,
        +6 raft
        */
    }
    
    /*
    Add base parts to full list of parts
    Task #31. Runi.
     */
    private void addBase(OrderModel order, PartslistModel bom)
    {
        calculateBaseParts(order, bom); //Calculate items always required for project.
    }

    /**
     *
     * Calculates the parts needed to build the base-part of the carport
     *
     * @param order
     * @return
     */
    private void calculateBaseParts(OrderModel order, PartslistModel bom)
    {
        /* Screws, miscellaneous*/
        MaterialModel strapScrews = new MaterialModel(999, "std. skrue", "4,5 x 60mm.", 0, 0, 0);
        strapScrews.setHelptext("Skruer til montering af rem og stolpe");
        strapScrews.setUnit("stk.");

        MaterialModel strapBolts = new MaterialModel(998, "bræddebolt", "10 x 120mm.", 0, 0, 0);
        strapBolts.setHelptext("Bolte til montering af rem og stolpe");
        strapBolts.setUnit("stk.");

        /*Wood*/
        MaterialModel post = new MaterialModel(997, "Stolpe", "97x97mm trykimp.", 3000, 97, 97);
        post.setHelptext("nedgraves 90cm i jord");
        post.setUnit("stk.");

        MaterialModel strap = new MaterialModel(996, "spærtræ ubh.", "45x195mm.", 1000, 195, 45);
        strap.setHelptext("remme, monteres på stolpe");
        strap.setUnit("stk.");

        /*Walkthrough
        
        Same rules apply to all orders: 
        
        1 post per 1000mm (100cm) (length)
        1 strap per 500mm (50cm) (height) AND per post (1000mm)
        4 screws per strap
        2 bolts per strap
        
            EXAMPLE for generating a full carport base:
            We only generate for 3 sides, as the 4th side should be open for the car to access.
        
            Carport height of 2100mm.
            Carport length of 3200mm.
            Carport width of 2200mm.
        
            RULE: Normally we calculate too many posts, as ONE corner post accounts for TWO posts. Therefore, for every corner post we remove one post from the 
        
                postAmountLength = (length/1000) = (3200/1000) = 3,2 = 3 posts. //amount of posts per one(!) carport length
        
                postAmountWidth = (width/1000) = (2200/1000) = 2,2 = 2 posts. //amount of posts per one(!) carport width
                
                    totalPostAmount = ((postAmountLength*2)+postAmountWidth) = ((3*2)+2) = 8 posts. //there are two lengths, one width.
        
                        Due to the above rule we have to remove TWO posts, as there are two corner posts.
                    totalPostAmount = totalPostAmount - 2; // = 6 posts
        
                strapAmount = (height/500) = (2100/500) = 4,2 = 4 straps. //amount of straps for one post-to-post length (100cm)
                However, we want the extra .2 for the customer to adjust and apply themselves. We do this using Math.ceil(). Please refer to the calculateStraps() method.
                    totalStrapAmount = (strapAmount*totalPostAmount) = (4*6) = 24 straps. //
        
                screwAmount = (totalStrapAmount*4) = (24*4) = 96.
                boltAmount = (totalStrapAmount*2) = (24*2) = 48.
            
         */
        
        /* Calculate quantities */
        int postAmount = calculatePosts(order);
        int strapAmount = calculateStraps(order, postAmount);
        int screwAmount = calculateScrews(strapAmount);
        int boltAmount = calculateBolts(strapAmount);

        /* Update quantities */
        post.setQuantity(postAmount);
        strap.setQuantity(strapAmount);
        strapScrews.setQuantity(screwAmount);
        strapBolts.setQuantity(boltAmount);

        /* Update prices based on quantities */
        strapScrews.setPrice(1 * strapScrews.getQuantity()); //1 screw is 1 DKK
        strapBolts.setPrice(5 * strapBolts.getQuantity()); //1 bolt is 5 DKK
        post.setPrice(175 * post.getQuantity()); //1 post is 175 DKK
        strap.setPrice(95 * strap.getQuantity()); // 1 strap is 95 DKK

        /* Add materials to master list */
        bom.addMaterial(strapScrews);
        bom.addMaterial(strapBolts);
        bom.addMaterial(post);
        bom.addMaterial(strap);

    }

    /**
     * Calculates amount of posts required for the carport.
     *
     * @param order order in question
     * @return amount of posts
     */
    private int calculatePosts(OrderModel order)
    {
        int length = order.getLength();
        int width = order.getWidth();

        int postAmountLength = (length / 1000); //amount of posts for one length. one post per meter. 

        int postAmountWidth = (width / 1000); //amount of posts for one width. one post per meter.

        int totalPostAmount
                = ((postAmountLength * 2) + postAmountWidth); //there are two lengths, one width. (Because the last width needs to be open for car access)

        //we have to remove TWO posts, as there are two corner posts.
        totalPostAmount -= 2; // = 6 posts

        return totalPostAmount;
    }

    /**
     * Calculates amount of straps required for the carport.
     *
     * @param order order in question
     * @param postAmount amount of posts
     * @return amount of straps
     */
    private int calculateStraps(OrderModel order, int postAmount)
    {
        int height = order.getHeight();

        double strapAmount = (height / 500); //amount of straps for one post-to-post length (100cm). One strap needed per 50cm of height.
        int strapAmountRoundedUp = (int) Math.ceil(strapAmount); //We round up the strap amount so that the full strap length is covered. (customer must customize this themselves)
        int totalStrapAmount = (strapAmountRoundedUp * postAmount); //Total amount of straps calculated for all posts, for the whole carport.

        return totalStrapAmount;
    }

    /**
     * Calculates amount of screws required for the carport.
     *
     * @param strapAmount carport amount of straps. (screws are dependant on
     * straps)
     * @return amount of screws
     */
    private int calculateScrews(int strapAmount)
    {
        int screwAmount = (strapAmount * 4); //always 4 screws per strap.
        return screwAmount;
    }

    /**
     * Calculates amount of bolts required for the carport.
     *
     * @param strapAmount carport amount of straps. (bolts are dependant on
     * straps)
     * @return amount of bolts
     */
    private int calculateBolts(int strapAmount)
    {
        int boltAmount = (strapAmount * 2); //always 2 screws per strap
        return boltAmount;
    }

}
