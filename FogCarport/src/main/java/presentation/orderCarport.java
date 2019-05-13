package presentation;

import data.exceptions.LoginException;
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
    String execute(HttpServletRequest request, LogicFacade logic) throws LoginException
    {
        OrderModel order = new OrderModel();
        CustomerModel customer = (CustomerModel) request.getSession().getAttribute("customer");
//        EmployeeModel employee = new EmployeeModel();

        /* GET CUSTOMER INFO FROM SESSION INSTEAD NOW */
//        // Customer Info
//        String name = request.getParameter("name");
//        int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
//        String email = request.getParameter("email");
//        String adress = request.getParameter("adress");
//        int zip = Integer.parseInt(request.getParameter("zip"));
//        // Set the Customer Info on Customer.
//        customer.setName(name);
//        customer.setEmail(email);
//        customer.setPhone(phonenumber);
//        customer.setAdress(adress);
//        customer.setZip(zip);
        // CARPORT LENGTH AND WIDTH
        String carportlength = request.getParameter("length");
        if (carportlength == null || carportlength.isEmpty())
        {
            throw new LoginException("Length of carport may not be empty.");
        }

        String carportwidth = request.getParameter("width");
        if (carportwidth == null || carportlength.isEmpty())
        {
            throw new LoginException("Width of carport may not be empty.");
        }

        try
        {
            int length = Integer.parseInt(carportlength);
            int width = Integer.parseInt(carportwidth);
            // Set the Carport Info on Order.
            order.setLength(length);
            order.setWidth(width);
        } catch (NumberFormatException ex)
        {
            throw new LoginException("Length and Width inputs have to be Integers.");
        }

        // ROOF INFO
        String roofincline = request.getParameter("incline");
        if (roofincline == null || roofincline.isEmpty())
        {
            throw new LoginException("Roof incline may not be empty.");
        }
        try
        {
            int roof_incline = Integer.parseInt(roofincline);
            order.setIncline(roof_incline);
        } catch (NumberFormatException ex)
        {
            throw new LoginException("Roof incline has to be an Integer.");
        }

        String rooftiles = request.getParameter("roof_tiles_id");
        int roof_tiles_id = Integer.parseInt(rooftiles);

        //set roof info on Order
        order.setRoof_tiles_id(roof_tiles_id);
        // Shed Info
        String shed = request.getParameter("shed");
        if ("y".equals(shed))
        {
            // Get shed info from Parameters.
            int shed_length = Integer.parseInt(request.getParameter("shed-length"));
            int shed_width = Integer.parseInt(request.getParameter("shed-width"));
            int shed_floor_id = Integer.parseInt(request.getParameter("shed-floor-id"));
            int shed_wall_id = Integer.parseInt(request.getParameter("shed-wall-id"));
            // Set the shed info on Order.
            order.setShed_length(shed_length);
            order.setShed_width(shed_width);
            order.setShed_floor_id(shed_floor_id);
            order.setShed_walls_id(shed_wall_id);
        } else
        {
            order.setShed_length(0);
            order.setShed_width(0);
            order.setShed_floor_id(0);
            order.setShed_walls_id(0);
        }

//        logic.createCustomer(customer); // Shouldn't create the customer here anymore. Only in createCustomer.jsp
        order.setId_customer(customer.getId());
        order.setId_employee(1);
        order.setBuild_adress(request.getParameter("adress"));
        order.setBuild_zipcode(Integer.parseInt(request.getParameter("zip")));
        order.setStatus("Awaiting");
        logic.createOrder(order);

        request.setAttribute("message", "Carport succesfully ordered.");

        return "homepage";
    }

}
