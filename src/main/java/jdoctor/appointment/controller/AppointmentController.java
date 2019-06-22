package jdoctor.appointment.controller;

import java.util.List;
import jdoctor.appointment.dao.AppointmentDAO;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.Appointment;


public class AppointmentController implements ControllerInterface<Appointment>{
    AppointmentDAO dao;
    
    public AppointmentController() {
        dao = new AppointmentDAO();
    }
    
    @Override
    public void save(Appointment object) throws ControllerException {
        try {
            if (isObjectValid(object)) {
                dao.save(object);
            }
        } catch (Exception e) {
            throw new ControllerException("Falha ao salvar consulta "+e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) throws ControllerException {
        dao.remove(id);
    }

    @Override
    public List<Appointment> getAll() throws ControllerException {
        return dao.findAll();
    }

    @Override
    public boolean isObjectValid(Appointment object) throws ControllerException {
        if(object.getDoctor() == null) {
            throw new ControllerException("você deve escolher um doutor");
        }
        
        if(object.getPerson() == null) {
            throw new ControllerException("você deve escolher um paciente");
        }
        
        //System.out.println(object.get)
        
        return true;
    }
    
}
