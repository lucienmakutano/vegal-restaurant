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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author makut
 */
@Entity
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "reservation_date")
    private Date reservation_date;

    /**
     * Get the value of reservation_date
     *
     * @return the value of reservation_date
     */
    public Date getReservation_date() {
        return reservation_date;
    }

    /**
     * Set the value of reservation_date
     *
     * @param reservation_date new value of reservation_date
     */
    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    @Column(name = "telephone_number")
    private String phone;

    /**
     * Get the value of phone
     *
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @OneToOne
    private Table table;

    /**
     * Get the value of table
     *
     * @return the value of table
     */
    public Table getTable() {
        return table;
    }

    /**
     * Set the value of table
     *
     * @param table new value of table
     */
    public void setTable(Table table) {
        this.table = table;
    }
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date reserved_at;
    

    /**
     * Get the value of reserved_at
     *
     * @return the value of reserved_at
     */
    public Date getReserved_at() {
        return reserved_at;
    }

    /**
     * Set the value of reserved_at
     *
     * @param reserved_at new value of reserved_at
     */
    public void setReserved_at(Date reserved_at) {
        this.reserved_at = reserved_at;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ejb.entities.Reservation[ id=" + id + " ]";
    }
    
}
