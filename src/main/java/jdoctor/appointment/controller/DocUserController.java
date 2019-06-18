package jdoctor.appointment.controller;

import java.util.List;
import jdoctor.appointment.dao.DocUserDAO;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.DocUser;


public class DocUserController implements ControllerInterface<DocUser> {
    private DocUserDAO dao;
            
    public DocUserController() {
        dao = new DocUserDAO();
    }
    
    @Override
    public boolean isObjectValid(DocUser object) throws ControllerException {
        if (object.getUserNick().length() <= 3) {
            throw new ControllerException("O Usuario deve ter mais que 3 caracteres");
        }
        
        return true;
    }
    
    @Override
    public void save(DocUser object) throws ControllerException {
        if (isObjectValid(object)) {
            dao.save(object);
        }
    }

    @Override
    public void remove(Integer id) throws ControllerException {
        dao.remove(id);
    }

    @Override
    public List<DocUser> getAll() throws ControllerException {
        return dao.findAll();
    }
}
