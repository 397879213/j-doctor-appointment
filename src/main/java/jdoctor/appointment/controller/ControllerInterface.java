package jdoctor.appointment.controller;

import java.util.List;
import jdoctor.appointment.exception.ControllerException;


public interface ControllerInterface<Obj> {
    public void save(Obj object) throws ControllerException;
    public void remove(Integer id) throws ControllerException;
    public List<Obj> getAll() throws ControllerException;
    public boolean isObjectValid(Obj object) throws ControllerException;
}
