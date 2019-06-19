package jdoctor.appointment.controller;

import java.util.List;
import jdoctor.appointment.dao.DocUserDAO;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.DocUser;
import jdoctor.appointment.util.PasswordUtils;


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
        try {
            if (isObjectValid(object)) {
                dao.save(object);
            }
        } catch (Exception e) {
            throw new ControllerException("Falha ao salvar usuario "+e.getMessage());
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
    
    public DocUser get(String userNick) {
        for (DocUser user : dao.findAll()) {
            if (user.getUserNick().equals(userNick)) {
                return user;
            }
        }
        return null;
    }
    
    public void login(String userNick, String password) throws ControllerException {
        dao = new DocUserDAO();
        
        for (DocUser user : dao.findAll()) {
            if (user.getUserNick().equals(userNick)) {
                if(PasswordUtils.verifyUserPassword(password, 
                        user.getPassword(), user.getPasswordSalt())) {
                    return;
                } else {
                    throw new ControllerException("Senha invalida");
                }
            }
        }
        
        throw new ControllerException("Usuario não encontrado");
    }
}
