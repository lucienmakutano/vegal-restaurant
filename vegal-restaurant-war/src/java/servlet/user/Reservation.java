/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.user;

import ejb.entities.Table;
import ejb.entities.User;
import ejb.sessions.ReservationFacadeLocal;
import ejb.sessions.TableFacadeLocal;
import ejb.sessions.UserFacadeLocal;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author makut
 */
public class Reservation extends HttpServlet {

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private TableFacadeLocal tableFacade;

    @EJB
    private ReservationFacadeLocal reservationFacade;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        String phone = request.getParameter("phone");
        int table_id = Integer.parseInt(request.getParameter("table_id"));
        Object user_id = request.getSession().getAttribute("user_id");
        
        Date reservation_date = new SimpleDateFormat("dd-MM-yyyy H:m:s").parse(request.getParameter("reservation_date"));
        
        Table table = tableFacade.find(table_id);
        User user = userFacade.find(user_id);
        
        ejb.entities.Reservation reservation = new ejb.entities.Reservation();
        
        reservation.setReserved_at(new Date());
        reservation.setPhone(phone);
        reservation.setReservation_date(reservation_date);
        reservation.setUser(user);
        reservation.setTable(table);
        
        reservationFacade.create(reservation);
        
        table.setIsBooked(true);
        tableFacade.edit(table);
        request.setAttribute("error", "Your booking was success");
        response.sendRedirect("reservation-page");
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
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
