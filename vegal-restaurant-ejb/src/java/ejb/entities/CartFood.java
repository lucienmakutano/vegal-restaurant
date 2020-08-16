/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author makut
 */
@Entity
public class CartFood implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_food_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @ManyToOne
    private Cart cart;

    /**
     * Get the value of cart
     *
     * @return the value of cart
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Set the value of cart
     *
     * @param cart new value of cart
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @ManyToOne
    private Food food;

    /**
     * Get the value of food
     *
     * @return the value of food
     */
    public Food getFood() {
        return food;
    }

    /**
     * Set the value of food
     *
     * @param food new value of food
     */
    public void setFood(Food food) {
        this.food = food;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date_updated;

    /**
     * Get the value of date_updated
     *
     * @return the value of date_updated
     */
    public Date getDate_updated() {
        return date_updated;
    }

    /**
     * Set the value of date_updated
     *
     * @param date_updated new value of date_updated
     */
    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
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
        if (!(object instanceof CartFood)) {
            return false;
        }
        CartFood other = (CartFood) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ejb.entities.CartFood[ id=" + id + " ]";
    }
    
}
