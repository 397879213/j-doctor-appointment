package jdoctor.appointment.model;


public enum PaymentStatusEnum {
    PENDING("Pendente"),
    CONFIRMED("Confirmado");
    
    public final String label;
    
    private PaymentStatusEnum(String label) {
        this.label = label;
    }
}
