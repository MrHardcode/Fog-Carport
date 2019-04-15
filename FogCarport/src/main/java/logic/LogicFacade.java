package logic;

import data.models.PartslistModel;

public interface LogicFacade
{

    public PartslistModel getSimpleBOM(String height, String width, String length, String shed);
    
}
