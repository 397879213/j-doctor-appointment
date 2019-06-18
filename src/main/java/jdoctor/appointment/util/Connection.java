package jdoctor.appointment.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Connection {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jdocPU");
    private static EntityManager em;
    
    private Connection(){
    }
    
    public static EntityManager getConexao(){
         
        if (em == null)
         em = emf.createEntityManager();
        
        return em;
    } 
}
