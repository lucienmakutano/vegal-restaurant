/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.Date;
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
public class OrderFood implements Serializable {

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
    
    @ManyToOne
    private Order order_id;

    /**
     * Get the value of order_id
     *
     * @return the value of order_id
     */
    public Order getOrder_id() {
        return order_id;
    }

    /**
     * Set the value of order_id
     *
     * @param order_id new value of order_id
     */
    public void setOrder_id(Order order_id) {
        this.order_id = order_id;
    }

    @ManyToOne
    private Food food_id;

    /**
     * Get the value of food_id
     *
     * @return the value of food_id
     */
    public Food getFood_id() {
        return food_id;
    }

    /**
     * Set the value of food_id
     *
     * @param food_id new value of food_id
     */
    public void setFood_id(Food food_id) {
        this.food_id = food_id;
    }

    private int quantity;

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date_ordered;

    /**
     * Get the value of date_ordered
     *
     * @return the value of date_ordered
     */
    public Date getDate_ordered() {
        return date_ordered;
    }

    /**
     * Set the value of date_ordered
     *
     * @param date_ordered new value of date_ordered
     */
    public void setDate_ordered(Date date_ordered) {
        this.date_ordered = date_ordered;
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
        if (!(object instanceof OrderFood)) {
            return false;
        }
        OrderFood other = (OrderFood) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ejb.entities.OrderFood[ id=" + id + " ]";
    }
    
}
