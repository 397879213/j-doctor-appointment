package jdoctor.appointment.util;

import br.com.caelum.stella.validation.CPFValidator;
import java.util.regex.Pattern;


public class Validation {
    private static final String EMAIL_PATTERN = 
    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    
    private static final CPFValidator cpfValidator = new CPFValidator();
    
    public static boolean isEmailValid(String email) {
        return emailPattern.matcher(email).matches();
    }
    
    public static boolean isDocCPFValid(String CPF) {
        try{
            cpfValidator.assertValid(CPF);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
