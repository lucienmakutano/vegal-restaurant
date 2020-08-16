/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication.user;

import ejb.entities.User;
import security.BCrypt;
import ejb.sessions.UserFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author makut
 */
public class Login extends HttpServlet {

    @EJB
    private UserFacadeLocal userFacade;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        RequestDispatcher dispatcher = null;
        
        if (email == null || password == null || email.equals("") || password.equals("")) {
            request.getSession().setAttribute("errorMessage", "Please fill in all the fields");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.include(request, response);
        }else {
            User user = userFacade.findByEmail(email);
            
            if (BCrypt.checkpw(password, user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("name", user.getName());
                session.setMaxInactiveInterval(600);
                response.sendRedirect("home.jsp");
            }
            else {
                request.getSession().setAttribute("errorMessage", "Username of password is incorrect");
                dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.include(request, response);
            }
        }
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
