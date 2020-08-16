/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author makut
 */
@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @OneToOne
    private User user_id;

    /**
     * Get the value of user_id
     *
     * @return the value of user_id
     */
    public User getUser_id() {
        return user_id;
    }

    /**
     * Set the value of user_id
     *
     * @param user_id new value of user_id
     */
    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
    
    private double total_amount;

    /**
     * Get the value of total_amount
     *
     * @return the value of total_amount
     */
    public double getTotal_amount() {
        return total_amount;
    }

    /**
     * Set the value of total_amount
     *
     * @param total_amount new value of total_amount
     */
    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
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

    
    @OneToMany(mappedBy = "cart")
    private List<CartFood> cart_foods;

    /**
     * Get the value of cart_foods
     *
     * @return the value of cart_foods
     */
    public List<CartFood> getCart_foods() {
        return cart_foods;
    }

    /**
     * Set the value of cart_foods
     *
     * @param cart_foods new value of cart_foods
     */
    public void setCart_foods(List<CartFood> cart_foods) {
        this.cart_foods = cart_foods;
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
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ejb.entities.Cart[ id=" + id + " ]";
    }
    
}
