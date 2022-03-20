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
public class PatientDirectory {
    
    private ArrayList<Patient> patient_directory;
    
    public PatientDirectory(){
        this.patient_directory = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getPatientDirectory() {
        return patient_directory;
    }

    public void setPatientDirectory(ArrayList<Patient> patient_directory) {
        this.patient_directory = patient_directory;
    }
    public Patient addToPatientDirectory(){
        Patient patient = new Patient();
        patient_directory.add(patient);
        return patient;
    }
    
    public void deleteFromPatientDirectory(Patient patient){
        patient_directory.remove(patient);
    }
      public Patient searchPatientById(int id) {
        for (Patient patient : patient_directory) {
            if (patient.getPatientId() == id) {
                return patient;
            }
        }
        return null;
    }
}
