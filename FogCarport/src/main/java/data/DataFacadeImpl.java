package data;

import data.databaseAccessObjects.mappers.MaterialMapper;
import data.databaseAccessObjects.mappers.OrderMapper;
import data.databaseAccessObjects.mappers.UserMapper;
import data.exceptions.DataException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.List;

/**
 *
 * @author 
 */
public class DataFacadeImpl implements DataFacade
{
    
    private static DataFacadeImpl instance = null;

    public synchronized static DataFacadeImpl getInstance() {
        if (instance == null) {
            instance = new DataFacadeImpl();
        }
        return instance;
    }


    @Override
    public MaterialModel getMaterial(int id) throws DataException
    {
        return MaterialMapper.getInstance().getMaterial(id);
    }

    @Override
    public OrderModel getOrder(int id) throws DataException
    {
        return OrderMapper.getInstance().getOrder(id);
    }

    @Override
    public PartslistModel getBOM()
    {
        return new PartslistModel();
    }

    @Override
    public PartslistModel getOrderDetails(int id) throws DataException
    {
        return MaterialMapper.getInstance().getMaterials(id);
    }

    @Override
    public void createOrder(OrderModel order) throws DataException
    {
        OrderMapper.getInstance().createOrder(order);
    }

    @Override
    public List<Integer> getAllOrderIds() throws DataException
    {
        return OrderMapper.getInstance().getAllOrderIds();
    }

    @Override
    public EmployeeModel getEmployee(int id) throws DataException
    {
        return UserMapper.getInstance().getEmployee(id);
    }

    @Override
    public CustomerModel getCustomer(int id) throws DataException
    {
        return UserMapper.getInstance().getCustomer(id);
    }

    @Override
    public void createCustomer(CustomerModel customer) throws DataException
    {
        UserMapper.getInstance().createCustomer(customer);
    }

    @Override
    public void createEmployee(EmployeeModel employee) throws DataException
    {
        UserMapper.getInstance().createEmployee(employee);
    }

    @Override
    public CustomerModel login(String email, String password) throws DataException
    {
        return UserMapper.getInstance().login(email, password);
    }

    @Override
    public List<Integer> getOrderIds(int id) throws DataException
    {
        return OrderMapper.getInstance().getOrderIds(id);
    }

}
