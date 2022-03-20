/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.System;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.Patient;
import model.PatientDirectory;
import model.Person;
import model.PersonDirectory;
import model.Vitals;
import model.VitalsHistory;

/**
 *
 * @author somnathsolaskar
 */
public class PopulatePanel extends javax.swing.JPanel {

    /**
     * Creates new form PopulatePanel
     */
    private TableColumn col;
     private JPanel userProcessContainer;
    private PatientDirectory patient_directory;
    private PersonDirectory person_directory;
    //private VitalSignsAndEncounterHistory vitals;
    private Vitals v;
    private VitalsHistory hist;
    private Person person;
    private Patient patient;
    public PopulatePanel(JPanel userProcessContainer,PersonDirectory person_directory, Patient patient,VitalsHistory hist) {
        initComponents();
         initComponents();
        this.userProcessContainer=userProcessContainer;
        this.patient_directory = patient_directory;
        this.person_directory = person_directory;
        this.hist = hist;
        this.patient = patient;
         combo.removeAllItems();
        
            
           combo.addItem("0-5");
           combo.addItem("6-12");
           combo.addItem("13-20");
           combo.addItem("21-25");
           combo.addItem("26-30");
           combo.addItem("31-35");
           combo.addItem("36-40");
           combo.addItem("41-45");
           combo.addItem("46-50");
           combo.addItem("51-55");
           combo.addItem("56-60");
           combo.addItem("60AndAbove");
           
           combo2.removeAllItems();
            ArrayList<String> list = new ArrayList<String>();
        for (Person person: person_directory.getPersonDirectory()) {
            list.add(person.getCommunity());
           // combo.addItem(car.getManufacturer());
        
        }
        ArrayList<String> unique = removeDuplicates(list);
        for (String item: unique) {
            
           combo2.addItem(item);
        
        }
           
        
     
       // populateRecords();
    }
 private void populateRecords(String agegroup, String community) {
     
       int lowerRange ;
       int higherRange;
       if(agegroup.equals("60AndAbove")){
           lowerRange = 60;
           higherRange = 110;
       }
       else{
        String[] parts = agegroup.split("-");
        String part1 = parts[0]; 
        String part2 = parts[1]; 
        lowerRange = Integer.parseInt(part1);
        higherRange = Integer.parseInt(part2);
       }
       col = tblPatient.getColumnModel().getColumn(7);
      //define the renderer
      col.setCellRenderer(new MyRenderer(Color.lightGray, Color.red));
      col = tblPatient.getColumnModel().getColumn(8);
      //define the renderer
      col.setCellRenderer(new MyRenderer(Color.lightGray, Color.red));
      col = tblPatient.getColumnModel().getColumn(9);
      //define the renderer
//      col.setCellRenderer(new MyRenderer(Color.lightGray, Color.blue));
//      col = tblPatient.getColumnModel().getColumn(10);
//      //define the renderer
//      col.setCellRenderer(new MyRenderer(Color.lightGray, Color.blue));
       
         DefaultTableModel model = (DefaultTableModel) tblPatient.getModel();
        model.setRowCount(0);
        for(Person person: person_directory.getPersonDirectory()){
            Object[] row = new Object[11];
            //int arr[] = new int[2];
//            if(person.getGender().equals("M")){
//            
//           //  arr =  getNormalRangeForMales(lowerRange,higherRange);}
//            else if(person.getGender().equals("F")){
//             //   arr =  getNormalRangeForFemales(lowerRange,higherRange);
//            }
            
            if(person.isPatient() && (person.getAge()>=lowerRange && person.getAge()<=higherRange) && person.getCommunity().equals(community) ){
                
                    for(Vitals v: hist.getVitalsDirectory()){
                        if(v.getPatientId() == person.getPatientId()){
                          //  if(v.getSBP()== arr[0] && v.getDBP()==arr[1]){ // 90<sbp<120 60<dbp<80
                        if((v.getSBP()<=120 && v.getSBP()>=90) && (v.getDBP()<=80 && v.getDBP()>=60)){    
                        }
                            else{
                            row[0] = person;
                            row[1] = person.getlName();
                            row[2] = person.getCity();
                            row[3] = person.getHouse();
                            row[4] = person.getZip();
                            row[5] = person.getAge();
                            row[6] =  person.getPatientId();
                            row[7] = v.getSBP();
                            row[8] = v.getDBP();
                       
                            row[9]= v.getEncounterNum();
                            row[10] = v.getDate();
                            model.addRow(row);
                            
                            } 
                    }
        }
      
        }
        
       
        }
 }
 // 90<sbp<120 60<dbp<80
// private int[]  getNormalRangeForMales(int lowerRange,int higherRange){
//     int range[] = new int[2];
//     int sbp =0;
//     int dbp = 0;
//     if(lowerRange==21 && higherRange==25){
//         sbp = 120;
//         dbp = 78;
//         
//     }
//     else if(lowerRange==26 && higherRange==30){
//          sbp = 119;
//          dbp = 76;
//     }
//      else if(lowerRange==31 && higherRange==35){
//         sbp = 114;
//         dbp = 75;
//     }
//      else if(lowerRange==36 && higherRange==40){
//         sbp = 120;
//         dbp =75;
//     }
//      else if(lowerRange==41 && higherRange==45){
//         sbp = 115;
//         dbp = 78;
//     }
//      else if(lowerRange==46 && higherRange==50){
//         sbp = 119;
//         dbp = 80;
//     }
//      else if(lowerRange==51 && higherRange==55){
//         sbp = 125;
//         dbp = 80;
//     }
//     else if(lowerRange==56 && higherRange==60){
//         sbp = 129;
//         dbp = 79;
//     }
//     else if(lowerRange==61 && higherRange==110){
//         sbp = 143;
//         dbp = 76;
//     }
//     else{
//         sbp = 120;
//         dbp = 80; 
//     }
//     range[0] = sbp;
//     range[1] = dbp;
//     return range;
// }
 
// private int[]  getNormalRangeForFemales(int lowerRange,int higherRange){
//     int range[] = new int[2];
//     int sbp =0;
//     int dbp = 0;
//     if(lowerRange==21 && higherRange==25){
//         sbp = 115;
//         dbp = 70;
//         
//     }
//     else if(lowerRange==26 && higherRange==30){
//          sbp = 113;
//          dbp = 71;
//     }
//      else if(lowerRange==31 && higherRange==35){
//         sbp = 110;
//         dbp = 72;
//     }
//      else if(lowerRange==36 && higherRange==40){
//         sbp = 112;
//         dbp =74;
//     }
//      else if(lowerRange==41 && higherRange==45){
//         sbp = 116;
//         dbp = 73;
//     }
//      else if(lowerRange==46 && higherRange==50){
//         sbp = 124;
//         dbp = 78;
//     }
//      else if(lowerRange==51 && higherRange==55){
//         sbp = 122;
//         dbp = 74;
//     }
//     else if(lowerRange==56 && higherRange==60){
//         sbp = 132;
//         dbp = 78;
//     }
//     else if(lowerRange==61 && higherRange==110){
//         sbp = 130;
//         dbp = 77;
//     }
//     else{
//         sbp = 120;
//         dbp = 80;
//     }
//     range[0] = sbp;
//     range[1] = dbp;
//     return range;
// }
 
  public static <String> ArrayList<String> removeDuplicates(ArrayList<String> list)
    {
  
        Set<String> set = new LinkedHashSet<>();

        set.addAll(list);

        list.clear();

        list.addAll(set);
  
        return list;
    }
  
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        pid = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        combo2 = new javax.swing.JComboBox<>();
        lblBP = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1086, 10087));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Abnormal Blood Pressure");

        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "City", "Address", "Zip Code", "Age", "Patient Id", "Actual SBP", "Actual DBP", "Enc Number", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPatient.setMinimumSize(new java.awt.Dimension(3000, 64));
        jScrollPane1.setViewportView(tblPatient);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblBP.setForeground(new java.awt.Color(0, 204, 0));
        lblBP.setText("Normal SBP : >90 and <120    Normal DBP : >60 and <80");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnBack))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSubmit)))
                        .addGap(0, 94, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(lblBP, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit)
                    .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(695, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1473, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1117, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1473, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1087, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String text = combo.getSelectedItem().toString();
        String text2 = combo2.getSelectedItem().toString();
       populateRecords(text, text2);
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBP;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel pid;
    private javax.swing.JTable tblPatient;
    // End of variables declaration//GEN-END:variables
}
class MyRenderer extends DefaultTableCellRenderer 
{
   Color bg, fg;
   public MyRenderer(Color bg, Color fg) {
      super();
      this.bg = bg;
      this.fg = fg;
   }
   public Component getTableCellRendererComponent(JTable table, Object 
   value, boolean isSelected, boolean hasFocus, int row, int column) 
   {
      Component cell = super.getTableCellRendererComponent(table, value, 
      isSelected, hasFocus, row, column);
      cell.setBackground(bg);
      cell.setForeground(fg);
      return cell;
   }
}