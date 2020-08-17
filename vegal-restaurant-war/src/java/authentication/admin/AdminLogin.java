/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication.admin;

import ejb.entities.Admin;
import security.BCrypt;
import ejb.sessions.admin.AdminFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kenne
 */
@WebServlet(name = "AdminLogin", urlPatterns = {"/admin-login"})
public class AdminLogin extends HttpServlet {
    
    @EJB
    private AdminFacadeLocal adminFacade;

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
            dispatcher = request.getRequestDispatcher("admin-login.jsp");
            dispatcher.include(request, response);
        }else {
            Admin admin = adminFacade.findByEmail(email);
            
            if (BCrypt.checkpw(password, admin.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("id", admin.getId());
                session.setAttribute("email", admin.getEmail());
                session.setAttribute("name", admin.getName());
                session.setMaxInactiveInterval(600);
                response.sendRedirect("adminfood.jsp");
            }
            else {
                request.getSession().setAttribute("errorMessage", "Username or password is incorrect");
                dispatcher = request.getRequestDispatcher("admin-login.jsp");
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
