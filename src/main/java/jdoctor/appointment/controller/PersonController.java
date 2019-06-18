package jdoctor.appointment.controller;

import java.util.List;
import jdoctor.appointment.dao.PersonDAO;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.Person;
import jdoctor.appointment.util.Validation;


public class PersonController implements ControllerInterface<Person> {
    private PersonDAO dao;
            
    public PersonController() {
        dao = new PersonDAO();
    }
    
    @Override
    public boolean isObjectValid(Person object) throws ControllerException {
        if (object.getName().isEmpty() ||
                object.getDocCPF().isEmpty() ||
                object.getDocRG().isEmpty() ||
                object.getEmail().isEmpty() ||
                object.getPhoneNumber().isEmpty() ) {
            throw new ControllerException("Campos do formulario "
                    + "Pessoa não pode ser nulo");
        }
        
        if(object.getPhoneNumber().length() < 7) {
            throw new ControllerException("Digite um numero de telefone valido");
        }
        
        if (!Validation.isEmailValid(object.getEmail().trim())) {
            throw new ControllerException("Email é invalido");
        }
        
        if (!Validation.isDocCPFValid(object.getDocCPF())) {
            throw new ControllerException ("CPF é invalido");
        }
        
        return true;
    }
    
    @Override
    public void save(Person object) throws ControllerException {
        if (isObjectValid(object)) {
            dao.save(object);
        }
    }

    @Override
    public void remove(Integer id) throws ControllerException {
        dao.remove(id);
    }

    @Override
    public List<Person> getAll() throws ControllerException {
        return dao.findAll();
    }
}
