package logic;

import data.exceptions.DataException;
import data.exceptions.UserException;
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
    
    PartslistModel getBOM() throws UserException, DataException {
        PartslistModel bom = new PartslistModel();
        
//        OrderModel order = OrderMapper.getInstance().getOrder(2);
        
        
        
        
        return bom;
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
    PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws UserException
    {
        boolean hasShed = false;
        int _height = 0;
        int _length = 0;
        int _width = 0;
        // If any of the inputs are null or empty, then throw an error.
        if (height == null || length == null || width == null || height.isEmpty() || length.isEmpty() || width.isEmpty())
        {
            // Should maybe be something like a ShopException. 
            throw new UserException("Input felterne må ikke være tomme.");
        }
        else // If inputs are okay, we change string to int.
        {
            _height = Integer.parseInt(height);
            _length = Integer.parseInt(length);
            _width = Integer.parseInt(width);
            // Change the CM input from Customer to MM.
            _height = _height * 10;
            _length = _length * 10;
            _width = _width * 10;
        }
        if ("y".equals(shed)) // The name of checkbox is shed, the value is "y" if selected. 
        // If the checkbox wasn't selected, then shed == null.
        // So we can check for null by doing it like this.
        // If you do shed.equals("y") then it throws a nullpointerexception.
            // delete this
        {
            hasShed = true;
        }
        // If input is out of bounds, then throw an error. 
        if (_height < 2000 || _height > 3000 || _length < 2400 || _length > 7200 || _width < 2400 || _width > 7200)
        {
            // Should maybe be something like a ShopException.
            throw new UserException("Input felterne skal være indenfor kravene");
        }
        else // Else create the partslist
        {
            PartslistModel bom = new PartslistModel();
            OrderModel order = new OrderModel(_height, _length, _width);
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

    /**
     * Used to calculate the amount of materials needed for the roof of a given carport.
     * @param order
     * @param bom 
     */
    private void calculateRoofParts(OrderModel order, PartslistModel bom)
    {
        //Screws, miscellaneous
        MaterialModel trussScrews = new MaterialModel(620, "skrue", "4,5 x 40mm.", 0, 0, 0);
        trussScrews.setHelptext("Skruer til montering af spær på rem");
        trussScrews.setUnit("stk.");
        
        MaterialModel trussBolts = new MaterialModel(623, "bolt", "4,5 x 65mm.", 0, 0, 0);
        trussBolts.setHelptext("Bolt til montering af spær på rem");
        trussBolts.setUnit("stk.");
        
        MaterialModel roofScrews = new MaterialModel(621, "skrue", "4,5 x 35mm.", 0, 0, 0);
        roofScrews.setHelptext("Skruer til montering af tagplast på spær");
        roofScrews.setUnit("stk.");
        
        MaterialModel roofScrewRings = new MaterialModel(622, "tætningsring", "Gummiring 2,2 cm diameter", 0, 0, 0);
        roofScrewRings.setHelptext("Gummiring til tætning omkring tagskure");
        roofScrewRings.setUnit("stk.");
        
        MaterialModel fittings = new MaterialModel(600, "spærbeslag", "Beslag m. hul til 6 skruer", 10, 10, 6);
        fittings.setHelptext("Beslag til montering af spær på rem");
        fittings.setUnit("stk.");
        
        MaterialModel fittingConnectors = new MaterialModel(601, "spærbeslag - forlænger", "Beslag m. hul til 6 skruer", 25, 0, 7);
        fittingConnectors.setHelptext("Beslag til samling af spær hvis taget er længere end en enkelt spær");
        fittingConnectors.setUnit("stk.");
        
        //Wood
        MaterialModel trusses = new MaterialModel(680, "spærtræ ubh.", "45x195mm. spær", 45, 3000, 195);
        trusses.setHelptext("spær, monteres på remmen");
        trusses.setUnit("stk.");
        
        //Roof
        MaterialModel plasticPanels = new MaterialModel(690, "plastic tagplade", "Standard plasttag", 5, 1000, 800);
        plasticPanels.setHelptext("Monteres m. 4 skruer + ringe");
        plasticPanels.setUnit("stk.");
        
        /*
        Rules
        
        1 truss pr 800mm (80 cm) width
        1 truss pr 5000mm (500 cm) length
        If the carport is longer than 5m (5000mm): +2 fitting connectors pr. main truss,
        +12 truss screws
        2 fittings pr truss end (combined trusses for larger carports havde fitting connectors instead)
        3 truss screws pr. truss end (if truss end is in contact with the edge of the roof)
        3 truss bolts pr. truss end (if truss end is in contact with the edge of the roof)
        1 roof panel pr 1m (1000mm) (matches the trusses in width)
        6 roof-screw and 6 roof-screw ring pr. roof panel
        */
        
        /*Calculate quantities*/
        //Trusses
        int mainTrussAmount = calcMainTrusses(order);
        int restTrussAmount = -1;
        if (order.getLength() > trusses.getLength())
        {
            restTrussAmount = calcRest(order, mainTrussAmount, trusses);
        }
        int finalTrussAmount = mainTrussAmount;
        if (restTrussAmount != -1)
        {
            finalTrussAmount += restTrussAmount;
        }
        
        //Roof plastic panels
        int mainRoofPanelAmount = calcRoofPanels(order);
        int restRoofPanelAmount = -1;
        if (order.getLength() > plasticPanels.getLength())
        {
            restRoofPanelAmount = calcRest(order, mainTrussAmount, plasticPanels);
        }
        int finalRoofPanelAmount = mainRoofPanelAmount;
        if (restRoofPanelAmount != -1)
        {
            finalRoofPanelAmount += restRoofPanelAmount;
        }
        
        //Screws and bolts for the trusses
        int trussScrewAmount = calcTrussScrews(mainTrussAmount);
        int trussBoltAmount = calcTrussScrews(mainTrussAmount);
        
        //Screws and rings for the roof panels
        int roofScrewAmount = calcRoofScrews(finalRoofPanelAmount);
        int roofScrewRingAmount = calcRoofScrews(finalRoofPanelAmount);
        if (restRoofPanelAmount != -1)
        {
            //Adding some extra screws for the roof panels
            roofScrewAmount += 2;
            roofScrewRingAmount += 2;
        }
        
        //Fittings for the trusses
        int fittingAmount = calcFittings(mainTrussAmount);
        int fittingConnectorAmount = 0;
        //If the roof is longer than the standard truss length, we need extra fittings to connect to trusses
        if (order.getLength() > trusses.getLength())
        {
            fittingConnectorAmount = calcFittingConnectors(order.getLength(), mainTrussAmount, trusses);
            trussScrewAmount += 6 * fittingConnectorAmount;
        }
        
        /*Update quantities*/
        trusses.setQuantity(finalTrussAmount);
        plasticPanels.setQuantity(finalRoofPanelAmount);
        trussScrews.setQuantity(trussScrewAmount);
        trussBolts.setQuantity(trussBoltAmount);
        roofScrews.setQuantity(roofScrewAmount);
        roofScrewRings.setQuantity(roofScrewRingAmount);
        fittings.setQuantity(fittingAmount);
        if (fittingConnectorAmount > 0)
        {
            fittingConnectors.setQuantity(fittingConnectorAmount);
        }
        
        /*Update prices based on calculated quantities*/
        trusses.setPrice(finalTrussAmount * 95); // 95DKK pr truss
        plasticPanels.setPrice(finalRoofPanelAmount * 21); // 21DKK pr plastic roof panel
        trussScrews.setPrice(trussScrewAmount); // 1DKK pr truss screw
        trussBolts.setPrice(trussBoltAmount * 2); // 2DKK pr truss bolt
        roofScrews.setPrice(roofScrewAmount); // 1DKK pr roof screw
        roofScrewRings.setPrice(roofScrewRingAmount); // 1DKK pr roof screw ring
        fittings.setPrice(fittingAmount * 7); // 7DKK pr fitting
        if (fittingConnectorAmount > 0)
        {
            fittingConnectors.setPrice(fittingConnectorAmount * 7); // 7DKK pr fitting connector
        }
        
        /*Add materials to the BOM*/
        bom.addMaterial(trusses);
        bom.addMaterial(plasticPanels);
        bom.addMaterial(trussScrews);
        bom.addMaterial(trussBolts);
        bom.addMaterial(roofScrews);
        bom.addMaterial(roofScrewRings);
        bom.addMaterial(fittings);
        if (fittingConnectorAmount > 0)
        {
            bom.addMaterial(fittingConnectors);
        }
    }
    
    /**
     * Used to calculate the amount of main trusses needed to support the roof of the carport.
     * This method is always used which means that if the carport is shorter than 5000mm 
     * you still get one truss pr every 800mm of width in your carport
     * @param order
     * @return int - amount of main trusses
     */
    private int calcMainTrusses(OrderModel order)
    {
        int width = order.getWidth();
        int trusses = width / 800; //One truss pr 80cm
        if (width % 800 > 0)
        {
            ++trusses;
        }
        return trusses;
    }
    
    /**
     * Used to calculate the amount of extra items needed for the roof of the carport.
     * @param order
     * @param mainTrussAmount
     * @return int - amount of extra trusses
     */
    private int calcRest(OrderModel order, int mainTrussAmount, MaterialModel item)
    {
        int itemLength = item.getLength();
        int restLength = order.getLength() - itemLength; //Length left after the first set of items (e.g. trusses)
        
        int extraItem = 0;
        if (restLength > itemLength)
        {
            extraItem += (restLength / itemLength) * mainTrussAmount;
        }
        //Calculating the rest of the length where a truss would extend beyond the carport's total length
        restLength = order.getLength() % itemLength; 
        //If there is any extra length left, we calculate the amount of extra items for this length
        if (restLength > 0)
        {
            extraItem += calcAbsoluteRest(restLength, mainTrussAmount, itemLength);
        }
        return extraItem;
    }
    
    private int calcAbsoluteRest(int restLength, int mainTrussAmount, int itemLength)
    {
        int extraItems = 0;
        //If the restLength is greater than half of the item's length, we give the customer 
        //an extra item (e.g. an extra truss) pr. main truss in the roof construction
        if (restLength > itemLength / 2)
        {
            extraItems = mainTrussAmount;
        } 
        else
        {
            int remainingTrusses = mainTrussAmount;
            int count = 0;
            //Counting the amount of times a single item can be cut up to cover the full 
            //remaining length in the roof
            count = itemLength / restLength;
            while (remainingTrusses > 0)
            {
                remainingTrusses -= count;
                ++extraItems;
            }
        }
        return extraItems;
    }
    
    /**
     * Used to calculate the amount of roof panels in the first row of the roof.
     * If the customer somehow manages to order a carport that is shorter than 1000mm 
     * they will still recieve one roof panel pr. 80cm width
     * @param order
     * @return amount
     */
    private int calcRoofPanels(OrderModel order)
    {
        int width = order.getWidth();
        int panels = width / 800; //One roof panel pr 80cm
        return panels;
    }
    
    /**
     * Used to calculate the amount of screws used to fasten the trusses on the strap.
     * @param mainTrussAmount
     * @return amount
     */
    private int calcTrussScrews(int mainTrussAmount)
    {
    //3 screws pr. truss (if truss has contact with the edge (hence the * 2 since there are two ends))
        int screws = mainTrussAmount * 3 * 2;
        return screws;
    }
    
    /**
     * Used to calculate the amount of screws needed to fasten the plastic roof panels to the trusses.
     * This method is also used for the calculation of the roof screw rings, since the screws and rings 
     * are used in pairs
     * @param finalRoofPanelAmount
     * @return amount
     */
    private int calcRoofScrews(int finalRoofPanelAmount)
    {
        //6 screws pr roof panel
        int screws = finalRoofPanelAmount * 6;
        return screws;
    }
    
    /**
     * Used to calculate the amount of fittings needed to fasten the trusses on the strap.
     * @param mainTrussAmount
     * @return amount
     */
    private int calcFittings(int mainTrussAmount)
    {
        //2 fittings pr. truss end. The trusses have ends on both sides of the roof, hence * 4
        int fittings = mainTrussAmount * 4;
        return fittings;
    }
    
    /**
     * Used to calculate the amount of fitting connectors needed to combine the trusses in the roof.
     * @param length
     * @param mainTrussAmount
     * @param trusses
     * @return amount
     */
    private int calcFittingConnectors(int length, int mainTrussAmount, MaterialModel trusses)
    {
        int connections = length / trusses.getLength();
        int fittingConnectors = connections * mainTrussAmount * 2; //2 fitting connectors pr connection
        return fittingConnectors;
    }
    
    
    /**
     * Calculates the parts needed to build the base-part of the carport
     *
     * Add base parts to full list of parts Task #31: Runi.
     *
     * @param order order dimensions for the carport base
     * @param bom the bill of materials of which to add the parts
     */
    void addBase(OrderModel order, PartslistModel bom)
    {
        /* Screws, miscellaneous*/
        MaterialModel strapScrews = new MaterialModel(999, "std. skrue", "4,5 x 60mm.", 0, 0, 0);
        strapScrews.setHelptext("Skruer til montering af rem og stolpe");
        strapScrews.setUnit("stk.");

        MaterialModel strapBolts = new MaterialModel(998, "bræddebolt", "10 x 120mm.", 0, 0, 0);
        strapBolts.setHelptext("Bolte til montering af rem og stolpe");
        strapBolts.setUnit("stk.");

        /*Wood*/
        MaterialModel post = new MaterialModel(997, "Stolpe", "97x97mm trykimp.", 97, 3000, 97);
        post.setHelptext("nedgraves 90cm i jord");
        post.setUnit("stk.");

        MaterialModel strap = new MaterialModel(996, "spærtræ ubh.", "45x195mm.", 195, 6000, 45);
        strap.setHelptext("remme, monteres på stolpe");
        strap.setUnit("stk.");

        /*Walkthrough
        
        Same rules apply to all orders: 
        
        1 post per 1000mm (100cm/1m) (length)
        1 strap per side of the carport (4x) AND per 6000cm (600cm/6m) 
        4 screws per strap
        2 bolts per strap
        
            EXAMPLE for generating a full carport base:
        
            Carport height of 2100mm.
            Carport length of 3200mm.
            Carport width of 2200mm.
        
            RULE: Normally we calculate too many posts, as ONE corner post accounts for TWO posts. Therefore, for every corner post we remove one post from the 
        
                postAmountLength = (length/1000) = (3200/1000) = 3,2 = 3 posts. //amount of posts per one(!) carport length
        
                postAmountWidth = (width/1000) = (2200/1000) = 2,2 = 2 posts. //amount of posts per one(!) carport width
                
                    totalPostAmount = ((postAmountLength*2)+postAmountWidth) = ((3*2)+2) = 8 posts. //there are two lengths, one width.
        
                        Due to the above rule we have to remove TWO posts, as there are two corner posts.
                    totalPostAmount = totalPostAmount - 2; // = 6 posts
        
                strapAmount = (length/6000) = 0,53 = 0 straps.
                        However, we will always use Math.ceil to round up for the customer to adjust and apply themselves. Please refer to the calculateStraps() method.
                        If we have 0.5 we round up to 1.
                        If we have 1.5 we round up to 2. (to take into account the extra length needed)
                    totalStrapAmount = (strapAmount*4) = (1*4) = 4 straps. //carport has 4 sides.
        
        
                screwAmount = (totalStrapAmount*4) = (4*4) = 16.
                boltAmount = (totalStrapAmount*2) = (4*2) = 8.
            
         */
 /* Calculate quantities */
        int postAmount = calculatePosts(order);
        int strapAmount = calculateStraps(order);
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
        bom.addMaterial(post);
        bom.addMaterial(strap);
        bom.addMaterial(strapScrews);
        bom.addMaterial(strapBolts);

    }

    /**
     * Calculates amount of posts ("stolper") required for the carport.
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
     * Calculates amount of straps ("remme") required for the carport.
     *
     * @param order order in question
     * @return amount of straps
     */
    private int calculateStraps(OrderModel order)
    {
        int length = order.getLength();
        double strapAmount = ((double) length / 6000); //amount of straps. One strap needed per 600cm/6m of length.
        int strapAmountRoundedUp = (int) Math.ceil(strapAmount); //We round up the strap amount so that the full strap length is covered. (customer must customize this themselves)
        int totalStrapAmount = (strapAmountRoundedUp * 4); //Total amount of straps calculated for all posts, for the whole carport. There are 4 sides of which all need straps.
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
