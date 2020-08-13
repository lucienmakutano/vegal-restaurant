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
import javax.persistence.Temporal;

/**
 *
 * @author makut
 */
@Entity
public class Table implements Serializable {

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

    private int numOfSeats;

    /**
     * Get the value of numOfSeats
     *
     * @return the value of numOfSeats
     */
    public int getNumOfSeats() {
        return numOfSeats;
    }

    /**
     * Set the value of numOfSeats
     *
     * @param numOfSeats new value of numOfSeats
     */
    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    
    private boolean isBooked;

    /**
     * Get the value of isBooked
     *
     * @return the value of isBooked
     */
    public boolean isIsBooked() {
        return isBooked;
    }

    /**
     * Set the value of isBooked
     *
     * @param isBooked new value of isBooked
     */
    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
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
        if (!(object instanceof Table)) {
            return false;
        }
        Table other = (Table) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ejb.entities.Table[ id=" + id + " ]";
    }
    
}
