/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import dtos.FM;
import static dtos.FM.toDTO;
import entities.FME;
import entities.REE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

public class FMF {

    private static FMF instance;
    private static EntityManagerFactory emf;

    private FMF() {

    }

    public static FMF getGMPFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FMF();
        }
        return instance;
    }
    public List<FM> getAll(){
        
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<FME> query = 
                       em.createQuery("Select m from FME m", FME.class);
            List <FME>members= query.getResultList();
            
            List<FM>membersDTO=toDTO(members);
            return membersDTO;
        }finally {
            em.close();
        }}
    
     public FM findIfExist(String name){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<FME> query = em.createQuery(
        "SELECT f FROM FME f WHERE f.name = '" + name + "'",
        FME.class);
            if(query.getResultList().size()!=0){
                FME fme= query.getSingleResult();
                return new FM(fme);
            }else{
            return new FM(new FME("it does not","Exist"));
        }
            
            
        }finally {
            em.close();
        }
        
}



        
     

        
    public void add(String name, String pw){
        
         EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            FME p = new FME(name,pw);
            em.persist(p);
            em.getTransaction().commit();
        }finally {
            em.close();
        }}
    
    
    


    

}
