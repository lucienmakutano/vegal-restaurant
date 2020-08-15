/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.OrderFood;
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
public class OrderFoodFacade extends AbstractFacade<OrderFood> implements OrderFoodFacadeLocal {

    @PersistenceContext(unitName = "vegal-restaurant-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderFoodFacade() {
        super(OrderFood.class);
    }
    
    @Override
    public void create(OrderFood orderFood) {
        em.persist(orderFood);
    }
    
    @Override
    public void edit(OrderFood orderFood) {
        String query = "SET order_id=?, food_id=?, qty=?, date_ordered=? WHERE id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, orderFood.getOrder());
        ejbQl.setParameter(2, orderFood.getFood());
        ejbQl.setParameter(3, orderFood.getQuantity());
        ejbQl.setParameter(4, orderFood.getDate_ordered());
        ejbQl.setParameter(5, orderFood.getId());
        
        ejbQl.executeUpdate();
    }
    
    @Override
    public void remove(OrderFood orderFood) {
        em.remove(orderFood);
    }
    
    @Override
    public OrderFood find(Object id) {
        String query = "From OrderFood oF WHERE oF.id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, id);
        
        return (OrderFood) ejbQl.getSingleResult();
    }
    
    @Override
    public List<OrderFood> findAll() {
        return em.createQuery("From OrderFood").getResultList();
    }
    
    @Override
    public int count() {
        return em.createQuery("From OrderFood").getMaxResults();
    }
}
