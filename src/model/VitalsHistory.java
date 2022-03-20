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
public class VitalsHistory {
     private ArrayList<Vitals> vitals_directory;
    
    public VitalsHistory(){
        this.vitals_directory = new ArrayList<Vitals>();
    }

    public ArrayList<Vitals> getVitalsDirectory() {
        return vitals_directory;
    }

    public void setVitalsDirectory(ArrayList<Vitals> vitals_directory) {
        this.vitals_directory = vitals_directory;
    }
    public Vitals addToVitalsDirectory(){
        Vitals v = new Vitals();
        vitals_directory.add(v);
        return v;
    }
    
    public void deleteFromVitalsDirectory(Vitals v){
        vitals_directory.remove(v);
    }
}
