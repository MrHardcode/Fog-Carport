package logic;

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
    private int postDistanceStandard = 3100;
    private int postDistanceRaisedRoof = 2750;
    
    //IDs of materials from DB
    private int postID = 4;
    private int strapID = 54;
    private int boltID = 24;
    
    protected PartslistModel addBase(PartslistModel bom, OrderModel order) throws LoginException
    {
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
            postAmount = calcPostsRaisedRoof(cLength, cWidth, sLength, sWidth);
        }
        else
        {
            //postAmount = calcPostsFlatRoof(cLength, cWidth, sLength, sWidth);
        }
        post.setQuantity(postAmount);
        //45x195mm rafter wood
        MaterialModel strap = db.getMaterial(strapID);
        int strapAmount = calcStraps(cLength, cWidth);
        strap.setQuantity(strapAmount);
        
        //10x120mm bolts
        MaterialModel bolts = db.getMaterial(boltID);
        int boltAmount = calcBolts(postAmount, strapAmount);
        bolts.setQuantity(boltAmount);
    }

    protected int calcPostsRaisedRoof(int cLength, int cWidth, int sLength, int sWidth)
    {
        //Total post amount
        int postAmount = 0;
        
        //If the shed is as wide as the carport:
        if (sWidth == cWidth)
        {
            postAmount = calcPostsFullWidthShed(cLength, cWidth, sLength, sWidth);
        }
        //If the shed's width is shorter than the carport's width:
        else
        {
            postAmount = calcPostsOddShed(cLength, cWidth, sLength, sWidth);
        }
        return postAmount;
    }
    
    private int calcPostsFullWidthShed(int cLength, int cWidth, int sLength, int sWidth)
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
        count = ((length - sLength) / postDistanceRaisedRoof) + 1;
        //Another counter
        int temp = 0;
        //Adding the count to temp
        temp += count;
        //This if-statement makes sure to remove posts where there would have been placed 
        //two posts inside each other because the shed has corners placed on a point 
        //where another post has already been placed (not counting the corners of the carport). 
        //Yeah... it's hard to explain 
        if (cLength - (800 + postDistanceRaisedRoof * (temp - 1)) == sLength)
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
        if ((sLength / postDistanceRaisedRoof) > 0)
        {
            //We add the amount twice since the sides of the carport are equal
            postAmount += (sLength / postDistanceRaisedRoof) * 2;
        }
        /*   The rear of the carport   */
        //Calculating width. We don't have to think about extra posts for the shed 
        //since the shed has the same width as the carport
        //The corner posts have already been calculated
        if ((cWidth / postDistanceRaisedRoof) > 0)
        {
            postAmount += (cWidth / postDistanceRaisedRoof);
        }
        return postAmount;
    }
    
    private int calcPostsOddShed(int cLength, int cWidth, int sLength, int sWidth)
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
        count = ((length - sLength) / postDistanceRaisedRoof) + 1;
        //Another counter
        int temp = 0;
        //Adding the count to temp
        temp += count;
        //Another one of those hard to explain if-statements
        if (cLength - (800 + postDistanceRaisedRoof * (temp - 1)) == sLength)
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
        if ((sLength / postDistanceRaisedRoof) > 0 && (sLength % postDistanceRaisedRoof != 0))
        {
            postAmount += (sLength / postDistanceRaisedRoof);
        }

        /*   Second side of the carport   */
        //Adding the amount of posts for the second side. The + 1 is the front post
        postAmount += (length / postDistanceRaisedRoof) + 1;
        //Adding an extra post if the previous division didn't go up
        if (length % postDistanceRaisedRoof > 0)
        {
            ++postAmount;
        }

        /*   The rear of the carport   */
        //Adding one for the corner of the shed
        ++postAmount;
        //Adding extra posts for the part that the shed is covering if the shed is wide enough
        if (sWidth / postDistanceRaisedRoof > 0 && (sWidth % postDistanceRaisedRoof != 0))
        {
            postAmount += (sWidth / postDistanceRaisedRoof);
        }
        int restWidth = cWidth - sWidth;
        //Adding extra posts for the part that the shed doesn't cover if needed
        if (restWidth / postDistanceRaisedRoof > 0 && (restWidth % postDistanceRaisedRoof != 0))
        {
            postAmount += (restWidth / postDistanceRaisedRoof);
        }
        return postAmount;
    }

    protected int calcPostsFlatRoof(int cLength, int cWidth, boolean shedContact, int sLength)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected int calcStraps(int cLength, int cWidth)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected int calcBolts(int postAmount, int strapAmount)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
