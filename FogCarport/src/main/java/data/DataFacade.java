package data;

import data.exceptions.LoginException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.List;

public interface DataFacade
{
    public MaterialModel getMaterial(int id) throws LoginException;
    
    public OrderModel getOrder(int id) throws LoginException;
    
    public PartslistModel getBOM();
    
    public PartslistModel getOrderDetails(int id) throws LoginException;
    
    public void createOrder(OrderModel order) throws LoginException;
    
    public List<Integer> getAllOrderIds() throws LoginException;
    
    public EmployeeModel getEmployee(int id) throws LoginException;
    
    public CustomerModel getCustomer(int id) throws LoginException;
}
