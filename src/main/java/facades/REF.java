/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import dtos.RE;
import static dtos.RE.toDTO;
import entities.FME;
import entities.REE;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author matti
 */
public class REF {
     private static REF instance;
    private static EntityManagerFactory emf;

    private REF() {

    }

    public static REF getGMPFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new REF();
        }
        return instance;
    }
    public void add(String bmi, String name, String pw){
        
         EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            REE r = new REE( bmi,name,pw);
            em.persist(r);
            em.getTransaction().commit();
        }finally {
            em.close();
        }}
    public List<RE> getAll(){
        
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<REE> query = 
                       em.createQuery("Select r from REE r", REE.class);
            List <REE>list= query.getResultList();
            
            List<RE>membersDTO=toDTO(list);
            return membersDTO;
        }finally {
            em.close();}}
}
