/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Local;

/**
 *
 * @author makut
 */
@Local
public interface SessionBeanLocal {

    Integer sum(int a, int b);
    
}
