package jdoctor.appointment.exception;


public class WrongPasswordException extends Exception {
    @Override
    public String getMessage(){
        return "Senha invalida.";
    }
}
