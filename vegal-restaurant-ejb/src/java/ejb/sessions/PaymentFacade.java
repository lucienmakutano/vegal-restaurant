/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.Payment;
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
public class PaymentFacade extends AbstractFacade<Payment> implements PaymentFacadeLocal {

    @PersistenceContext(unitName = "vegal-restaurant-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentFacade() {
        super(Payment.class);
    }
    
    @Override
    public void create(Payment payment) {
        em.persist(payment);
    }
    
    @Override
    public void edit(Payment payment) {
        String query = "SET user_id=?, payment_method=?, amount=?, paid_at=? WHERE payment_id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, payment.getUser());
        ejbQl.setParameter(2, payment.getPayment_method());
        ejbQl.setParameter(3, payment.getAmount());
        ejbQl.setParameter(4, payment.getPaid_at());
        ejbQl.setParameter(5, payment.getId());
        
        ejbQl.executeUpdate();
    }
    
    @Override
    public void remove(Payment payment) {
        em.remove(payment);
    }
    
    @Override
    public Payment find(Object id) {
        String query = "From Payment p WHERE p.id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, id);
        
        return (Payment) ejbQl.getSingleResult();
    }
    
    @Override
    public List<Payment> findAll() {
        return em.createQuery("From Payment").getResultList();
    }
    
    @Override
    public int count() {
        return em.createQuery("From Payment").getMaxResults();
    }
}
