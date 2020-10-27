/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;



import entities.REE;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author matti
 */
public class RE {
    
    private String bmi;
    private String name;
    private Date rDate;

    public RE() {
    }

    public RE(REE e) {
        this.bmi = e.getBmi();
        this.name=e.getName();
        this.rDate = getDate();
    }
public static List<RE>toDTO (List<REE> membersList){
        List<RE> listDTO = new ArrayList();
        for(REE gm : membersList){
                listDTO.add(new RE(gm));
        } 
        return listDTO;
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

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.bmi);
        hash = 23 * hash + Objects.hashCode(this.rDate);
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
        final RE other = (RE) obj;
        if (!Objects.equals(this.bmi, other.bmi)) {
            return false;
        }
        
        return Objects.equals(this.rDate, other.rDate);
    }

  
}
