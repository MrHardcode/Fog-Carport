package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.DatabaseConnector;
import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author
 */
public class UserMapper
{

    private DatabaseConnector dbc = new DatabaseConnector();

    public void setDataSource(DataSource ds)
    {
        dbc.setDataSource(ds);
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
     * @throws UserException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    public CustomerModel login(String email, String password) throws UserException
    {
        String SQL = "SELECT customer_name, id_customer, phone, registered FROM customers WHERE email=? AND password=?;";
        try (DatabaseConnector open_dbc = dbc.open())
        {
            PreparedStatement ps = open_dbc.preparedStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                boolean registered = rs.getBoolean("registered");
                if (registered == true)
                {
                    int id = rs.getInt("id_customer");
                    CustomerModel customer = new CustomerModel();
                    customer.setRegistered(registered);
                    customer.setPhone(rs.getInt("phone"));
                    customer.setName(rs.getString("customer_name"));
                    customer.setId(id);
                    customer.setEmail(email);
                    customer.setPassword(password);
                    return customer;
                } else
                {
                    throw new UserException("Could not validate customer");
                }
            } else
            {
                throw new UserException("Could not validate customer");
            }

        } catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get a customer">
    /**
     * Get a Customer.
     *
     * @param id of the Order.
     * @return OrderModel
     * @throws DataException
     */
    public CustomerModel getCustomer(int id) throws DataException
    {
        String SQL = "SELECT * FROM carportdb.customers WHERE id_customer = ?;";

        try (DatabaseConnector open_dbc = dbc.open())
        {
            PreparedStatement ps = open_dbc.preparedStatement(SQL);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                CustomerModel customer = new CustomerModel();
                customer.setId(id);

                customer.setName(rs.getString("customer_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getInt("phone"));
                customer.setPassword(rs.getString("password"));
                if (!customer.getPassword().equals(""))
                {
                    customer.setRegistered(true);
                }
                return customer;
            } else
            {
                throw new DataException("Could not retrieve customer info.");
            }
        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get an employee">
    /**
     * Get an Order.
     *
     * @param id of the Order.
     * @return OrderModel
     * @throws data.exceptions.UserException
     */
    public EmployeeModel getEmployee(int id) throws UserException
    {

        String SQL = "SELECT `employees`.`emp_email`, `roles`.`role` "
                + "FROM `carportdb`.`employees` "
                + "INNER JOIN `carportdb`.`roles` "
                + "ON `employees`.`id_role` = `roles`.`id_role` "
                + "WHERE `employees`.`id_employee` = ?;";

        try (DatabaseConnector open_dbc = dbc.open())
        {
            PreparedStatement ps = open_dbc.preparedStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                EmployeeModel employee = new EmployeeModel();
                employee.setId(id);
                employee.setEmail(rs.getString("emp_email"));
                employee.setRole(rs.getString("role"));
                return employee;
            } else
            {
                throw new UserException("Could not get info about employee from database.");
            }

        } catch (SQLException ex)
        {
            throw new UserException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Create customer">
    /**
     * Create Customer Method.
     *
     * Inputs a Customer into the SQL database.
     *
     * @param customer
     * @throws UserException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    public void createCustomer(CustomerModel customer) throws UserException
    {
        int registered;
        if (customer.isRegistered()){
            registered = 1;
        } else {
            registered = 0;
        }
        String SQL = "INSERT INTO `carportdb`.`customers`\n"
                + "(`customer_name`,\n"
                + "`phone`,\n"
                + "`email`,\n"
                + "`password`,\n"
                + "`registered`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?);";
        try (DatabaseConnector open_dbc = dbc.open())
        {
            PreparedStatement ps = open_dbc.preparedStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPassword());
            ps.setInt(5, registered);
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next())
            {
                customer.setId(resultSet.getInt(1));
            }
        } catch (SQLException ex)
        {
            throw new UserException("Customer already exists: " + ex.getMessage());
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
     * @throws UserException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    public void createEmployee(EmployeeModel employee) throws UserException
    {
        String SQL = "INSERT INTO `carportdb`.`employees`\n"
                + "(`emp_email`,\n"
                + "`id_role`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?);";
        try (DatabaseConnector open_dbc = dbc.open())
        {
            PreparedStatement ps = open_dbc.preparedStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getEmail());
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
            throw new UserException("Employee already exists: " + ex.getMessage());
        }
    }
    //</editor-fold>

    public EmployeeModel empLogin(String email, String password) throws UserException
    {

        String SQL = "SELECT id_employee, id_role FROM employees where emp_email=? AND password=?;";
        try (DatabaseConnector open_dbc = dbc.open())
        {
            PreparedStatement ps = open_dbc.preparedStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                int id_emp = rs.getInt("id_employee");
                int id_role = rs.getInt("id_role");
                EmployeeModel employee = new EmployeeModel();
                employee.setEmail(email);
                employee.setId_role(id_role);
                employee.setId(id_emp);
                return employee;
            } else
            {
                throw new UserException("Could not validate employee");
            }
        } catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }
}
