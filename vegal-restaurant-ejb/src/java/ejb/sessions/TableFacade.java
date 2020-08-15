/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.Table;
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
public class TableFacade extends AbstractFacade<Table> implements TableFacadeLocal {

    @PersistenceContext(unitName = "vegal-restaurant-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TableFacade() {
        super(Table.class);
    }
    
    @Override
    public void create(Table table) {
        em.persist(table);
    }
    
    @Override
    public void edit(Table table) {
        String query = "SET numOfSeats=?, isBooked=? WHERE id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, table.getNumOfSeats());
        ejbQl.setParameter(2, table.getIsBooked());
        ejbQl.setParameter(3, table.getId());
        
        ejbQl.executeUpdate();
    }
    
    @Override
    public void remove(Table table) {
        em.remove(table);
    }
    
    @Override
    public Table find(Object id) {
        String query = "From Table t WHERE t.id=?";
        
        Query ejbQl = em.createQuery(query);
        
        ejbQl.setParameter(1, id);
        
        return (Table) ejbQl.getSingleResult();
    }
    
    @Override
    public List<Table> findAll() {
        return em.createQuery("From Table").getResultList();
    }
    
    @Override
    public int count() {
        return em.createQuery("From Table").getMaxResults();
    }
}
