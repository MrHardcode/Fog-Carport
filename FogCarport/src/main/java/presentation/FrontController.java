package presentation;

import presentation.commands.Command;
import data.exceptions.AlgorithmException;
import data.exceptions.DataException;
import data.exceptions.UserException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;
import logic.LogicFacadeImpl;

/**
 *
 * @author
 */
@WebServlet(name = "FrontController", urlPatterns =
{
    "/FrontController"
})
public class FrontController extends HttpServlet
{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */

    private LogicFacade logic = LogicFacadeImpl.getInstance();
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            if (request.getAttribute("target") != null)
            {
                validateSession(request);
            }
            Command action = Command.from(request);
            String target = action.execute(request, logic);
            request.setAttribute("target", target);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        catch (UserException e) 
        {
            request.setAttribute("target", "login"); //send user to login 
            String message = e.getMessage();

            request.setAttribute("message", message); //re-send message to target
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        catch (DataException | AlgorithmException ex)
        {
            request.setAttribute("target", "errorMessage"); //send user to error page
            String message = ex.getMessage();
            request.setAttribute("errormessage", message); //set message as errormessage (to be properly displayed) on target
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    /*
    Session lasts for 30 minutes by default. (You may change this in the session-timeout tag of web.xml.)
    If the customer is anywhere else but the create user or login page, and isn't logged in and tries to perform an action, 
    then they will get logged out. 
    Or if they've been inactive for 30 minutes. (Session refreshes the 30 minutes window for each action you perfom.)
    
     */
    private void validateSession(HttpServletRequest request) throws UserException, ServletException, IOException
    {
        // GET SESSION.
        HttpSession session = request.getSession();
        // GET CUSTOMER OBJECT.
        CustomerModel customer = (CustomerModel) session.getAttribute("customer");
        EmployeeModel employee = (EmployeeModel) session.getAttribute("employee");
        // IF USER IS ON VIEW ORDERS OR VIEW PARTSLIST OR VIEW DRAWINGS AND NOT LOGGED IN
        String command = request.getParameter("command");
        String link = request.getParameter("link");
        if (customer == null && employee == null
                && !"login".equals(command) && !"login".equals(link)
                && !"createUser".equals(command) && !"createUser".equals(link)
                && !"homepage".equals(command) && !"homepage".equals(link)
                && !"makeCarport".equals(command) && !"makeCarportForm".equals(command))
        {
            // INVALIDATE THE FAULTY SESSION.
            session.invalidate();
            // FORWARD USER.
            throw new UserException("Du er ikke logget ind");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
