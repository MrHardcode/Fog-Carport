package logic;

import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.List;

public interface LogicFacade
{

    public PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException;
    
    /*
    The idea here is that you've already used classes like "getRoof and getBottom" and you're then already working off of
    a list of materials. So just hand that list on here, so we can add to it, if the customer wants a shed, and hand the order
    which should contain dimensions of the shed, type of wood, and floor-type.
    
    Maybe this shouldn't even be available outside the logic package.
    Maybe we just want one method that takes an order (containing everything) and returns a List of Materials.
    Not quite sure yet.
    
    Feel free to change whatever you like. 
    */
    public List<MaterialModel> addShed(List<MaterialModel> bom, OrderModel order) throws LoginException;
    
}
