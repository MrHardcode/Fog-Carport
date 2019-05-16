package data;

import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.List;

public interface DataFacade
{
    public MaterialModel getMaterial(int id) throws DataException;
    
    public OrderModel getOrder(int id) throws DataException;
    
    public PartslistModel getBOM();
    
    public PartslistModel getOrderDetails(int id) throws DataException;
    
    public void createOrder(OrderModel order) throws DataException;
    
    public List<Integer> getAllOrderIds() throws DataException;
    
    public EmployeeModel getEmployee(int id) throws DataException;
    
    public CustomerModel getCustomer(int id) throws DataException;
    
    public void createCustomer(CustomerModel customer) throws UserException;
    
    public void createEmployee(EmployeeModel employee) throws UserException;
    
    public CustomerModel login(String email, String password) throws UserException;
    
    public List<Integer> getOrderIds(int id) throws DataException;
}
