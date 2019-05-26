package presentation.commands;

import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.exceptions.UserException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;


public abstract class Command
{

    private static HashMap<String, Command> commands;

    /**
     * This is the command from which all other CMD's are called.
     *
     * @param request the Http request
     * @param response the Http response
     */
    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("allOrders", new ViewAllOrders()); //  View all orders.
        commands.put("viewOrder", new ViewOrder()); // view a single order.
        commands.put("link", new Link()); // link internally.
        commands.put("viewPartslist", new ViewPartslist()); // Show the partslist to the Customer based on their order.
        commands.put("viewSVG", new ViewSVG()); // Show the SVG drawings of the carport.
        commands.put("makeCarport", new OrderCarport()); // Place a new Order into the Database.
        commands.put("login", new Login()); // From login.jsp. Log the Customer in.
        commands.put("createUser", new CreateUser()); // Make a new Customer
        commands.put("makeCarportForm", new MakeCarportForm()); //Form for creating a new carport order.
        commands.put("logOut", new LogOut()); // Log out customer, clear session, return to homepage.
        commands.put("payOrder", new PayOrder()); //Pay for a single order (change status to finalized)

    }

    public static Command from(HttpServletRequest request)
    {
        String commandName = request.getParameter("command");
        if (commands == null)
        {
            initCommands();
        }
        return commands.getOrDefault(commandName, new MakeCarportForm());
    }

    public abstract String execute(HttpServletRequest request, LogicFacade logic)
            throws UserException, DataException, AlgorithmException;

}
