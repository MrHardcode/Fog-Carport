
package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.DBConnector;
import data.exceptions.LoginException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 
 */
public class UserMapper
{

    private static UserMapper userMapper;

    private UserMapper()
    {

    }

    public static UserMapper getInstance()
    {
        if (userMapper == null)
        {
            userMapper = new UserMapper();
        }
        return userMapper;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Log in a customer">
    /**
     * Login Method.
     *
     * Pulls a User entity from the SQL if the User input correct info into the
     * form. Else throws an exception and returns User to the index page.
     *
     * @param email Users email
     * @param password Users password
     * @return User entity
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    public CustomerModel login(String email, String password) throws LoginException
    {
        String SQL = "SELECT id_customer, phone FROM customers WHERE email=? AND password=?;";
        try 
        {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                int id = rs.getInt("id_customer");
                CustomerModel customer = new CustomerModel();
                customer.setPhone(rs.getInt("phone"));
                customer.setId(id);
                customer.setEmail(email);
                customer.setPassword(password);
                return customer;
            } else
            {
                throw new LoginException("Could not validate user");
            }
        } catch (SQLException ex)
        {
            throw new LoginException(ex.getMessage());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get a customer">
    /**
     * Get a Customer.
     *
     * @param id of the Order.
     * @return OrderModel
     * @throws LoginException Should probably be something else later on.
     */
    public CustomerModel getCustomer(int id) throws LoginException
    {
        CustomerModel customer = new CustomerModel();

        String SQL = "SELECT * FROM carportdb.customers WHERE id_customer = ?;";

        try
        {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            customer.setId(id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                customer.setName(rs.getString("customer_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getInt("phone"));
                customer.setPassword(rs.getString("password"));
            }

        } catch (SQLException ex)
        {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

        return customer;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get an employee">
    /**
     * Get an Order.
     *
     * @param id of the Order.
     * @return OrderModel
     * @throws LoginException Should probably be something else later on.
     */
    public EmployeeModel getEmployee(int id) throws LoginException
    {
        EmployeeModel employee = new EmployeeModel();

        String SQL = "SELECT `employees`.`emp_name`, `roles`.`role` "
                + "FROM `carportdb`.`employees` "
                + "INNER JOIN `carportdb`.`roles` "
                + "ON `employees`.`id_role` = `roles`.`id_role` "
                + "WHERE `employees`.`id_employee` = ?;";

        try
        {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            employee.setId(id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                employee.setName(rs.getString("emp_name"));
                employee.setRole(rs.getString("role"));
            }

        } catch (SQLException ex)
        {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

        return employee;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Create customer">
    /**
     * Create Customer Method.
     *
     * Inputs a Customer into the SQL database.
     *
     * @param customer
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    public void createCustomer(CustomerModel customer) throws LoginException
    {
        String SQL = "INSERT INTO `carportdb`.`customers`\n"
                + "(`customer_name`,\n"
                + "`phone`,\n"
                + "`email`,\n"
                + "`password`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?,\n"
                + "?);";
        try
        {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPassword());
            ps.executeUpdate();
            try (ResultSet ids = ps.getGeneratedKeys())
            {
                ids.next();
                int id = ids.getInt(1);
                customer.setId(id);
            }
        } catch (SQLException ex)
        {
            throw new LoginException("Customer already exists: " + ex.getMessage());
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Create Employee">
    /**
     * Create Employee Method.
     *
     * Inputs a Employee into the SQL database.
     *
     * @param employee
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    public void createEmployee(EmployeeModel employee) throws LoginException
    {
        String SQL = "INSERT INTO `carportdb`.`employees`\n"
                + "(`emp_name`,\n"
                + "`id_role`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?);";
        try
        {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getId_role());
            ps.executeUpdate();
            try (ResultSet ids = ps.getGeneratedKeys())
            {
                ids.next();
                int id = ids.getInt(1);
                employee.setId(id);
            }
        } catch (SQLException ex)
        {
            throw new LoginException("Employee already exists: " + ex.getMessage());
        }
    }
    //</editor-fold>
}
