package jdoctor.appointment.exception;


public class DocUserNotExistException extends Exception {
    @Override
    public String getMessage(){
        return "Usuario não existe.";
    }
}
