package jdoctor.appointment.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import jdoctor.appointment.util.Connection;


public class GenericDAO<T, ID extends Serializable> implements GenericDAOInterface<T, ID> {
    protected EntityManager em;
    private Class<T> entity;
    
    public GenericDAO() {
        em = Connection.getConnection();
      
        entity = (Class<T>)((ParameterizedType)getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
    
    @Override
    public boolean save(T entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }
    
    @Override
    public boolean remove(ID id) {
        
        T aux = findById(id);
        
        if (aux == null) return false;
        
        try {    
              em.getTransaction().begin();
              em.remove(aux);
              em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;        
    }
    
    @Override
    public T findById(ID id) {
        return em.find(entity, id);
    }
    
    @Override
    public List<T> findAll() {
        String jpql = "select e from "
                   +entity.getName()+" e ";
        return
            em.createQuery(jpql).getResultList();
    }
}
