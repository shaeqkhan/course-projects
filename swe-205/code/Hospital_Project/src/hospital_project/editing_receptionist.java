/*
 * Class name : editing_receptionist.java
 *
 * Created on May 5, 2009, 11:58 AM
 *
 * Last Modified on June 12, 2009
 *
 * Why was this class created?
 * This GUI interface will allow the admin to change the receptionist information
 * which has been stored in the system.
 */

package hospital_project;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/*
 * @author  MHYS Software Productions. Copyright©. All rights unreserved.
 */
public class editing_receptionist extends javax.swing.JFrame {

    /** Creates new form editing_receptionist */
    public editing_receptionist() {
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

        panel_oldInformation = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textField_userName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textField_password = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textField_renterPassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textField_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_newInformation = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        textField_newUserName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textField_newPassword = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textField_newRenterPassword = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textField_newName = new javax.swing.JTextField();
        label_companyRights2 = new javax.swing.JLabel();
        label_companyRights1 = new javax.swing.JLabel();
        button_change = new javax.swing.JButton();
        button_cancel = new javax.swing.JButton();
        label_backToMainMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Heriditary Blood Disorder Center HBDC");
        setBounds(new java.awt.Rectangle(200, 0, 0, 0));
        setResizable(false);

        panel_oldInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Old Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Account Type:");

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Receptionist");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("Password:");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("Re-enter Password:");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Name:");

        javax.swing.GroupLayout panel_oldInformationLayout = new javax.swing.GroupLayout(panel_oldInformation);
        panel_oldInformation.setLayout(panel_oldInformationLayout);
        panel_oldInformationLayout.setHorizontalGroup(
            panel_oldInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_oldInformationLayout.createSequentialGroup()
                .addGroup(panel_oldInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_oldInformationLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2))
                    .addGroup(panel_oldInformationLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel3))
                    .addGroup(panel_oldInformationLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel4))
                    .addGroup(panel_oldInformationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(panel_oldInformationLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_oldInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(textField_userName, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(textField_password, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(textField_renterPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(textField_name, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_oldInformationLayout.setVerticalGroup(
            panel_oldInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_oldInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_oldInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panel_oldInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panel_oldInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panel_oldInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_renterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(panel_oldInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please enter the new information for the user in the box below.");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Make sure that you enter all required fields.");

        panel_newInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 24), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel10.setForeground(new java.awt.Color(0, 102, 153));
        jLabel10.setText("Username:");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setText("Password:");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setText("Re-enter Password:");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("Name:");

        javax.swing.GroupLayout panel_newInformationLayout = new javax.swing.GroupLayout(panel_newInformation);
        panel_newInformation.setLayout(panel_newInformationLayout);
        panel_newInformationLayout.setHorizontalGroup(
            panel_newInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_newInformationLayout.createSequentialGroup()
                .addGroup(panel_newInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_newInformationLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel10))
                    .addGroup(panel_newInformationLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel11))
                    .addGroup(panel_newInformationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(panel_newInformationLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_newInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField_newName, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(textField_newRenterPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(textField_newPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(textField_newUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_newInformationLayout.setVerticalGroup(
            panel_newInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_newInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_newInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_newUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panel_newInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(panel_newInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_newRenterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(panel_newInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_newName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label_companyRights2.setFont(new java.awt.Font("Tahoma", 0, 10));
        label_companyRights2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_companyRights2.setText("MHYS software productions");

        label_companyRights1.setFont(new java.awt.Font("Tahoma", 0, 10));
        label_companyRights1.setText("Copyright©. All rights reserved.");

        button_change.setText("Change");
        button_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_changeActionPerformed(evt);
            }
        });

        button_cancel.setText("Cancel");
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_oldInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_newInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_companyRights1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
                        .addComponent(label_companyRights2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_backToMainMenu)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_change, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(button_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button_cancel, button_change});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_oldInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(panel_newInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_cancel)
                    .addComponent(button_change))
                .addGap(52, 52, 52)
                .addComponent(label_backToMainMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_companyRights1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_companyRights2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_changeActionPerformed

        /* Here the admin is required to enter the old information of the
         * receptionist.
         */
        String oldUserName = textField_userName.getText().trim();
        String oldPassword = textField_password.getText().trim();        
        String oldRenterPassword = textField_renterPassword.getText().trim();        
        String oldName = textField_name.getText().trim();

        // To check if the same password has been typed into the 2 fields.
        if(!(oldPassword.equals(oldRenterPassword))){
           textField_password.setText("");
           textField_renterPassword.setText("");
           JOptionPane.showMessageDialog(null, "Password entered in the password fields do not match.","Error", JOptionPane.ERROR_MESSAGE);
        }

        /* Here the admin is required to enter the new information of the
         * receptionist.
         */
        String userName = textField_newUserName.getText().trim();        
        String password = textField_newPassword.getText().trim();        
        String renterPassword = textField_newRenterPassword.getText().trim();        
        String name = textField_newName.getText().trim();

        // To check if the same password has been typed into the 2 fields.
        if(!(password.equals(renterPassword))){
           textField_newPassword.setText("");
           textField_newRenterPassword.setText("");
           JOptionPane.showMessageDialog(null, "Password entered in the password fields do not match.","Error", JOptionPane.ERROR_MESSAGE);
        }

        try{
            // Initialize a new Array List of type "Receptionist"
            ArrayList <Receptionist> rec = new ArrayList<Receptionist>(Control.importReceptionistDatabase());

            // The loop is to find the particular user from the Array List using his old information and then initialize the information to them.
            for(Receptionist r:rec){
              if(oldUserName.equals(r.getUserName()) && oldPassword.equals(r.getPassword()) && oldName.equals(r.getName())){
                r.setName(name);
                r.setPassword(password);
                r.setUserName(userName);
              }
            }
            // This will write the Doctor database back to the file and show a message to the admin that the operation was successful.
             Control.printReceptionistDatabase(rec);

             // This meesage will show the admin that the user update was successfully done.
             JOptionPane.showMessageDialog(null, "A receptionist was successfully modified to the database by the admin.");
             System.out.println("A receptionist was successfully modified to the database by the admin.");
        }
        // If the operation wasnt successful, then the following message will apppear to the admin.
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Receptionist with the particular information does not exist in system database.","Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_button_changeActionPerformed

    // when the button "Cancel" is pressed, then all the text fields are initailized to blanks.
    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
        textField_newUserName.setText("");
        textField_newPassword.setText("");
        textField_newRenterPassword.setText("");
        textField_newName.setText("");
    }//GEN-LAST:event_button_cancelActionPerformed

    // If the admin wants to return back to his control panel then the "Back to Main Menu" label when pressed makes the control panel visible.
    private void label_backToMainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_backToMainMenuMouseClicked
        new AdminControlPanel().setVisible(true);
    }//GEN-LAST:event_label_backToMainMenuMouseClicked

    /**
    * @param args the command line arguments
     * Note from author: This code has been generated automatically from NETBEANS.
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editing_receptionist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_change;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_backToMainMenu;
    private javax.swing.JLabel label_companyRights1;
    private javax.swing.JLabel label_companyRights2;
    private javax.swing.JPanel panel_newInformation;
    private javax.swing.JPanel panel_oldInformation;
    private javax.swing.JTextField textField_name;
    private javax.swing.JTextField textField_newName;
    private javax.swing.JTextField textField_newPassword;
    private javax.swing.JTextField textField_newRenterPassword;
    private javax.swing.JTextField textField_newUserName;
    private javax.swing.JTextField textField_password;
    private javax.swing.JTextField textField_renterPassword;
    private javax.swing.JTextField textField_userName;
    // End of variables declaration//GEN-END:variables

}
