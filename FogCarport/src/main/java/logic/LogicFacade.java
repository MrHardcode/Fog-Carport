package logic;

import data.exceptions.LoginException;
import data.models.PartslistModel;
import java.util.List;

public interface LogicFacade
{

    public PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException;
    
    public PartslistModel getBOM () throws LoginException;
    
    public List<Integer> getAllOrderIds() throws LoginException;
    
}
