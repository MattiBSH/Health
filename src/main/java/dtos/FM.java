/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.FME;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author matti
 */
public class FM {

    private long id;
    private String name;
    private String pw;
   

    public FM(FME m) {
        this.name = m.getName();
        this.pw = m.getPw();
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FM() {
    }

    public static List<FM>toDTO (List<FME> membersList){
        List<FM> listDTO = new ArrayList();
        for (FME gm : membersList) {
                listDTO.add(new FM(gm));
        } 
        return listDTO;
    }    
   

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.pw);
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
        final FM other = (FM) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.pw, other.pw)) {
            return false;
        }
        return true;
    }


    
    
}

