package jdoctor.appointment.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDAOInterface<T,ID extends Serializable> {
    public boolean save(T entidade);
    public boolean remove(ID id);
    public T findById(ID id);
    public List<T> findAll();
}
