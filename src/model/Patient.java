/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * 
 */
public class Patient {
    private int patientId;
    private PersonDirectory person_directory;

    public Patient() {
        person_directory = new PersonDirectory();
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
    public PersonDirectory getPersondirectory() {
        return person_directory;
    }

    public void setPersondirectory(PersonDirectory person_directory) {
        this.person_directory = person_directory;
    }

}
