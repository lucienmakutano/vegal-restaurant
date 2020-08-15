/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.OrderFood;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author makut
 */
@Local
public interface OrderFoodFacadeLocal {

    void create(OrderFood orderFood);

    void edit(OrderFood orderFood);

    void remove(OrderFood orderFood);

    OrderFood find(Object id);

    List<OrderFood> findAll();

    List<OrderFood> findRange(int[] range);

    int count();
    
}
