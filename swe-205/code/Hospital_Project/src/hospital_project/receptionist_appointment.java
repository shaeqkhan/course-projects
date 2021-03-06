/*
 * Class name : receptionist_appointment.java
 *
 * Created on May 5, 2009, 2:00 PM
 *
 * Last Modified on June 12, 2009
 *
 * Why was this class created?
 * This GUI interface will allow the receptionist to add a ptient to the
 * appointment list of a doctor.
 */

package hospital_project;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author  MHYS Software Productions. Copyright©. All rights unreserved.
 */

public class receptionist_appointment extends javax.swing.JFrame {

    /** Creates new form receptionist_appointment */
    public receptionist_appointment() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     *
     * Note from author: This code has been generated automatically from NETBEANS.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_appointmentSchedule = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textField_doctor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textField_speciality = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textField_patientName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_time = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textField_appointmentTime = new javax.swing.JTextField();
        button_checkSchedule = new javax.swing.JButton();
        button_saveAppointment = new javax.swing.JButton();
        label_backToMainMenu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textField_date = new javax.swing.JTextField();
        label_companyRights1 = new javax.swing.JLabel();
        label_companyRights2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Heriditary Blood Disorder Center HBDC");
        setBounds(new java.awt.Rectangle(200, 0, 0, 0));
        setResizable(false);

        panel_appointmentSchedule.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Appointment Schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please fill in all required fields to schedule an appointment.");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Doctor:");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setText("Speciality:");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("Patient name:");

        jList_time.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "9 to 10 am", "10 to 11 am", "11 to 12 pm", "2 to 3 pm", "3 to 4 pm", "4 to 5 pm", "5 to 6 pm", "6 to 7 pm", "7 to 8 pm" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList_time.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_timeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList_time);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Available appointment time");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14));
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Enter a suitable time for appointment:");

        button_checkSchedule.setText("Check doctor's schedule");
        button_checkSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_checkScheduleActionPerformed(evt);
            }
        });

        button_saveAppointment.setText("Save appointment");
        button_saveAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveAppointmentActionPerformed(evt);
            }
        });

        label_backToMainMenu.setFont(new java.awt.Font("Tahoma", 0, 12));
        label_backToMainMenu.setForeground(new java.awt.Color(0, 0, 255));
        label_backToMainMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_backToMainMenu.setText("Back to Main Menu");
        label_backToMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_backToMainMenuMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("Date:");

        javax.swing.GroupLayout panel_appointmentScheduleLayout = new javax.swing.GroupLayout(panel_appointmentSchedule);
        panel_appointmentSchedule.setLayout(panel_appointmentScheduleLayout);
        panel_appointmentScheduleLayout.setHorizontalGroup(
            panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_appointmentScheduleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(panel_appointmentScheduleLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
                    .addGroup(panel_appointmentScheduleLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_speciality, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
                    .addGroup(panel_appointmentScheduleLayout.createSequentialGroup()
                        .addGroup(panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField_date, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                            .addComponent(textField_patientName, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)))
                    .addComponent(button_checkSchedule, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(panel_appointmentScheduleLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_appointmentTime, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                    .addComponent(button_saveAppointment, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_backToMainMenu, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        panel_appointmentScheduleLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button_checkSchedule, button_saveAppointment});

        panel_appointmentScheduleLayout.setVerticalGroup(
            panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_appointmentScheduleLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textField_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textField_speciality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textField_patientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textField_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(button_checkSchedule)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_appointmentScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textField_appointmentTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(button_saveAppointment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(label_backToMainMenu)
                .addGap(29, 29, 29))
        );

        label_companyRights1.setFont(new java.awt.Font("Tahoma", 0, 10));
        label_companyRights1.setText("Copyright©. All rights reserved.");

        label_companyRights2.setFont(new java.awt.Font("Tahoma", 0, 10));
        label_companyRights2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_companyRights2.setText("MHYS software productions");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_appointmentSchedule, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_companyRights1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                        .addComponent(label_companyRights2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_appointmentSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_companyRights1)
                    .addComponent(label_companyRights2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // when teh button "Save" is pressed the following actions take place.
    private void button_saveAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveAppointmentActionPerformed
        
        // time from the text filed is saved to a variable.
        String appointmentTime = textField_appointmentTime.getText().trim();
        
        // condition to check if the user has selected a time.
        if(appointmentTime.equals("")){
            JOptionPane.showMessageDialog(null, "Field is blank.\nPlease select suitable time.","Error", JOptionPane.ERROR_MESSAGE);
        }

        // storing information from the GUI to a variable.
        String doctor = textField_doctor.getText().trim();
        String date = textField_date.getText().trim();
        String speciality = textField_speciality.getText().trim();
        String patientName = textField_patientName.getText().trim();

        // Condition to check if none of the fields are empty.
        if(doctor.equals("") || date.equals("") || speciality.equals("") || patientName.equals("")){
            JOptionPane.showMessageDialog(null, "One or more required field is empty. Please fill in all required details.","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        // Arraylist of type appointment is declared.
        ArrayList<Appointment> app = new ArrayList<Appointment>();

        // the information from text file is stored in the array list using the "Control" class.
        app = Control.importAppointmentDatabase(doctor);

        // Method called to class "Appointment" which makes sure that there is no conflict of schedule.
        if(!(Appointment.checkTime(app, appointmentTime))){
            JOptionPane.showMessageDialog(null, "The appointment time is unavailable.\nIt has been registered by another patient.\nPlease select another time slot.","Error", JOptionPane.ERROR_MESSAGE);
            textField_appointmentTime.setText("");
        }
        else{
            try{
                // new appointment is added to the array list.
                app.add(new Appointment(date, appointmentTime, speciality, doctor, patientName));
                // the appointment list is wriiten to the file using "Control" class.
                Control.printAppointments(app, doctor);
                // user is notified if the appointment is confirmed.
                JOptionPane.showMessageDialog(null, "Your appointment with Dr. " + doctor + " is confirmed.");

            }
            // in case appointment could not be scheduled, error message is shown.
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Your appointment could not be confirmed. Please try again.","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_button_saveAppointmentActionPerformed

    // Opens a window which allows receptionsit to view a doctor's schedule
    private void button_checkScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_checkScheduleActionPerformed
        
        new doctor_view_schedule().setVisible(true);
        
    }//GEN-LAST:event_button_checkScheduleActionPerformed

    /* Action listener to record any changes in the selection of the JList.
     * This uses a switch case mechanism to read the selection of the user
     * and then display the selected content into a text field.
     */
    private void jList_timeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_timeValueChanged
      int counter = jList_time.getSelectedIndex();
      String time;
      switch(counter){
          case 0 : time = "9-10am";break;
          case 1 : time = "10-11am";break;
          case 2 : time = "11-12pm";break;
          case 3 : time = "2-3pm";break;
          case 4 : time = "3-4pm";break;
          case 5 : time = "4-5pm";break;
          case 6 : time = "5-6pm";break;
          case 7 : time = "6-7pm";break;
          case 8 : time = "7-8pm";break;

          default: time = "";break;
      }
      textField_appointmentTime.setText(time);

}//GEN-LAST:event_jList_timeValueChanged

    private void label_backToMainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_backToMainMenuMouseClicked
        new receptionist_controlpanel().setVisible(true);
    }//GEN-LAST:event_label_backToMainMenuMouseClicked

    /**
    * @param args the command line arguments
     * Note from author: This code has been generated automatically from NETBEANS.
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new receptionist_appointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_checkSchedule;
    private javax.swing.JButton button_saveAppointment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList_time;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_backToMainMenu;
    private javax.swing.JLabel label_companyRights1;
    private javax.swing.JLabel label_companyRights2;
    private javax.swing.JPanel panel_appointmentSchedule;
    private javax.swing.JTextField textField_appointmentTime;
    private javax.swing.JTextField textField_date;
    private javax.swing.JTextField textField_doctor;
    private javax.swing.JTextField textField_patientName;
    private javax.swing.JTextField textField_speciality;
    // End of variables declaration//GEN-END:variables

}
