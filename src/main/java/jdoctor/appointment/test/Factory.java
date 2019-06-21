package jdoctor.appointment.test;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import jdoctor.appointment.controller.PersonController;
import jdoctor.appointment.model.Person;
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
            //genPersons();
        } catch (Exception e) {
            
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
                    "22222222222", "13658245603");
            
            personController.save(person);
        }
    } 
}
