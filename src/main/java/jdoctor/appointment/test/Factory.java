package jdoctor.appointment.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import jdoctor.appointment.controller.DoctorController;
import jdoctor.appointment.controller.PersonController;
import jdoctor.appointment.controller.SecretaryController;
import jdoctor.appointment.exception.ControllerException;
import jdoctor.appointment.model.AvailableSchedule;
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
        } catch (ControllerException ex) {
            System.out.println(ex);
        }
    }
    
    public static void genPersons() throws ControllerException {
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
                    names.get(i), names.get(i)+"@gmail.com", null, 
                    "35.322.518-6", "622.813.920-74");
            person.setPhoneNumber("(33) 11111-1111");
            
            personController.save(person);
        }
    } 
    
    public static void genDoctors() throws ControllerException {
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
            
            Random r = new Random();
            
            List<Date> workDates = new ArrayList<>();
            Calendar aux = Calendar.getInstance();
            aux.set(Calendar.HOUR_OF_DAY, r.nextInt((10 - 6) + 1)+6);
            aux.set(Calendar.MINUTE, 0);
            aux.set(Calendar.SECOND, 0);
            
            workDates.add(aux.getTime());
            aux.set(Calendar.HOUR_OF_DAY, r.nextInt((12 - 9) + 1)+9);
            workDates.add(aux.getTime());
            
            aux.set(Calendar.HOUR_OF_DAY, r.nextInt((15 - 13) + 1)+13);
            workDates.add(aux.getTime());
            
            aux.set(Calendar.HOUR_OF_DAY, r.nextInt((22 - 16) + 1)+16);
            workDates.add(aux.getTime());
            
            AvailableSchedule schedule = new AvailableSchedule(null, doctor, 
                    workDates, workDates, workDates, workDates, workDates, 
                    new ArrayList<>(), new ArrayList<>());
            
            doctor.setAvailableSchedule(schedule);
            
            controller.save(doctor);
        }
    } 
    
    public static void genSecretary() throws ControllerException {
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
