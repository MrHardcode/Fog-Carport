package data;

import data.models.MaterialModel;
import data.models.OrderModel;

public interface DataFacade
{
    public MaterialModel getMaterial();
    
    public OrderModel getOrder();
}
