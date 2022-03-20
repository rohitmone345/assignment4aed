/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class CreatePersonData {
    public List<Person> list;
    
     public ArrayList<Person> CreatePersonData() {
        ArrayList<Person> list = new ArrayList<Person>();
        
       // int j = 0;
       // for(int i=0;i<10;i=i+1) {
            list.add(new Person("Anu","George","Mumbai","Thane",4,"201 Blue Park",Byte.parseByte("24"),"01-01-1997","7236589410","anu@outlook.com","123-45-6789",true,1,"F"));
            list.add(new Person("Manoj","Kumar","Mumbai","Airoli",4,"304 Green Park",Byte.parseByte("34"),"08-07-1987","7436589410","manoj@gmail.com","123-15-6789",true,1,"M"));
            list.add(new Person("Mani","Rai","Mumbai","Thane",4,"404 Aura",Byte.parseByte("14"),"09-01-2007","7536589410","mani@gmail.com","123-35-6789",true,1,"F"));
            list.add(new Person("Rohit","Verma","Mumbai","Airoli",4,"2102 Eclipse",Byte.parseByte("25"),"12-10-1994","7745589410","rohit@outlook.com","123-55-6789",true,1,"M"));
            list.add(new Person("Maliaka","Kappor","Mumbai","Thane",4,"1402 Sunflower",Byte.parseByte("6"),"02-15-2015","9876589410","malliaka@outlook.com","123-65-6789",true,1,"F"));
            list.add(new Person("Virat","Khan","Mumbai","Airoli",4,"2501 Mary World",Byte.parseByte("61"),"11-17-1950","9874589410","virat@outlook.com","123-75-6789",true,0,"M"));
            list.add(new Person("Deepika","Singh","Mumbai","Thane",4,"1301 Mannat",Byte.parseByte("11"),"08-06-2010","8745689410","deepika@outlook.com","123-85-6789",true,0,"F"));
            list.add(new Person("KL","Roy","Mumbai","Airoli",4,"1601 Antilia",Byte.parseByte("45"),"03-04-1976","8546889410","kl@outlook.com","123-95-6789",true,0,"M"));
            list.add(new Person("Kareena","Sharma","Mumbai","Thane",4,"1530 Pataudi",Byte.parseByte("40"),"01-01-1981","9636589410","kareena@outlook.com","123-53-6789",true,0,"F"));
            list.add(new Person("Ram","Kappor","Mumbai","Airoli",4,"3001 Sky Palace",Byte.parseByte("10"),"06-24-2011","7236578541","ram@outlook.com","123-43-6789",true,0,"M"));
            
         //   j++;
       // }
        return list;
    }    
}
