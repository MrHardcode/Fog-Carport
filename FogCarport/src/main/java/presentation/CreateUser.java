
package presentation;

import data.exceptions.UserException;
import data.models.CustomerModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * Create CustomerModel and input it into the database.
 * @author 
 */
public class CreateUser extends Command
{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws UserException
    {
        Validation v = new Validation();
        CustomerModel customer = new CustomerModel();
        
        /* Email */
        String email = request.getParameter("email");
        customer.setEmail(v.validateString(email, "Email"));
        
        /* Password */
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("password-confirm");
        customer.setPassword(v.validatePassword(password, passwordConfirm, "Password"));
        
        /* Name */
        String name = request.getParameter("name");
        customer.setName(v.validateString(name, "Name"));
        
        /* Phonenumber */
        String phone = request.getParameter("phonenumber");
        customer.setPhone(v.validateInteger(phone, "Phone number"));
        
        /* Customer being made in this command is always registered. */
        customer.setRegistered(true);
        
        /* Input Customer into database */
        logic.createCustomer(customer);
        
        /* Place customer on session via login */
        request.getSession().setAttribute("customer", logic.login(email, password));
        
        /* Send customer to homepage */
        return "homepage";
    }
    
}
