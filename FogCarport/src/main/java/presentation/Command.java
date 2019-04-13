package presentation;

import data.exceptions.LoginException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command
{

    private static HashMap<String, Command> commands;

    /**
     * If you make new Commands, add them to this map.
     */
    private static void initCommands()
    {
        commands = new HashMap<>();
//        commands.put("order", new Order()); --- Template for adding a command.
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

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginException;

}
