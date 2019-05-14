/*
 *  
 */
package presentation;

import data.exceptions.LoginException;
import data.models.CustomerModel;
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
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        Validation validation = new Validation();
        String email = validation.validateString(request.getParameter("email"), "Email"); // Get the email from the Parameters 
        String password = validation.validateString(request.getParameter("password"), "Password"); // Get the password from the Parameters

        // Check that Customer exists in the Database. If Customer is in Database, return it as a Model.
        CustomerModel customer = logic.login(email, password);

        // Place Customer on the Session.
        request.getSession().setAttribute("customer", customer);

        // Return Customer to the homepage of the website.
        return "homepage";

    }

}