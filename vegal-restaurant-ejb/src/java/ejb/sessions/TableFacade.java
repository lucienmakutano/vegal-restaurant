/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.Table;
import ejb.entities.Table_;
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
    public List<Table> findAllUnbookedTables() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery();
        Root<Table> table = criteriaQuery.from(Table.class);
        criteriaQuery.select(table);
        Predicate predicate = cb.equal(table.get(Table_.isBooked), false);
        criteriaQuery.where(predicate);
        
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
