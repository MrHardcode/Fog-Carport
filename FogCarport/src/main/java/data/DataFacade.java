package data;

import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;

public interface DataFacade
{
    public MaterialModel getMaterial();
    
    public OrderModel getOrder();
    
    public PartslistModel getBOM();
}
