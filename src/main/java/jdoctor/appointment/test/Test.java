package jdoctor.appointment.test;

import javax.persistence.EntityManager;
import jdoctor.appointment.util.Connection;


public class Test {
    public static void main(String args[]) {
        EntityManager em = Connection.getConexao();
    }
}
