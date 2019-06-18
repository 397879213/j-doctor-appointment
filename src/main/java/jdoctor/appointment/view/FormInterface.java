package jdoctor.appointment.view;


public interface FormInterface<Obj> {
    public void cleanForm();
    public boolean isFormValid();
    public void addError(String error);
    public void setForm(Obj entity);
    public void formToObject(Object object);
}
