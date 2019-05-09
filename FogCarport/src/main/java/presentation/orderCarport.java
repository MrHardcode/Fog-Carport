package presentation;

import data.exceptions.LoginException;
import data.models.CustomerModel;
import data.models.OrderModel;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;
import logic.LogicFacadeImpl;

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
        LogicFacade db = new LogicFacadeImpl();
        OrderModel order = new OrderModel();
        CustomerModel customer = new CustomerModel();
//        EmployeeModel employee = new EmployeeModel();

        // Customer Info
        String name = request.getParameter("name");
        int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
        String email = request.getParameter("email");
        String adress = request.getParameter("adress");
        int zip = Integer.parseInt(request.getParameter("zip"));
        // Set the Customer Info on Customer.
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phonenumber);
        customer.setAdress(adress);
        customer.setZip(zip);

        // Carport Info
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        // Set the Carport Info on Order.
        order.setLength(length);
        order.setWidth(width);
        //roof info
        int roof_incline = Integer.parseInt(request.getParameter("incline"));
        int roof_tiles_id = Integer.parseInt(request.getParameter("roof_tiles_id"));

        //set roof info on Order
        order.setIncline(roof_incline);
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
        } else {
            order.setShed_length(0);
            order.setShed_width(0);
            order.setShed_floor_id(0);
            order.setShed_walls_id(0);
        }

        db.createCustomer(customer);
        order.setId_customer(customer.getId());
        order.setId_employee(0);
        db.createOrder(order);

        return "homepage";
    }

}
