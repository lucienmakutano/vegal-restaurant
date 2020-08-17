/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.Reservation;
import ejb.entities.Reservation_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
    public List<Reservation> userReservations(Object user) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        
        Root<Reservation> reservation = criteriaQuery.from(Reservation.class);
        criteriaQuery.select(reservation);
        Predicate predicate = criteriaBuilder.equal(reservation.get(Reservation_.user), user);
        criteriaQuery.where(predicate);
        
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
