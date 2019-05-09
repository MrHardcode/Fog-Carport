package logic;

import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
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
    
    public CustomerModel getCustomer(int id) throws LoginException;
    
    public EmployeeModel getEmployee(int id) throws LoginException;
    
    public void createCustomer(CustomerModel customer) throws LoginException;
    
    public void createEmployee(EmployeeModel employee) throws LoginException;

    public PartslistModel getPartslistModel(OrderModel order) throws LoginException, AlgorithmException;
    
    public String getSVG(OrderModel order);
}
