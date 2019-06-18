package jdoctor.appointment.exception;


public class ControllerException extends Exception {
    public ControllerException() {
        super();
    }
    
    public ControllerException(String msg){
        super(msg);
    }
}
