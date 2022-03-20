/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * 
 */
public class PersonDirectory {
     private ArrayList<Person> person_directory;
    
    public PersonDirectory(){
        this.person_directory = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonDirectory() {
        return person_directory;
    }

    public void setPersonDirectory(ArrayList<Person> person_directory) {
        this.person_directory = person_directory;
    }
    public Person addToPersonDirectory(){
        Person person = new Person();
        person_directory.add(person);
        return person;
    }
    
    public void deleteFromPersonDirectory(Person person){
        person_directory.remove(person);
    }
       public void setPersonList(ArrayList<Person> person_directory) {
        this.person_directory = person_directory;

    }
}
