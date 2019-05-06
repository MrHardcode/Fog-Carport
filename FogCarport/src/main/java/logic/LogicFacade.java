package logic;

import data.exceptions.LoginException;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.List;

public interface LogicFacade
{

    public PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException;
    
    public PartslistModel getBOM () throws LoginException;
    
    public List<Integer> getAllOrderIds() throws LoginException;
    
    public OrderModel getOrder(int id) throws LoginException;
    
    public MaterialModel getMaterial(int id) throws LoginException;
    
}
