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
public class Payment implements Serializable {

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

    @ManyToOne
    private PaymentMethod payment_method;

    /**
     * Get the value of payment_method
     *
     * @return the value of payment_method
     */
    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    /**
     * Set the value of payment_method
     *
     * @param payment_method new value of payment_method
     */
    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
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
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date paid_at;

    /**
     * Get the value of paid_at
     *
     * @return the value of paid_at
     */
    public Date getPaid_at() {
        return paid_at;
    }

    /**
     * Set the value of paid_at
     *
     * @param paid_at new value of paid_at
     */
    public void setPaid_at(Date paid_at) {
        this.paid_at = paid_at;
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
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ejb.entities.Payment[ id=" + id + " ]";
    }
    
}
