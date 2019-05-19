package data;

import com.zaxxer.hikari.HikariDataSource;
import data.databaseAccessObjects.HikariDS;
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
    private static HikariDataSource dataSource = null;

    public synchronized static DataFacadeImpl getInstance()
    {
        if (instance == null)
        {
            instance = new DataFacadeImpl();
            dataSource = HikariDS.getDataSource();
        }
        return instance;
    }

    @Override
    public MaterialModel getMaterial(int id, String helptext) throws DataException
    {
        MaterialMapper materialMapper = new MaterialMapper();
        materialMapper.setDataSource(dataSource);
        return materialMapper.getMaterial(id, helptext);
    }

    @Override
    public OrderModel getOrder(int id) throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(dataSource);
        return orderMapper.getOrder(id);
    }

    @Override
    public PartslistModel getBOM()
    {
        return new PartslistModel();
    }

    @Override
    public PartslistModel getOrderDetails(int id, String helptext) throws DataException
    {
        MaterialMapper materialMapper = new MaterialMapper();
        materialMapper.setDataSource(dataSource);
        return materialMapper.getMaterials(id, helptext);
    }

    @Override
    public void createOrder(OrderModel order) throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(dataSource);
        orderMapper.createOrder(order);
    }

    @Override
    public List<Integer> getAllOrderIds() throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(dataSource);
        return orderMapper.getAllOrderIds();
    }

    @Override
    public EmployeeModel getEmployee(int id) throws UserException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(dataSource);
        return userMapper.getEmployee(id);
    }

    @Override
    public CustomerModel getCustomer(int id) throws DataException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(dataSource);
        return userMapper.getCustomer(id);
    }

    @Override
    public void createCustomer(CustomerModel customer) throws UserException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(dataSource);
        userMapper.createCustomer(customer);
    }

    @Override
    public void createEmployee(EmployeeModel employee) throws UserException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(dataSource);
        userMapper.createEmployee(employee);
    }

    @Override
    public CustomerModel login(String email, String password) throws UserException
    {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(dataSource);
        return userMapper.login(email, password);
    }

    @Override
    public List<Integer> getOrderIds(int id) throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(dataSource);
        return orderMapper.getOrderIds(id);
    }

    @Override
    public void payOrder(int id) throws DataException
    {
        OrderMapper orderMapper = new OrderMapper();
        orderMapper.setDataSource(dataSource);
        orderMapper.payOrder(id);
    }

    @Override
    public EmployeeModel empLogin(String email, String password) throws UserException {
        UserMapper userMapper = new UserMapper();
        userMapper.setDataSource(dataSource);
        return userMapper.empLogin(email, password);
    }

}
