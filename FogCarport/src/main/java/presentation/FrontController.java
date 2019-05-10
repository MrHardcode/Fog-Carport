package presentation;

import data.exceptions.LoginException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private LogicFacade logic = LogicFacadeImpl.getInstance();
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
//            validateSession(request);
            Command action = Command.from(request);
            String view = action.execute(request, logic);
            request.getRequestDispatcher(view + ".jsp").forward(request, response);
        } catch (LoginException ex)
        {
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } 
    }

    // Add this in when/if we add in login functionality.
//    private void validateSession(HttpServletRequest req) throws LoginException
//    {
//        HttpSession session = req.getSession();
//        if (!(req.getParameter("command").equals("Login")))
//        {
//            if (session == null || session.getAttribute("user") == null)
//            {
//                session.invalidate();
//                throw new LoginException("Logged out because of inactivity.");
//            }
//
//        }
//    }
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
