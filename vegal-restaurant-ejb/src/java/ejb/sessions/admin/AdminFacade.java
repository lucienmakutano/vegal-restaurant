/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions.admin;

import ejb.entities.Admin;
import ejb.entities.Admin_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author makut
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> implements AdminFacadeLocal {

    @PersistenceContext(unitName = "vegal-restaurant-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }

    /**
     * returns the admin object filtered by email
     * 
     * @param email
     * @return 
     */
    @Override
    public Admin findByEmail(Object email) {
        javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
        Root<Admin> admin = cq.from(Admin.class);
        cq.select(admin);
        Predicate predicate = cb.equal(admin.get(Admin_.email), email);
        cq.where(predicate);
//      
        return (Admin) getEntityManager().createQuery(cq).getSingleResult();
    }
    
}
