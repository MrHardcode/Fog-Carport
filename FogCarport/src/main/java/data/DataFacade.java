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

    /**
     * Get an employee from the database.
     *
     * @param id of the employee in the database.
     * @return EmployeeModel
     * @throws UserException
     */
    public EmployeeModel getEmployee(int id) throws UserException;

    /**
     * Get a customer from the database.
     *
     * @param id of the customer in the database.
     * @return CustomerModel
     * @throws DataException
     */
    public CustomerModel getCustomer(int id) throws DataException;

    /**
     * Input a customer into the database.
     *
     * @param customer you want to input into database.
     * @throws UserException
     */
    public void createCustomer(CustomerModel customer) throws UserException;

    /**
     * Input an employee into the database.
     *
     * @param employee you want to input into database.
     * @throws UserException
     */
    public void createEmployee(EmployeeModel employee) throws UserException;

    /**
     * Validate customer.
     *
     * @param email of the customer.
     * @param password of the customer.
     * @return CustomerModel
     * @throws UserException
     */
    public CustomerModel login(String email, String password) throws UserException;

    /**
     * Get all ids of all orders for a customer.
     *
     * @param id of the customer.
     * @return List of ids of orders.
     * @throws DataException
     */
    public List<Integer> getOrderIds(int id) throws DataException;

    /**
     * Update status and set paid price on an order in the database to be paid.
     *
     * @param id of the order in the database.
     * @param price the price of the order to be set in the database.
     * @throws DataException
     */
    public void payOrder(int id, double price) throws DataException;

    /**
     * Validate Employee
     *
     * @param email of the employee
     * @param password of the employee
     * @return EmployeeModel
     * @throws UserException
     */
    public EmployeeModel empLogin(String email, String password) throws UserException;
    
    public void updateOrderPrice(int id, double price) throws DataException;

}
