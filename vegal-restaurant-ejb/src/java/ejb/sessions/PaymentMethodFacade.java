/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.PaymentMethod;
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
public class PaymentMethodFacade extends AbstractFacade<PaymentMethod> implements PaymentMethodFacadeLocal {

    @PersistenceContext(unitName = "vegal-restaurant-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentMethodFacade() {
        super(PaymentMethod.class);
    }
    
    @Override
    public void create(PaymentMethod paymentMethod) {
        em.persist(paymentMethod);
    }
    
    @Override
    public void edit(PaymentMethod paymentMethod) {
        String query = "SET name=?, supported_at=? WHERE id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, paymentMethod.getName());
        ejbQl.setParameter(2, paymentMethod.getSupported_at());
        ejbQl.setParameter(3, paymentMethod.getId());
        
        ejbQl.executeUpdate();
    }
    
    @Override
    public void remove(PaymentMethod paymentMethod) {
        em.remove(paymentMethod);
    }
    
    @Override
    public PaymentMethod find(Object id) {
        String query = "From PaymentMethod pM WHERE pM.id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, id);
        
        return (PaymentMethod) ejbQl.getSingleResult();
    }
    
    @Override
    public List<PaymentMethod> findAll() {
        return em.createQuery("From PaymentMethod").getResultList();
    }
    
    @Override
    public int count() {
        return em.createQuery("From PaymentMethod").getMaxResults();
    }
}
