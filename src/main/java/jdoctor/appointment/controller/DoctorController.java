package jdoctor.appointment.controller;

import java.util.List;
import jdoctor.appointment.dao.DoctorDAO;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.Doctor;


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
        
        return true;
    }
    
    @Override
    public void save(Doctor object) throws ControllerException {
        if (isObjectValid(object)) {
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
}
