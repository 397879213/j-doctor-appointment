package jdoctor.appointment.model;


public enum AppointmentTypeEnum {
    NORMAL("Normal"),
    RETURN("Retorno");
    
    public final String label;
    
    private AppointmentTypeEnum(String label) {
        this.label = label;
    }
}
