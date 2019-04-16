package logic;

import data.models.PartslistModel;

public interface LogicFacade
{

    public PartslistModel getSimpleBOM(String height, String length, String width, String shed);
    
}
