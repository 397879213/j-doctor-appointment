package jdoctor.appointment.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jdoctor.appointment.dao.DoctorDAO;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.AvailableSchedule;
import jdoctor.appointment.model.DocUser;
import jdoctor.appointment.model.Doctor;
import jdoctor.appointment.model.UserRolesEnum;
import jdoctor.appointment.util.PasswordUtils;


public class DoctorController implements ControllerInterface<Doctor> {
    private DoctorDAO dao;
    private DocUserController docUserController;
    private PersonController personController;
            
    public DoctorController() {
        dao = new DoctorDAO();
    }
    
    @Override
    public boolean isObjectValid(Doctor object) throws ControllerException {
        personController = new PersonController();
        personController.isObjectValid(object);
        
        docUserController = new DocUserController();
        docUserController.isObjectValid(object);
        
        if (object.getSpecialization().length() < 1) {
            throw new ControllerException("Medico precisa de uma especialização");
        }
        
        if ((object.getPasswordSalt() == null || object.getPasswordSalt().isEmpty()) && 
                object.getPassword().length() <= 4) {
            throw new ControllerException("Senha deve possuir mais que 4"
                    + " caracteres");
        }
        
        return true;
    }
    
    @Override
    public void save(Doctor object) throws ControllerException {
        if (isObjectValid(object)) {
                     
            // Trata senha
            if (object.getPasswordSalt() == null || object.getPasswordSalt().isEmpty()) {
                object.setPasswordSalt(PasswordUtils.getSalt());
                object.setPassword(PasswordUtils.generateSecurePassword(
                        object.getPassword(), object.getPasswordSalt()));
            }
            
            // Trata Permissões iniciais
            if (object.getRoles() == null || object.getRoles().isEmpty()) {
               Set<UserRolesEnum> roles = new HashSet<>();
               roles.add(UserRolesEnum.EDIT_APPOINTMENT);

               if (docUserController.getAll().isEmpty()) {
                   roles.add(UserRolesEnum.ADMIN);
               }
               
               object.setRoles(roles);
            } 
            
            // Trata schelude
            if (object.getAvailableSchedule() == null) {
                object.setAvailableSchedule(new AvailableSchedule(null, 
                        object));
            }
            
            // Trata nick igual
            for (DocUser user : docUserController.getAll()) {
                if (user.getUserNick().equals(object.getUserNick()) && user.getId() != object.getId()) {
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
    public List<Doctor> getAll() throws ControllerException {
        return dao.findAll();
    }
    
    public Doctor get(Integer id) throws ControllerException {
        return dao.findById(id);
    }
}
