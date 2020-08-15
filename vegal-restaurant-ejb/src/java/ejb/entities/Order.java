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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author makut
 */
@Entity
public class Order implements Serializable {

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
    
    @OneToMany(mappedBy = "order")
    private List<OrderFood> foods;

    /**
     * Get the value of foods
     *
     * @return the value of foods
     */
    public List<OrderFood> getFoods() {
        return foods;
    }

    /**
     * Set the value of foods
     *
     * @param foods new value of foods
     */
    public void setFoods(List<OrderFood> foods) {
        this.foods = foods;
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

    private double amount;

    /**
     * Get the value of amount
     *
     * @return the value of amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Set the value of amount
     *
     * @param amount new value of amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    private boolean isShipped;

    /**
     * Get the value of isShipped
     *
     * @return the value of isShipped
     */
    public boolean isIsShipped() {
        return isShipped;
    }

    /**
     * Set the value of isShipped
     *
     * @param isShipped new value of isShipped
     */
    public void setIsShipped(boolean isShipped) {
        this.isShipped = isShipped;
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
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Order[ id=" + id + " ]";
    }
    
}
