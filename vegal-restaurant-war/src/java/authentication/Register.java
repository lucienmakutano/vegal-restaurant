/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import ejb.entities.User;
import ejb.sessions.UserFacade;
import ejb.sessions.UserFacadeLocal;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.BCrypt;

/**
 *
 * @author makut
 */
public class Register extends HttpServlet {

    @EJB
    private final UserFacadeLocal userFacade;
    
    /**
     * 
     * @var User user
     */
    private final User user;

    public Register() {
        user = new User();
        userFacade = new UserFacade();
    }
    
    
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
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("re_pass");
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(16));
        
        RequestDispatcher dispatcher = null;
        
        if (name == null || email == null || password == null) {
            request.getSession().setAttribute("errorMessage", "Please fill in all the fields");
            dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.include(request, response);
        }
        else if ( ! confirmPassword.equals(password) ) {
            request.getSession().setAttribute("errorMessage", "The passwords must match");
            dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.include(request, response);
        }
        else{
            user.setName(name);
            user.setEmail(email);
            user.setPassword(hashedPassword);
            user.setUser_role("customer");
            user.setDate_created(new Date());

            userFacade.create(user);
            response.sendRedirect("/index.jsp");
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
