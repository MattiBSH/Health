/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author matti
 */
@Entity
public class REE implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bmi;
    
    @Temporal(TemporalType.DATE)
    private Date rDate;
    private String name;
    private String pw;
    
    
    public REE() {
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public REE(String bmi, String name, String pw) {
        this.bmi = bmi;
        this.name = name;
        this.pw = pw;
        this.rDate=getDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

  
    
    
    public REE(String bmi) {
        this.bmi = bmi;
        this.rDate = getDate();
    }

    public String getBMI() {
        return bmi;
    }

    public void setBMI(String BMI) {
        this.bmi = BMI;
    }

    public final Date getDate() {
        return new Date();
    }

    public void setUtilDate(Date rDate) {
        this.rDate = rDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.bmi);
        hash = 17 * hash + Objects.hashCode(this.rDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final REE other = (REE) obj;
        if (!Objects.equals(this.bmi, other.bmi)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.rDate, other.rDate)) {
            return false;
        }
        return true;
    }
    
    
}
