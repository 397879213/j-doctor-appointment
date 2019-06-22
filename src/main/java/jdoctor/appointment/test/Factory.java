package jdoctor.appointment.test;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import jdoctor.appointment.controller.DoctorController;
import jdoctor.appointment.controller.PersonController;
import jdoctor.appointment.controller.SecretaryController;
import jdoctor.appointment.model.Doctor;
import jdoctor.appointment.model.Person;
import jdoctor.appointment.model.Secretary;
import jdoctor.appointment.util.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aug
 */
public class Factory {
    public static void main(String args[]) {
        try {
            genPersons();
            genDoctors();
            genSecretary();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void genPersons() throws Exception {
        PersonController personController = new PersonController();
        
        int num = 5;
        ArrayList<String> names = new ArrayList<>();
        names.add("Marcos");
        names.add("Gabriel");
        names.add("Thiago");
        names.add("Isabela");
        names.add("Larissa");
        
        for (int i = 0; i < num; i++ ) {
            Person person = new Person(
                    names.get(i), names.get(i)+"@gmail.com", "(11) 1111-1111", 
                    "22222222222", "622.813.920-74");
            
            personController.save(person);
        }
    } 
    
    public static void genDoctors() throws Exception {
        DoctorController controller = new DoctorController();
        
        int num = 3;
        ArrayList<String> names = new ArrayList<>();
        names.add("Junior");
        names.add("Luiza");
        names.add("Matheus");
        
        for (int i = 0; i < num; i++ ) {
            Doctor doctor = new Doctor();
            doctor.setDocCPF("622.813.920-74");
            doctor.setDocRG("622.813.920-74");
            doctor.setEmail(names.get(i)+"@gmail.com");
            doctor.setName(names.get(i));
            doctor.setPassword("testt");
            doctor.setPhoneNumber("(33) 11111-1111");
            doctor.setSpecialization("Test");
            doctor.setUserNick("doc"+i);
            
            controller.save(doctor);
        }
    } 
    
    public static void genSecretary() throws Exception {
        SecretaryController controller = new SecretaryController();
        
        int num = 3;
        ArrayList<String> names = new ArrayList<>();
        names.add("Maria");
        names.add("Rodrigo");
        names.add("Felipe");
        
        for (int i = 0; i < num; i++ ) {
            Secretary secretary = new Secretary();
            secretary.setDocCPF("622.813.920-74");
            secretary.setDocRG("622.813.920-74");
            secretary.setEmail(names.get(i)+"@gmail.com");
            secretary.setName(names.get(i));
            secretary.setPassword("testt");
            secretary.setPhoneNumber("(33) 11111-1111");
            secretary.setUserNick("sec"+i);
            
            controller.save(secretary);
        }
    } 
}
