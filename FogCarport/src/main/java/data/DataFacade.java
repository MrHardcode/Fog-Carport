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

    /**
     * Get a Material.
     *
     * @param id of the material in the database.
     * @param helptext "roof", "base", or "shed". Determines which helptext
     * you'd like for the material. The same material can have multiple
     * helptexts.
     * @return OrderModel
     * @throws DataException
     */
    public MaterialModel getMaterial(int id, String helptext) throws DataException;

    /**
     * Get an Order.
     *
     * @param id of the order in the database.
     * @return OrderModel
     * @throws DataException
     */
    public OrderModel getOrder(int id) throws DataException;

    public PartslistModel getBOM();

    public PartslistModel getOrderDetails(int id, String helptext) throws DataException;

    /**
     * Input an order into the database.
     *
     * @param order OrderModel
     * @throws DataException
     */
    public void createOrder(OrderModel order) throws DataException;

    /**
     * All order ids from the database.
     *
     * @return List of ids of all orders from the database.
     * @throws DataException
     */
    public List<Integer> getAllOrderIds() throws DataException;

    public EmployeeModel getEmployee(int id) throws UserException;

    public CustomerModel getCustomer(int id) throws DataException;

    public void createCustomer(CustomerModel customer) throws UserException;

    public void createEmployee(EmployeeModel employee) throws UserException;

    public CustomerModel login(String email, String password) throws UserException;

    public List<Integer> getOrderIds(int id) throws DataException;

    public void payOrder(int id) throws DataException;

    public EmployeeModel empLogin(String email, String password) throws UserException;

}
