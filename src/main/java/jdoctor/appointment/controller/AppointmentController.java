package jdoctor.appointment.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import jdoctor.appointment.dao.AppointmentDAO;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.Appointment;
import jdoctor.appointment.model.AvailableSchedule;
import jdoctor.appointment.model.Doctor;


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
        
        if (object.getDoctor().getAvailableSchedule() == null) {
            throw new ControllerException("O doutor não registrou seus horarios");
        }
        
        // Confere horario doutor
        AvailableSchedule schedule = object.getDoctor().getAvailableSchedule();
        
        List<Date> dates = new ArrayList<>();
        switch ((object.getData()).get(Calendar.DAY_OF_WEEK)) {
            case 1: dates = new ArrayList<>(schedule.getOnSunday()); break;
            case 2: dates = new ArrayList<>(schedule.getOnMonday()); break;
            case 3: dates = new ArrayList<>(schedule.getOnTuesday()); break;
            case 4: dates = new ArrayList<>(schedule.getOnWednesday()); break;
            case 5: dates = new ArrayList<>(schedule.getOnThursday()); break;
            case 6: dates = new ArrayList<>(schedule.getOnFriday()); break;
            case 7: dates = new ArrayList<>(schedule.getOnSaturday()); break;
        }
        
        for(int i = 0; i < dates.size()/2; i+= 2) {
            Calendar aux = Calendar.getInstance();
            
            aux.setTime(dates.get(i));
            Integer start = aux.get(Calendar.HOUR_OF_DAY)*60 
                    + aux.get(Calendar.MINUTE);
            
            aux.setTime(dates.get(i+1));
            Integer end = aux.get(Calendar.HOUR_OF_DAY)*60 
                    + aux.get(Calendar.MINUTE);
            
            Integer appointmentStart = (object.getData()).get(Calendar.HOUR)*60
                    + (object.getData()).get(Calendar.MINUTE);
            
            Integer appointmentEnd = appointmentStart + object.getDuration();
            
            if (appointmentStart >= start && appointmentEnd <= end) {
                return true;
            }
        }
        
        throw new ControllerException("- O doutor não possui esse horario disponivel");
    }
    
    public ArrayList<Appointment> get(Calendar date, Doctor doctor) throws ControllerException {
        ArrayList<Appointment> appointments = new ArrayList<>();
        
        if (doctor == null) {
            return appointments;
        }
        
        for (Appointment ap : getAll()) {
            Calendar cal1 = date;
            Calendar cal2 = ap.getData();
            boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                  cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
            
            if (sameDay && ap.getDoctor().equals(doctor)) {
                appointments.add(ap);
            }
        }
        
        return appointments;
    } 
    
}
