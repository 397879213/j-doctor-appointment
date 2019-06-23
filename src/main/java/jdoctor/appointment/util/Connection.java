package jdoctor.appointment.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.eclipse.persistence.sessions.Session;


public class Connection {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jdocPU");
    private static EntityManager em;
    
    private Connection(){
    }
    
    public static EntityManager getConnection(){
         
        if (em == null)
         em = emf.createEntityManager();
        
        return em;
    } 
    
    public static java.sql.Connection getConnectionC() {
        try {
            return ((EntityManagerImpl) (em.getDelegate())).getServerSession().getAccessor().getConnection();
        } catch (Exception e) {
            return null;
        }
    }
}
