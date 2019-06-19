package jdoctor.appointment.util;

import java.awt.Component;
import javax.swing.JOptionPane;


public class GuiUtils {
    private static final String TITLE = "JDOC - ";
    
    public static void showErrorOkDialog(String message, Component component) {
        Object[] options = {"OK"};
                int n = JOptionPane.showOptionDialog(component,
                           message,TITLE+"Opa...",
                           JOptionPane.PLAIN_MESSAGE,
                           JOptionPane.QUESTION_MESSAGE,
                           null,
                           options,
                           options[0]);
    }
    
    public static void showConfirmOkDialog(String message, Component component) {
        Object[] options = {"OK"};
                int n = JOptionPane.showOptionDialog(component,
                           message,TITLE+"Tudo certo!",
                           JOptionPane.PLAIN_MESSAGE,
                           JOptionPane.QUESTION_MESSAGE,
                           null,
                           options,
                           options[0]);
    }
}
