package jdoctor.appointment.view.form;

import jdoctor.appointment.exception.VisionException;


public interface FormInterface<Obj> {
    public void cleanForm();
    public void setForm(Obj entity);
    public void formToObject(Object object) throws VisionException;
}
