package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.DataException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class BaseCalc
{
    //Post-rules
    private final int postDistanceStandard = 3100;
    private final int postDistanceRaisedRoof = 2750;
    
    //IDs of materials from DB
    private final int postID = 4;
    private final int strapID = 54;
    private final int boltID = 24;
    private final String helptext = "base"; // Used to fetch the right helptext from database.
    
    //Variables used to keep track of things in the algorithm
    private int separations = 0;
    private ArrayList postPosSideOne = new ArrayList();
    private ArrayList postPosSideTwo = new ArrayList();
    private ArrayList postPosRear = new ArrayList();
    
    /**
     * Used to get a Partslist with materials for the base construction.
     * This method creates a Partslist with all the materials needed in the base 
     * construction based on the details in the given order. 
     * @param order Contains the dimensions needed to create the base
     * @return PartslistModel
     * @throws DataException 
     */
    public PartslistModel addBase(OrderModel order) throws DataException
    {
        PartslistModel bom = new PartslistModel();
        DataFacade db = DataFacadeImpl.getInstance();
        
        int carportLength = order.getLength();
        int carportWidth = order.getWidth();
        int shedLength = order.getShed_length();
        int shedWidth = order.getShed_width();
        boolean hasRaisedRoof = false;
        
        if (order.getIncline() > 0)
        {
            hasRaisedRoof = true;
        }
        
        calcMaterials(bom, carportLength, carportWidth, shedLength, shedWidth, hasRaisedRoof, db);
        bom.setPostPosSideOne(postPosSideOne);
        bom.setPostPosSideTwo(postPosSideTwo);
        bom.setPostPosRear(postPosRear);
        return bom;
    }
    
    /**
     * Used by addBase() to add the needed materials to the Partslist.
     * This method gets materials from the DB and modifies the given Partslist 
     * by adding the materials.
     * @param bom PartslistModel
     * @param carportLength int: Length of carport
     * @param carportWidth int: Width of carport
     * @param shedLength int: Length of shed
     * @param shedWidth int: Width of shed
     * @param heavyRoof boolean: Whether or not the roof incline is 0 or above 0 degrees
     * @param db DataFacade
     * @throws DataException 
     */
    protected void calcMaterials(
            PartslistModel bom, 
            int carportLength, int carportWidth, 
            int shedLength, int shedWidth, 
            boolean heavyRoof, 
            DataFacade db) throws DataException
    {
        //97x97mm post
        MaterialModel post = db.getMaterial(postID, helptext);
        int postAmount = 0;
        if (heavyRoof)
        {
            postAmount = calcPosts(carportLength, carportWidth, shedLength, shedWidth, postDistanceRaisedRoof);
        }
        else
        {
            postAmount = calcPosts(carportLength, carportWidth, shedLength, shedWidth, postDistanceStandard);
        }
        post.setQuantity(postAmount);
        bom.addMaterial(post);
        //45x195mm rafter wood
        MaterialModel strap = db.getMaterial(strapID, helptext);
        int strapAmount = calcStraps(carportLength, carportWidth, strap);
        strap.setQuantity(strapAmount);
        bom.addMaterial(strap);
        
        //10x120mm bolts
        MaterialModel bolts = db.getMaterial(boltID, helptext);
        int boltAmount = calcBolts(strapAmount);
        bolts.setQuantity(boltAmount);
        bom.addMaterial(bolts);
    }

    /**
     * Used by calcMaterials() to calculate the amount of Posts needed.
     * This method calculates the amount of posts needed for the base construction. 
     * @param carportLength int: Length of carport
     * @param carportWidth int: Width of carport
     * @param shedLength int: Length of shed
     * @param shedWidth int: Width of shed
     * @param postDistance int: Maximum allowed distance between posts
     * @return int: The amount of posts needed
     */
    protected int calcPosts(int carportLength, int carportWidth, int shedLength, int shedWidth, int postDistance)
    {
        /*SVG related*/
        postPosSideOne.clear();
        postPosSideTwo.clear();
        postPosRear.clear();
        /*SVG related*/
        
        //Total post amount
        int postAmount = 0;
        
        //If the shed length is 0 because there is no shed:
        if (shedLength == 0)
        {
            postAmount = calcPostsNoShed(carportLength, carportWidth, postDistance);
        }
        //If the shed is as wide as the carport:
        else if (shedWidth == carportWidth)
        {
            postAmount = calcPostsFullWidthShed(carportLength, carportWidth, shedLength, postDistance);
        }
        //If the shed's width is shorter than the carport's width:
        else
        {
            postAmount = calcPostsOddShed(carportLength, carportWidth, shedLength, shedWidth, postDistance);
        }
        return postAmount;
    }
    
    /**
     * Used by calcPosts(). 
     * This method is only used in cases where the shed's width is the same 
     * as the width of the carport. 
     * This method calculates the amount of posts needed as well as the positions 
     * of the posts which is used by another part of the program (SVGDrawingBase.java)
     * @param carportLength int: Length of carport
     * @param carportWidth int: Width of carport
     * @param shedLength int: Length of shed
     * @param postDistance int: Maximum allowed distance between posts
     * @return int: The amount of posts needed in the base construction
     */
    private int calcPostsFullWidthShed(int carportLength, int carportWidth, int shedLength, int postDistance)
    {
        /*SVG related*/
        postPosSideOne.clear();
        postPosSideTwo.clear();
        postPosRear.clear();
        /*SVG related*/
        
        //The first posts are always places 800mm from the entrance-end of the carport
        int length = carportLength - 800;
        
        /*SVG related*/
        postPosSideOne.add(80);
        postPosSideTwo.add(80);
        /*SVG related*/
        
        //Posts
        int postAmount = 0;

        /*-------------------------------*/
        /*   Both sides of the carport   */
        /*-------------------------------*/
        //Counter used to count the amount of times a post should be placed 
        //between the front post and the first shed post
        int count = 0;
        //Adding post amount to the counter plus 1 (to include the front post)
        count = ((length - shedLength) / postDistance) + 1;
        
        /*SVG related*/
        if (count > 0)
        {
            for (int i = 1; i < count; i++)
            {
                postPosSideOne.add(80 + i * (postDistance/10));
                postPosSideTwo.add(80 + i * (postDistance/10));
            }
        }
        /*SVG related*/
        
        //If two posts are placed on the same spot, we remove one of them
        //We remove two, since this counts for boths sides (because shed width == carport width)
        if (carportLength - (800 + postDistance * (count - 1)) == shedLength)
        {
            postAmount -= 2;
        }
        //Adding 2 to count because: 
        //1 for the first corner of the shed
        //Another 1 for the second corner of the shed (which is also the corner of the carport)
        count += 2;
        
        /*SVG related*/
        postPosSideOne.add((carportLength / 10) - (shedLength / 10));
        postPosSideOne.add((carportLength / 10));
        postPosSideTwo.add((carportLength / 10) - (shedLength / 10));
        postPosSideTwo.add((carportLength / 10));
        /*SVG related*/
        
        //Adding count to the postAmount twice since the sides of the carport are equal to each other 
        //because the shed has the same width as the carport
        postAmount += count * 2;
        //If the shed is very long we need one or more extra posts
        if ((shedLength / postDistance) > 0)
        {
            //We add the amount twice since the sides of the carport are equal
            postAmount += (shedLength / postDistance) * 2;
            
            /*SVG related*/
            int corner = carportLength - shedLength;
            int x = 0;
            for (int i = carportLength; i > corner; i -= postDistance)
            {
                ++x;
                postPosSideOne.add((carportLength / 10) - x * (postDistance / 10));
                postPosSideTwo.add((carportLength / 10) - x * (postDistance / 10));
            }
            /*SVG related*/
        }
        
        /*-----------------------------*/
        /*   The rear of the carport   */
        /*-----------------------------*/
        //Calculating width. We don't have to think about extra posts for the shed 
        //since the shed has the same width as the carport
        //The corner posts have already been calculated
        if ((carportWidth / postDistance) > 0)
        {
            int x = postAmount;
            
            postAmount += (carportWidth / postDistance);
            
            x = Math.abs(x - postAmount);
            /*SVG related*/
            for (int i = 1; i <= x; i++)
            {
                postPosRear.add(((carportWidth / 10) / (x + 1)) * i);
            }
            /*SVG related*/
        }
        return postAmount;
    }
    
    /**
     * Used by calcPosts(). 
     * This method is only used in cases where the shed's width is shorter than 
     * the width of the carport. 
     * This method calculates the amount of posts needed as well as the positions 
     * of the posts which is used by another part of the program (SVGDrawingBase.java)
     * @param carportLength int: Length of carport
     * @param carportWidth int: Width of carport
     * @param shedLength int: Length of shed
     * @param shedWidth int: Width of shed
     * @param postDistance int: Maximum allowed distance between posts
     * @return int: The amount of posts needed in the base construction
     */
    private int calcPostsOddShed(int carportLength, int carportWidth, int shedLength, int shedWidth, int postDistance)
    {
        /*SVG related*/
        postPosSideOne.clear();
        postPosSideTwo.clear();
        postPosRear.clear();
        /*SVG related*/
        
        //The first posts are always places 800mm from the entrance-end of the carport
        int length = carportLength - 800;
        
        /*SVG related*/
        postPosSideOne.add(80);
        postPosSideTwo.add(80);
        /*SVG related*/
        
        //Posts
        int postAmount = 0;
        
        /*--------------------------------*/
        /*   Second side of the carport   */
        /*--------------------------------*/
        //Counter used to count the amount of times a post should be placed 
        //between the front post and the first shed post
        int count = 0;
        //Adding post amount to the counter plus 1 (to include the front post)
        count = ((length - shedLength) / postDistance) + 1;
        
        /*SVG related*/
        if (count > 0)
        {
            for (int i = 1; i < count; i++)
            {
                postPosSideTwo.add(80 + i * (postDistance/10));
            }
        }
        /*SVG related*/
        
        //If two posts are placed on the same spot, we remove one of them
        if (carportLength - (800 + postDistance * (count - 1)) == shedLength)
        {
            postAmount -= 1;
        }
        //Adding 2 to count: 
        //1 for the first corner of the shed
        //Another 1 for the second corner of the shed (which is also the corner of the carport)
        count += 2;
        
        /*SVG related*/
        postPosSideTwo.add((carportLength / 10) - (shedLength / 10));
        postPosSideTwo.add((carportLength / 10));
        /*SVG related*/
        
        //Adding count to the postAmount
        postAmount += count;
        //If the shed is very long we need one or more extra posts
        if ((shedLength / postDistance) > 0)
        {
            postAmount += (shedLength / postDistance);
            
            if (shedLength % postDistance == 0)
            {
                --postAmount;
            }
            
            /*SVG related*/
            int y = shedLength / postDistance;
            for (int i = 1; i <= y; i++)
            {
                postPosSideTwo.add((Math.abs(shedLength - carportLength) / 10) + (i * (postDistance / 10)));
            }
            /*SVG related*/
        }
        /*-------------------------------*/
        /*   First side of the carport   */
        /*-------------------------------*/
        //Adding the amount of posts for the first side. The + 1 is the front post
        postAmount += (length / postDistance) + 1;
        
        /*SVG related*/
        if (length % postDistance == 0)
        {
            int y = length / postDistance;
            for (int i = 1; i <= y; i++)
            {
                postPosSideOne.add(80 + i * (postDistance/10));
            }
            postPosSideOne.add(carportLength / 10);
        }
        /*SVG related*/
        
        //Adding an extra post if the previous division didn't go up
        if (length % postDistance > 0)
        {
            ++postAmount;
            
            /*SVG related*/
            int y = length / postDistance;
            for (int i = 1; i <= y; i++)
            {
                postPosSideOne.add(80 + i * (postDistance/10));
            }
            postPosSideOne.add(carportLength / 10);
            /*SVG related*/
        }
        /*-----------------------------*/
        /*   The rear of the carport   */
        /*-----------------------------*/
        //Adding one for the corner of the shed
        ++postAmount;
        
        /*SVG related*/
        postPosRear.add(Math.abs((shedWidth / 10) - (carportWidth / 10)));
        /*SVG related*/
        
        //Adding extra posts for the part that the shed is covering if the shed is wide enough
        if (shedWidth / postDistance > 0)
        {
            int x = postAmount;
            int restWidth = carportWidth - shedWidth;
            
            postAmount += (shedWidth / postDistance);
            if (shedWidth % postDistance == 0)
            {
                --postAmount;
            }
            
            x = Math.abs(x - postAmount);
            
            /*SVG related*/
            for (int i = 1; i <= x; i++)
            {
                postPosRear.add((restWidth/ 10) + ((shedWidth / 10) / (x + 1)) * i);
            }
            /*SVG related*/
        }
        int restWidth = carportWidth - shedWidth;
        
        //Adding extra posts for the part that the shed doesn't cover if needed
        if (restWidth / postDistance > 0)
        {
            int x = postAmount;
            postAmount += (restWidth / postDistance);
            if (restWidth % postDistance == 0)
            {
                --postAmount;
            }

            x = Math.abs(x - postAmount);
            /*SVG related*/
            for (int i = 1; i <= x; i++)
            {
                postPosRear.add(((restWidth / 10) / (x + 1)) * i);
            }
            /*SVG related*/
        }
        
        return postAmount;
    }
    
    /**
     * Used by calcPosts(). 
     * This method is only used when the user has chosen a carport without a shed.
     * This method calculates the amount of posts needed as well as the positions 
     * of the posts which is used by another part of the program (SVGDrawingBase.java)
     * @param carportLength int: Length of carport
     * @param carportWidth int: Width of carport
     * @param postDistance int: Maximum allowed distance between posts
     * @return int: The amount of posts needed in the base construction
     */
    private int calcPostsNoShed(int carportLength, int carportWidth, int postDistance)
    {
        /*SVG related*/
        postPosSideOne.clear();
        postPosSideTwo.clear();
        postPosRear.clear();
        /*SVG related*/
        
        //Amount of posts
        int postAmount = 0;
        
        /*SVG related*/
        postPosSideOne.add(80);
        postPosSideTwo.add(80);
        /*SVG related*/
        
        //Calculating the amount of posts between the corner posts in the side. 
        //+2 for the two corners. *2 since the sides are equal.
        postAmount += (((carportLength - 800) / postDistance) + 2) * 2;
        //Calculating the amount of posts between the corner posts in the rear.
        
        /*SVG related*/
        int length = carportLength - 800;
        int y = length / postDistance;
        for (int i = 1; i <= y; i++)
        {
            postPosSideOne.add(80 + i * (postDistance / 10));
            postPosSideTwo.add(80 + i * (postDistance / 10));
        }
        postPosSideOne.add(carportLength / 10);
        postPosSideTwo.add(carportLength / 10);
        /*SVG related*/

        int x = postAmount;
        
        postAmount += carportWidth / postDistance;

        x = Math.abs(x - postAmount);
        if (carportWidth % postDistance == 0)
        {
            --x;
        }
        /*SVG related*/
        for (int i = 1; i <= x; i++)
        {
            postPosRear.add(((carportWidth / 10) / (x + 1)) * i);
        }
        /*SVG related*/

        //If cWidth % postDistance == 0 then the algorithm adds a post for a corner
        //where a post has already been places so we must remove that one extra post
        if (carportWidth % postDistance == 0)
        {
            --postAmount;
        }
        return postAmount;
    }
    
    /**
     * Used by calcMaterials() to calculate the amount of Straps needed.
     * This method calculates the amount of straps needed for the base construction.
     * This method also counts the amount of times a strap has been split (this value 
     * is used by calcBolts())
     * @param carportLength int: Length of carport
     * @param carportWidth int: Width of carport
     * @param strap MaterialModel
     * @return int: The amount of straps needed
     */
    protected int calcStraps(int carportLength, int carportWidth, MaterialModel strap)
    {
        separations = 0;
        //Amount of straps
        int strapAmount = 0;
        boolean skipWidthCalc = false;
        //Calculating the amount of straps for the sides if the carport is shorter 
        //than a strap
        if (carportLength <= strap.getLength())
        {
            //If one strap can cover the whole length of both sides of the carport 
            //then we only need one strap for the sides
            if (carportLength * 2 <= strap.getLength())
            {
                ++strapAmount;
            }
            //If not then we obviously need two
            else
            {
                strapAmount += 2;
            }
        }
        else
        {
            strapAmount += 2;
            int restLength = carportLength - strap.getLength();
            while (true)
            {
                if (restLength < strap.getLength())
                {
                    break;
                }
                strapAmount += 2;
                restLength -= strap.getLength();
            }
            //If one strap can cover the rest of the length in both sides:
            if (restLength * 2 <= strap.getLength())
            {
                ++separations;
                ++strapAmount;
                //If the excess part of the extra strap can cover the carport width 
                //then we just skip the width calculation
                if (strap.getLength() - restLength * 2 >= carportWidth)
                {
                    skipWidthCalc = true;
                    ++separations;
                }
            }
            //If the rest of the length is longer than half of the length of one strap:
            else
            {
                strapAmount += 2;
                //If the excess part of one extra strap can cover the carport width 
                //then we just skip the width calculation
                if ((strap.getLength() - restLength) >= carportWidth)
                {
                    skipWidthCalc = true;
                    ++separations;
                    
                }
            }
        }
        /*   Calculating amount of straps for the rear of the carport */
        if (!skipWidthCalc)
        {
            //Adding an extra strap for the rear of the carport
            ++strapAmount;

            //If the width is longer than one strap we add extra straps using integer division
            if (carportWidth / strap.getLength() > 0)
            {
                strapAmount += carportWidth / strap.getLength();
                //Checking for remainders using modulus. If there is no remainder 
                //we remove one strap
                if (carportWidth % strap.getLength() == 0)
                {
                    --strapAmount;
                }
            }
        }
        //If one strap is enough to cover the whole carport we set strapAmount to 1
        //This if-statement is necessary for the calculation of the bolts
        if ((carportLength * 2 + carportWidth) <= strap.getLength())
        {
            strapAmount = 1;
            separations = 2;
        }
        return strapAmount;
    }

    /**
     * Used by calcMaterials() to calculate the amount of Bolts needed.
     * @param strapAmount int: Amount of straps needed for the base construction
     * @return int: The amount of bolts needed
     */
    protected int calcBolts(int strapAmount)
    {
        int boltAmount = 0;
        boltAmount += strapAmount * 4;
        boltAmount += separations * 4;
        return boltAmount;
    }

}
