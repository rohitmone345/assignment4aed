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
public class Person {
    private String fName;
    private String lName;
    private String city;
    private String community;
    private int zip;
    private String house;
    private byte age;
    private String dob;
    private String telNum;
    private String email;
    private String ssn;
    private boolean patient;
    private int patientId;
    private String gender;

     public Person() {
    }
     
     public Person(String fName,String lName,String city, String community,int zip, String house, byte age, String dob,String telNum,String email,String ssn, boolean patient,int patientId, String gender) {
        this.fName = fName;
        this.lName = lName;
        this.city = city;
        this.community = community;
        this.zip = zip;
        this.house = house;
        this.age = age;
        this.dob = dob;
        this.telNum = telNum;
        this.email = email;
        this.ssn = ssn;
        this.patient = patient;
        this.patientId = patientId;
        this.gender = gender;
        
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    
     public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public boolean isPatient() {
        
        return patient;
    }

    public void setPatient(boolean patient) {
        this.patient = patient;
    }

    @Override
    public String toString(){
        return fName;
    }
}
