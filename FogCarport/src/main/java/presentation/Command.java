package presentation;

import data.exceptions.DataException;
import data.exceptions.UserException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

abstract class Command
{

    private static HashMap<String, Command> commands;
    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("allOrders", new ViewAllOrders()); //  View all orders.
        commands.put("viewOrder", new ViewSingleOrder()); // view a single order.
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

    static Command from(HttpServletRequest request)
    {
        String commandName = request.getParameter("command");
        if (commands == null)
        {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, LogicFacade logic)
            throws UserException, DataException;

}
