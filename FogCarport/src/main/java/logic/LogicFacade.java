package logic;

import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import data.models.MaterialModel;
import data.models.OrderModel;
import data.models.PartslistModel;
import java.util.List;

public interface LogicFacade
{

    /**
     * Input an order into the database.
     *
     * @param order OrderModel
     * @throws DataException
     */
    public void createOrder(OrderModel order) throws DataException;

//    public PartslistModel getSimpleBOM(String height, String length, String width, String shed) throws LoginException;
//    
//    public PartslistModel getBOM () throws LoginException;
    /**
     * All order ids from the database.
     *
     * @return List of ids of all orders from the database.
     * @throws DataException
     */
    public List<Integer> getAllOrderIds() throws DataException;

    /**
     * Get an Order.
     *
     * @param id of the order in the database.
     * @return OrderModel
     * @throws DataException
     */
    public OrderModel getOrder(int id) throws DataException;

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
     * Get a customer from the database.
     *
     * @param id of the customer in the database.
     * @return CustomerModel
     * @throws DataException
     */
    public CustomerModel getCustomer(int id) throws DataException;

    /**
     * Get an employee from the database.
     *
     * @param id of the employee in the database.
     * @return EmployeeModel
     * @throws UserException
     */
    public EmployeeModel getEmployee(int id) throws UserException;

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

    public PartslistModel getPartslistModel(OrderModel order) throws DataException, AlgorithmException;

    /**
     * Get the drawing of the base of the carport. We use SVG.
     *
     * @param bom bill of materials. PartslistModel. Contains required info.
     * @param order of the carport.
     * @return HTML String that draws the base of the carport.
     */
    public String getSVGbase(PartslistModel bom, OrderModel order);

    /**
     * Get the drawing of the roof of the carport. We use SVG.
     *
     * @param order of the carport.
     * @return HTML String that draws the roof.
     * @throws DataException
     * @throws AlgorithmException
     */
    public String getSVGroof(OrderModel order) throws DataException, AlgorithmException;

    public String getSVGbaseArrowLength(PartslistModel bom, OrderModel order, int extraDistance);

    public String getSVGbaseArrowWidth(PartslistModel bom, OrderModel order, int extraDistance);

    public String getSVGbaseLabelWidth(PartslistModel bom, OrderModel order, int extraDistance);

    public String getSVGbaseLabelLength(PartslistModel bom, OrderModel order, int extraDistance);

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
     * Update status on an order in the database to be paid.
     *
     * @param id of the order in the database.
     * @throws DataException
     */
    public void payOrder(int id) throws DataException;

    /**
     * Validate Employee
     *
     * @param email of the employee
     * @param password of the employee
     * @return EmployeeModel
     * @throws UserException
     */
    public EmployeeModel empLogin(String email, String password) throws UserException;
    
    public int getSuggestedRetailPrice(PartslistModel partsList);

}
