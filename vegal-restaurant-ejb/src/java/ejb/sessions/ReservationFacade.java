/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.Reservation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author makut
 */
@Stateless
public class ReservationFacade extends AbstractFacade<Reservation> implements ReservationFacadeLocal {

    @PersistenceContext(unitName = "vegal-restaurant-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationFacade() {
        super(Reservation.class);
    }
    
    @Override
    public void create(Reservation reservation) {
        em.persist(reservation);
    }
    
    @Override
    public void edit(Reservation reservation) {
        String query = "SET numOfSeats=?, isBooked=? WHERE id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, reservation.getNumOfSeats());
        ejbQl.setParameter(2, reservation.getIsBooked());
        ejbQl.setParameter(3, reservation.getId());
        
        ejbQl.executeUpdate();
    }
    
    @Override
    public void remove(Reservation reservation) {
        em.remove(reservation);
    }
    
    @Override
    public Reservation find(Object id) {
        String query = "From Reservation r WHERE r.id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, id);
        
        return (Reservation) ejbQl.getSingleResult();
    }
    
    @Override
    public List<Reservation> findAll() {
        return em.createQuery("From Reservation").getResultList();
    }
    
    @Override
    public int count() {
        return em.createQuery("From Reservation").getMaxResults();
    }
}
