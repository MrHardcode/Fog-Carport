
package presentation;

import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import data.models.CustomerModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 *
 * @author 
 */
public class createUser extends Command
{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException, AlgorithmException
    {
        Validation v = new Validation();
        CustomerModel customer = new CustomerModel();
        
        String email = request.getParameter("email");
        customer.setEmail(v.validateString(email, "Email"));
        
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("password-confirm");
        customer.setPassword(v.validatePassword(password, passwordConfirm, "Password"));
        
        String name = request.getParameter("name");
        customer.setName(v.validateString(name, "Name"));
        
        String phone = request.getParameter("phonenumber");
        customer.setPhone(v.validateInteger(phone, "Phone number"));
        
        logic.createCustomer(customer);
        request.getSession().setAttribute("customer", logic.login(email, password));
        
        return "homepage";
    }
    
}