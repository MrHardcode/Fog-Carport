package presentation;

import data.exceptions.AlgorithmException;
import data.exceptions.LoginException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import logic.LogicFacade;

abstract class Command
{

    private static HashMap<String, Command> commands;

    /**
     * If you make new Commands, add them to this map.
     */
    private static void initCommands()
    {
        commands = new HashMap<>();
//        commands.put("simpleorder", new makeCarportSimple());
        commands.put("allOrders", new viewAllOrders()); //  View all orders.
        commands.put("viewOrder", new viewOrder()); // view a single order.
        commands.put("link", new link()); // link internally.
        commands.put("viewPartslist", new viewPartslist()); // Show the partslist to the Customer based on their order.
        commands.put("viewSVG", new viewSVG()); // Show the SVG drawings of the carport.
        commands.put("makeCarport", new orderCarport()); // Place a new Order into the Database.
        commands.put("login", new login()); // From login.jsp. Log the Customer in.
        commands.put("createUser", new createUser()); // Make a new Customer
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
            throws LoginException, AlgorithmException;

}
