/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.User;
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
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "vegal-restaurant-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    @Override
    public void create(User user) {
        em.persist(user);
    }
    
    @Override
    public void edit(User user) {
        String query = "SET name=?, email=?, password=? WHERE user_id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, user.getName());
        ejbQl.setParameter(2, user.getEmail());
        ejbQl.setParameter(3, user.getPassword());
        ejbQl.setParameter(4, user.getId());
        
        ejbQl.executeUpdate();
    }
    
    @Override
    public void remove(User user) {
        em.remove(user);
    }
    
    @Override
    public User find(Object id) {
        String query = "From User u WHERE u.id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, id);
        
        return (User) ejbQl.getSingleResult();
    }
    
    @Override
    public List<User> findAll() {
        return em.createQuery("From User").getResultList();
    }
    
    @Override
    public int count() {
        return em.createQuery("From User").getMaxResults();
    }
}
