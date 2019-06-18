package jdoctor.appointment.view;


public interface FormInterface<Obj> {
    public void cleanForm();
    public void setForm(Obj entity);
    public void formToObject(Object object);
}
