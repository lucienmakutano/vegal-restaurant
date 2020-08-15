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
public class Food implements Serializable {

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
    
    private double string;

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public double getString() {
        return string;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setString(double string) {
        this.string = string;
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
    
    private String image;

    /**
     * Get the value of image
     *
     * @return the value of image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set the value of image
     *
     * @param image new value of image
     */
    public void setImage(String image) {
        this.image = image;
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

    @OneToMany(mappedBy = "food")
    private List<OrderFood> orders;

    /**
     * Get the value of orders
     *
     * @return the value of orders
     */
    public List<OrderFood> getOrders() {
        return orders;
    }

    /**
     * Set the value of orders
     *
     * @param orders new value of orders
     */
    public void setOrders(List<OrderFood> orders) {
        this.orders = orders;
    }


    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date_added;

    /**
     * Get the value of date_added
     *
     * @return the value of date_added
     */
    public Date getDate_added() {
        return date_added;
    }

    /**
     * Set the value of date_added
     *
     * @param date_added new value of date_added
     */
    public void setDate_added(Date date_added) {
        this.date_added = date_added;
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
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ejb.entities.Food[ id=" + id + " ]";
    }
    
}
