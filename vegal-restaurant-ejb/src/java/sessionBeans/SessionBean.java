/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;

/**
 *
 * @author makut
 */
@Stateless
public class SessionBean implements SessionBeanLocal {

    @Override
    public Integer sum(int a, int b) {
        return a + b;
    }
}
