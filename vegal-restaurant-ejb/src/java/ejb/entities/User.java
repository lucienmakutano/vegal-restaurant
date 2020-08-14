/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author makut
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

        private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    private String role;

    /**
     * Get the value of role
     *
     * @return the value of role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the value of role
     *
     * @param role new value of role
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    /**
     * Get the value of orders
     *
     * @return the value of orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Set the value of orders
     *
     * @param orders new value of orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    
    @OneToMany(mappedBy = "user")
    private java.util.List<Payment> payments;

    /**
     * Get the value of payments
     *
     * @return the value of payments
     */
    public java.util.List<Payment> getPayments() {
        return payments;
    }

    /**
     * Set the value of payments
     *
     * @param payments new value of payments
     */
    public void setPayments(java.util.List<Payment> payments) {
        this.payments = payments;
    }

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    /**
     * Get the value of reservations
     *
     * @return the value of reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Set the value of reservations
     *
     * @param reservations new value of reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date_created;

    /**
     * Get the value of date_created
     *
     * @return the value of date_created
     */
    public Date getDate_created() {
        return date_created;
    }

    /**
     * Set the value of date_created
     *
     * @param date_created new value of date_created
     */
    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ejb.entities.User[ id=" + id + " ]";
    }
    
}
