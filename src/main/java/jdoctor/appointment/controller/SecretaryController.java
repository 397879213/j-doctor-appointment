package jdoctor.appointment.controller;

import java.util.List;
import jdoctor.appointment.dao.SecretaryDAO;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.DocUser;
import jdoctor.appointment.model.Doctor;
import jdoctor.appointment.model.Secretary;
import jdoctor.appointment.util.PasswordUtils;


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
        
        if ((object.getPasswordSalt() == null || object.getPasswordSalt().isEmpty()) && 
                object.getPassword().length() <= 4) {
            throw new ControllerException("Senha deve possuir mais que 4"
                    + " caracteres");
        }
        
        return true;
    }
    
    @Override
    public void save(Secretary object) throws ControllerException {
        if (isObjectValid(object)) {
            if (object.getPasswordSalt() == null || object.getPasswordSalt().isEmpty()) {
                object.setPasswordSalt(PasswordUtils.getSalt());
                object.setPassword(PasswordUtils.generateSecurePassword(
                        object.getPassword(), object.getPasswordSalt()));
            }
            
            // Trata nick igual
            for (DocUser user : docUserController.getAll()) {
                if (user.getUserNick().equals(object.getUserNick())) {
                    throw new ControllerException("Ja existe um usuario com "
                            + "esse nome de usuario");
                }
            }
            
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
