/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.Reservation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author makut
 */
@Local
public interface ReservationFacadeLocal {

    void create(Reservation reservation);

    void edit(Reservation reservation);

    void remove(Reservation reservation);

    Reservation find(Object id);

    List<Reservation> findAll();
    
    List<Reservation> userReservations(Object user);

    List<Reservation> findRange(int[] range);

    int count();
    
}
