package presentation;

import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.OrderModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

/**
 * Call this from the .jsp when the advanced stuff is in place.
 *
 * @author
 */
public class orderCarport extends Command
{

    public orderCarport()
    {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws DataException, UserException
    {
        Validation validation = new Validation();
        OrderModel order = new OrderModel();
        CustomerModel customer = (CustomerModel) request.getSession().getAttribute("customer");

        /* if customer is not null, that means customer is on session, which means customer is logged in, which means we can just get the ID from the CustomerModel on session */
        if (customer != null)
        {
            // CUSTOMER
            order.setId_customer(customer.getId());
        }
        /* Customer wants a log in, so we create a customer with passwords and registered as true. */
        else if (request.getParameter("password") != null && !request.getParameter("password").isEmpty())
        {
            String password = validation.validatePassword(request.getParameter("password"), request.getParameter("password-confirm"), "Password");
            String email = validation.validateString(request.getParameter("email"), "Email");
            String name = validation.validateString(request.getParameter("name"), "Navn");
            String adress = validation.validateString(request.getParameter("adress"), "Adresse");
            int phonenumber = validation.validateInteger(request.getParameter("phonenumber"), "Telefonnummer");
            int zip = validation.validateInteger(request.getParameter("zip"), "Post Nummer");
            CustomerModel customer_one = new CustomerModel();
            customer_one.setEmail(email);
            customer_one.setName(name);
            customer_one.setAdress(adress);
            customer_one.setPhone(phonenumber);
            customer_one.setZip(zip);
            customer_one.setPassword(password);
            customer_one.setRegistered(true);
            logic.createCustomer(customer_one);
            order.setId_customer(customer_one.getId());
        } 
        /* User doesn't want or need a customer in database they can log in on, but we still need to create the customer in the database so we have the contact info */
        else
        {
            String email = validation.validateString(request.getParameter("email"), "Email");
            String name = validation.validateString(request.getParameter("name"), "Navn");
            String adress = validation.validateString(request.getParameter("adress"), "Adresse");
            int phonenumber = validation.validateInteger(request.getParameter("phonenumber"), "Telefonnummer");
            int zip = validation.validateInteger(request.getParameter("zip"), "Post Nummer");
            CustomerModel customer_one = new CustomerModel();
            customer_one.setEmail(email);
            customer_one.setName(name);
            customer_one.setAdress(adress);
            customer_one.setPhone(phonenumber);
            customer_one.setZip(zip);
            customer_one.setPassword("");
            customer_one.setRegistered(false);
            logic.createCustomer(customer_one);
            order.setId_customer(customer_one.getId());
        }

        // CARPORT LENGTH
        String carportlength = request.getParameter("length");
        int length = validation.validateInteger(carportlength, "Length of carport");
        order.setLength(length);

        // CARPORT WIDTH
        String carportwidth = request.getParameter("width");
        int width = validation.validateInteger(carportwidth, "Width of carport");
        order.setWidth(width);

        // ROOF INCLINE
        String roofincline = request.getParameter("incline");
        int roof_incline = validation.validateInteger(roofincline, "Roof incline");
        order.setIncline(roof_incline);

        // ROOF TILES
        String rooftiles = request.getParameter("roof_tiles_id");
        int roof_tiles_id = validation.validateInteger(rooftiles, "Roof tiles");
        order.setRoof_tiles_id(roof_tiles_id);

        // SHED INFO
        String shed = request.getParameter("shed");
        if ("y".equals(shed))
        {
            // Get shed info from Parameters.
            int shed_length = validation.validateInteger(request.getParameter("shed-length"), "Shed length");
            int shed_width = validation.validateInteger(request.getParameter("shed-width"), "Shed width");
            int shed_floor_id = validation.validateInteger(request.getParameter("shed-floor-id"), "Shed floor type");
            int shed_wall_id = validation.validateInteger(request.getParameter("shed-wall-id"), "Shed wall type");
            // Set the shed info on Order.
            order.setShed_length(shed_length);
            order.setShed_width(shed_width);
            order.setShed_floor_id(shed_floor_id);
            order.setShed_walls_id(shed_wall_id);
        } else
        {
            order.setShed_length(0);
            order.setShed_width(0);
            order.setShed_floor_id(50);
            order.setShed_walls_id(10);
        }

        // EMPLOYEE
        order.setId_employee(1); // BAD TEMPORARY SOLUTION.

        // BUILD ADRESS
        String adress = validation.validateString(request.getParameter("adress"), "Build adress");
        order.setBuild_adress(adress);

        // ZIPCODE
        int zipcode = validation.validateInteger(request.getParameter("zip"), "Zip code");
        order.setBuild_zipcode(zipcode);

        // STATUS
        order.setStatus("Awaiting");

        // INPUT ORDER INTO DATABASE.
        logic.createOrder(order);

        // SET MESSAGE TO USER THAT ORDER WAS SUCCESSFULL
        request.setAttribute("message", "Carport bestilt.");

        // SEND USER BACK TO HOMEPAGE
        return "makeCarportForm";
    }

}
