package data;

import data.databaseAccessObjects.DBCPDataSource;
import data.databaseAccessObjects.mappers.MaterialMapper;
import data.databaseAccessObjects.mappers.OrderMapper;
import data.databaseAccessObjects.mappers.UserMapper;
import data.exceptions.DataException;
import data.exceptions.UserException;
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

    public synchronized static DataFacadeImpl getInstance()
    {
        if (instance == null)
        {
            instance = new DataFacadeImpl();
        }
        return instance;
    }

    @Override
    public MaterialModel getMaterial(int id) throws DataException
    {
        MaterialMapper materialMapper = new MaterialMapper();
        materialMapper.setDataSource(DBCPDataSource.getDataSource());
        return materialMapper.getMaterial(id);
    }

    @Override
    public OrderModel getOrder(int id) throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(DBCPDataSource.getDataSource());
        return orderMapper.getOrder(id);
    }

    @Override
    public PartslistModel getBOM()
    {
        return new PartslistModel();
    }

    @Override
    public void createOrder(OrderModel order) throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(DBCPDataSource.getDataSource());
        orderMapper.createOrder(order);
    }

    @Override
    public List<Integer> getAllOrderIds() throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(DBCPDataSource.getDataSource());
        return orderMapper.getAllOrderIds();
    }

    @Override
    public EmployeeModel getEmployee(int id) throws UserException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(DBCPDataSource.getDataSource());
        return userMapper.getEmployee(id);
    }

    @Override
    public CustomerModel getCustomer(int id) throws DataException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(DBCPDataSource.getDataSource());
        return userMapper.getCustomer(id);
    }

    @Override
    public void createCustomer(CustomerModel customer) throws UserException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(DBCPDataSource.getDataSource());
        userMapper.createCustomer(customer);
    }

    @Override
    public void createEmployee(EmployeeModel employee) throws UserException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(DBCPDataSource.getDataSource());
        userMapper.createEmployee(employee);
    }

    @Override
    public CustomerModel login(String email, String password) throws UserException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(DBCPDataSource.getDataSource());
        return userMapper.login(email, password);
    }

    @Override
    public List<Integer> getOrderIds(int id) throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(DBCPDataSource.getDataSource());
        return orderMapper.getOrderIds(id);
    }

    @Override
    public void payOrder(int id) throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(DBCPDataSource.getDataSource());
        orderMapper.payOrder(id);
    }

    @Override
    public PartslistModel getOrderDetails(int id) throws DataException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
