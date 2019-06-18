package jdoctor.appointment.controller;

import java.util.List;
import jdoctor.appointment.dao.SecretaryDAO;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.Doctor;
import jdoctor.appointment.model.Secretary;


public class SecretaryController implements ControllerInterface<Secretary> {
    private SecretaryDAO dao;
    private DocUserController docUserController;
    private PersonController personController;
            
    public SecretaryController() {
        dao = new SecretaryDAO();
    }
    
    @Override
    public boolean isObjectValid(Secretary object) throws ControllerException {
        personController = new PersonController();
        personController.isObjectValid(object);
        
        docUserController = new DocUserController();
        docUserController.isObjectValid(object);
        
        return true;
    }
    
    @Override
    public void save(Secretary object) throws ControllerException {
        if (isObjectValid(object)) {
            dao.save(object);
        }
    }

    @Override
    public void remove(Integer id) throws ControllerException {
        dao.remove(id);
    }

    @Override
    public List<Secretary> getAll() throws ControllerException {
        return dao.findAll();
    }
}
