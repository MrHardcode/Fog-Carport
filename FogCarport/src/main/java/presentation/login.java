/*
 *  
 */
package presentation;

import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * Login Method. This is called after you hit "log ind" on the login.jsp. You're
 * then either confirmed as a valid user, or rejected and sent back to the login
 * page.
 *
 * @author
 */
public class login extends Command
{

    public login()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws UserException
    {
        Validation validation = new Validation();
        String email = validation.validateString(request.getParameter("email"), "Email"); // Get the email from the Parameters 
        String password = validation.validateString(request.getParameter("password"), "Password"); // Get the password from the Parameters

        try{
            /* Log in customer */
            CustomerModel customer = logic.login(email, password);
            request.getSession().setAttribute("customer", customer);
        } catch(UserException ux){
            /* if customer login fails, try to log in Employee instead */
            EmployeeModel employee = logic.empLogin(email, password);
            request.getSession().setAttribute("employee", employee);
        }
        return "homepage";

    }

}
