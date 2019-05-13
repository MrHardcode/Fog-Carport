
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
        
        String address = request.getParameter("address");
        customer.setAdress(v.validateString(address, "The address"));
        
        String zipcode = request.getParameter("zip");
        customer.setZip(v.validateInteger(zipcode, "Zip code"));
        
        System.out.println("Command createUser anyone?");
        
        return "createUser";
    }
    
}
