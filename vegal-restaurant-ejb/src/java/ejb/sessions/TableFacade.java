/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.Table;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
