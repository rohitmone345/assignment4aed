/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 
 */
public class Vitals {
    private int pulse;
    private int SBP;
    private int DBP;
    private int temperature;
    private Date date;
    private int patientId;
    List<Integer> list=new ArrayList<Integer>(); 
    private int encounterNum;

    public int getEncounterNum() {
        return encounterNum;
    }

    public void setEncounterNum(int encounterNum) {
        this.encounterNum = encounterNum;
    }
    
    

       public int addToList(int val){
       
        list.add(val);
        return val;
    }
    
    public void deleteFromList(int val){
        list.remove(val);
    }
   
      public List<Integer> getList() {
        return list;
    }

    public int getSBP() {
        return SBP;
    }

    public void setSBP(int SBP) {
        this.SBP = SBP;
    }

    public int getDBP() {
        return DBP;
    }

    public void setDBP(int DBP) {
        this.DBP = DBP;
    }
    
    

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
