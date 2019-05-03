package logic.Calculations;

import data.DataFacade;
import data.DataFacadeImpl;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;

/**
 *
 * @author Asger
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
    
    //Variables used to keep track of things in the algorithm
    private int separations = 0;
    
    protected PartslistModel addBase(PartslistModel bom, OrderModel order) throws LoginException
    {
        DataFacade db = DataFacadeImpl.getInstance();
        
        int carportLength = order.getLength();
        int carportWidth = order.getWidth();
        int shedLength = order.getShed_length();
        int shedWidth = order.getShed_width();
        boolean hasRaisedRoof = false;
        separations = 0;
        if (order.getIncline() > 0)
        {
            hasRaisedRoof = true;
        }
        
        calcMaterials(bom, carportLength, carportWidth, shedLength, shedWidth, hasRaisedRoof, db);
        
        return bom;
    }
    
    protected void calcMaterials(
            PartslistModel bom, 
            int cLength, int cWidth, 
            int sLength, int sWidth, 
            boolean heavyRoof, 
            DataFacade db) throws LoginException
    {
        //97x97mm post
        MaterialModel post = db.getMaterial(postID);
        int postAmount = 0;
        if (heavyRoof)
        {
            postAmount = calcPosts(cLength, cWidth, sLength, sWidth, postDistanceRaisedRoof);
        }
        else
        {
            postAmount = calcPosts(cLength, cWidth, sLength, sWidth, postDistanceStandard);
        }
        post.setQuantity(postAmount);
        //45x195mm rafter wood
        MaterialModel strap = db.getMaterial(strapID);
        int strapAmount = calcStraps(cLength, cWidth, sLength, sWidth, strap);
        strap.setQuantity(strapAmount);
        
        //10x120mm bolts
        MaterialModel bolts = db.getMaterial(boltID);
        int boltAmount = calcBolts(postAmount, strapAmount);
        bolts.setQuantity(boltAmount);
    }

    protected int calcPosts(int cLength, int cWidth, int sLength, int sWidth, int postDistance)
    {
        //Total post amount
        int postAmount = 0;
        
        //If the shed length is 0 because there is no shed:
        if (sLength == 0)
        {
            postAmount = calcPostsNoShed(cLength, cWidth, postDistance);
        }
        //If the shed is as wide as the carport:
        else if (sWidth == cWidth)
        {
            postAmount = calcPostsFullWidthShed(cLength, cWidth, sLength, postDistance);
        }
        //If the shed's width is shorter than the carport's width:
        else
        {
            postAmount = calcPostsOddShed(cLength, cWidth, sLength, sWidth, postDistance);
        }
        return postAmount;
    }
    
    private int calcPostsFullWidthShed(int cLength, int cWidth, int sLength, int postDistance)
    {
        //The first posts are always places 800mm from the entrance-end of the carport
        int length = cLength - 800;
        //Posts
        int postAmount = 0;

        /*   Both sides of the carport   */
        //Counter used to count the amount of times a post should be placed 
        //between the front post and the first shed post
        int count = 0;
        //Adding post amount to the counter plus 1 (to include the front post)
        count = ((length - sLength) / postDistance) + 1;
        //Another counter
        int temp = 0;
        //Adding the count to temp
        temp += count;
        //If two posts are placed on the same spot, we remove one of them
        //We remove two, since this counts for boths sides (because shed width == carport width)
        if (cLength - (800 + postDistance * (temp - 1)) == sLength)
        {
            postAmount -= 2;
        }
        //Adding 2 to temp because: 
        //1 for the first corner of the shed
        //Another 1 for the second corner of the shed (which is also the corner of the carport)
        temp += 2;
        //Adding temp to the postAmount twice since the sides of the carport are equal to each other 
        //because the shed has the same width as the carport
        postAmount += temp * 2;
        //If the shed is very long we need one or more extra posts
        if ((sLength / postDistance) > 0)
        {
            //We add the amount twice since the sides of the carport are equal
            postAmount += (sLength / postDistance) * 2;
        }
        /*   The rear of the carport   */
        //Calculating width. We don't have to think about extra posts for the shed 
        //since the shed has the same width as the carport
        //The corner posts have already been calculated
        if ((cWidth / postDistance) > 0)
        {
            postAmount += (cWidth / postDistance);
        }
        return postAmount;
    }
    
    private int calcPostsOddShed(int cLength, int cWidth, int sLength, int sWidth, int postDistance)
    {
        //The first posts are always places 800mm from the entrance-end of the carport
        int length = cLength - 800;
        //Posts
        int postAmount = 0;
        
        /*   First side of the carport   */
        //Counter used to count the amount of times a post should be placed 
        //between the front post and the first shed post
        int count = 0;
        //Adding post amount to the counter plus 1 (to include the front post)
        count = ((length - sLength) / postDistance) + 1;
        //Another counter
        int temp = 0;
        //Adding the count to temp
        temp += count;
        //If two posts are placed on the same spot, we remove one of them
        if (cLength - (800 + postDistance * (temp - 1)) == sLength)
        {
            postAmount -= 1;
        }
        //Adding 2 to temp because: 
        //1 for the first corner of the shed
        //Another 1 for the second corner of the shed (which is also the corner of the carport)
        temp += 2;
        //Adding temp to the postAmount
        postAmount += temp;
        //If the shed is very long we need one or more extra posts
        if ((sLength / postDistance) > 0 && (sLength % postDistance != 0))
        {
            postAmount += (sLength / postDistance);
        }

        /*   Second side of the carport   */
        //Adding the amount of posts for the second side. The + 1 is the front post
        postAmount += (length / postDistance) + 1;
        //Adding an extra post if the previous division didn't go up
        if (length % postDistance > 0)
        {
            ++postAmount;
        }

        /*   The rear of the carport   */
        //Adding one for the corner of the shed
        ++postAmount;
        //Adding extra posts for the part that the shed is covering if the shed is wide enough
        if (sWidth / postDistance > 0 && (sWidth % postDistance != 0))
        {
            postAmount += (sWidth / postDistance);
        }
        int restWidth = cWidth - sWidth;
        //Adding extra posts for the part that the shed doesn't cover if needed
        if (restWidth / postDistance > 0 && (restWidth % postDistance != 0))
        {
            postAmount += (restWidth / postDistance);
        }
        return postAmount;
    }
    
    private int calcPostsNoShed(int cLength, int cWidth, int postDistance)
    {
        //Amount of posts
        int postAmount = 0;
        //Calculating the amount of posts between the corner posts in the side. 
        //+2 for the two corners. *2 since the sides are equal.
        postAmount += (((cLength - 800) / postDistance) + 2) * 2;
        //Calculating the amount of posts between the corner posts in the rear.
        postAmount += cWidth / postDistance;
        //If cWidth % postDistance == 0 then the algorithm adds a post for a corner
        //where a post has already been places so we must remove that one extra post
        if (cWidth % postDistance == 0)
        {
            --postAmount;
        }
        return postAmount;
    }
    
    protected int calcStraps(int cLength, int cWidth, int sLength, int sWidth, MaterialModel strap)
    {
        //Amount of straps
        int strapAmount = 0;
        boolean skipWidthCalc = false;
        //Calculating the amount of straps for the sides if the carport is shorter 
        //than a strap
        if (cLength <= strap.getLength())
        {
            //If one strap can cover the whole length of both sides of the carport 
            //then we only need one strap for the sides
            if (cLength * 2 <= strap.getLength())
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
            int restLength = cLength - strap.getLength();
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
                if ((strap.getLength() - restLength * 2) > cWidth)
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
                if ((strap.getLength() - restLength) > cWidth)
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
            if (cWidth / strap.getLength() > 0)
            {
                strapAmount += cWidth / strap.getLength();
                //Checking for remainders using modulus. If there is no remainder 
                //we remove one strap
                if (cWidth % strap.getLength() == 0)
                {
                    --strapAmount;
                }
            }
            //If one strap is enough to cover the whole carport we set strapAmount to 1
            //This if-statement is necessary for the calculation of the bolts
            if ((cLength * 2 + cWidth) <= strap.getLength())
            {
                strapAmount = 1;
                separations = 2;
            }
        }
        return strapAmount;
    }

    protected int calcBolts(int postAmount, int strapAmount)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
