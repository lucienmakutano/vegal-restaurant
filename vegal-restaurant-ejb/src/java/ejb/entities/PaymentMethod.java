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
public class PaymentMethod implements Serializable {

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
    
    @OneToMany(mappedBy = "payment_method")
    private List<Payment> payments;

    /**
     * Get the value of payments
     *
     * @return the value of payments
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * Set the value of payments
     *
     * @param payments new value of payments
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date supported_at;

    /**
     * Get the value of supported_at
     *
     * @return the value of supported_at
     */
    public Date getSupported_at() {
        return supported_at;
    }

    /**
     * Set the value of supported_at
     *
     * @param supported_at new value of supported_at
     */
    public void setSupported_at(Date supported_at) {
        this.supported_at = supported_at;
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
        if (!(object instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod other = (PaymentMethod) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ejb.entities.PaymentMethod[ id=" + id + " ]";
    }
    
}
