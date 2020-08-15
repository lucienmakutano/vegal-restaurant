/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.CartFood;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author makut
 */
@Local
public interface CartFoodFacadeLocal {

    void create(CartFood cartFood);

    void edit(CartFood cartFood);

    void remove(CartFood cartFood);

    CartFood find(Object id);

    List<CartFood> findAll();

    List<CartFood> findRange(int[] range);

    int count();
    
}
