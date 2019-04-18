package logic;

import data.exceptions.LoginException;
import data.models.PartslistModel;

public interface LogicFacade
{

    public PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException;
    
}
