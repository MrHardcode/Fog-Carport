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
        commands.put("viewPartslist", new viewPartslist());
        commands.put("viewSVG", new viewSVG());
        commands.put("makeCarport", new orderCarport());
        commands.put("login", new login());
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
