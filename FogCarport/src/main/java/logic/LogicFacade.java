package logic;

import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.exceptions.LoginException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.List;

public interface LogicFacade
{
    public void createOrder(OrderModel order) throws DataException;

//    public PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException;
//    
//    public PartslistModel getBOM () throws LoginException;
    
    public List<Integer> getAllOrderIds() throws DataException;
    
    public OrderModel getOrder(int id) throws DataException;
    
    public MaterialModel getMaterial(int id) throws DataException;
    
    public CustomerModel getCustomer(int id) throws DataException;
    
    public EmployeeModel getEmployee(int id) throws DataException;
    
    public void createCustomer(CustomerModel customer) throws LoginException;
    
    public void createEmployee(EmployeeModel employee) throws LoginException;

    public PartslistModel getPartslistModel(OrderModel order) throws DataException, AlgorithmException;
    
    public String getSVGbase(PartslistModel bom, OrderModel order);
    
    public String getSVGroof(OrderModel order) throws DataException;
    
    public CustomerModel login(String email, String password) throws LoginException;

    public List<Integer> getOrderIds(int id) throws DataException;
}
