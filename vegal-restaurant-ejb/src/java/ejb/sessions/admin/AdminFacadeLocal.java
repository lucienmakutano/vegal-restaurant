/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions.admin;

import ejb.entities.Admin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author makut
 */
@Local
public interface AdminFacadeLocal {

    void create(Admin admin);

    void edit(Admin admin);

    void remove(Admin admin);

    Admin find(Object id);
    
    Admin findByEmail(Object email);

    List<Admin> findAll();

    List<Admin> findRange(int[] range);

    int count();
    
}
