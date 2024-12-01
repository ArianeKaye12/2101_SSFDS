
package frontdesksystem;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends javax.swing.JFrame {

   
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMin = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        jCheckBoxPass = new javax.swing.JCheckBox();
        jComboBoxRole = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnbCancel = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabelRegister = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 20, 30));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 20, 30));

        jLabel2.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 100, 40));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot_2024-11-17_123703-removebg-preview.png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, 210));

        jPanel1.setBackground(new java.awt.Color(51, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login Form");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, 70));

        tfUsername.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 290, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pi7_user (3).png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 40, 40));

        tfPassword.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 290, 40));

        jCheckBoxPass.setBackground(new java.awt.Color(51, 0, 0));
        jCheckBoxPass.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jCheckBoxPass.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxPass.setText("Show Password");
        jCheckBoxPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPassActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 140, 20));

        jComboBoxRole.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jComboBoxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Admin", "Customer" }));
        jPanel1.add(jComboBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 290, 40));

        jLabel5.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pi7_setting (1).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 40, 40));

        btnbCancel.setBackground(new java.awt.Color(102, 102, 102));
        btnbCancel.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnbCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnbCancel.setText("Cancel");
        btnbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnbCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 90, 30));

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 90, 30));

        jLabelRegister.setBackground(new java.awt.Color(51, 0, 0));
        jLabelRegister.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabelRegister.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegister.setText("Create an Account. Register Now");
        jLabelRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegisterMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 260, -1));

        jLabel3.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pi7_padlock (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 40, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/labi.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 520, 400));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("© 2024 VAN Salon and Spa | All Rights Reserved | Privacy Policy | Terms & Conditions");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundLandscape2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 730));

        setSize(new java.awt.Dimension(1382, 731));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = tfUsername.getText();
    char[] passwordChars = tfPassword.getPassword();  
    String password = new String(passwordChars);      
    String selectedRole = jComboBoxRole.getSelectedItem().toString();

    if (username.isEmpty() || password.isEmpty() || selectedRole.isEmpty()) {
        if (username.isEmpty() && password.isEmpty() && selectedRole.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username, Password, and Role should not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Your Username.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Your Password.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (selectedRole.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a role (Admin or Customer).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {

        // Check if admin role is selected with fixed credentials
        if ("admin".equalsIgnoreCase(selectedRole)) {
            if ("SpaandSalonFrontDesk".equals(username) && "VSAS".equals(password)) {
                Admin adminScreen = new Admin();
                adminScreen.setVisible(true);
                adminScreen.pack();
                adminScreen.setLocationRelativeTo(null);
                adminScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();  // Close the login screen
                return; // Exit the method since admin login is successful
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username and password for ADMIN", "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Stop further checks for admin login
            }
        }

        // Proceed with database check for non-admin roles
        String query = "SELECT * FROM user WHERE Username = ? AND Password = ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String SUrl = "jdbc:MySQL://localhost:3306/java_user_database";
            String SUser = "root"; 
            String SPass = "";    

            con = DriverManager.getConnection(SUrl, SUser, SPass);
            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                if ("admin".equalsIgnoreCase(selectedRole)) {
                    Admin adminScreen = new Admin();
                    adminScreen.setVisible(true);
                    adminScreen.pack();
                    adminScreen.setLocationRelativeTo(null);
                    adminScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();  // Close the login screen
                } else if ("customer".equalsIgnoreCase(selectedRole)) {
                    User userScreen = new User();
                    userScreen.setVisible(true);
                    userScreen.pack();
                    userScreen.setLocationRelativeTo(null);
                    userScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();  // Close the login screen
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a valid role (Admin or Customer).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Account not found. Please sure you have an account.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "An error occurred while trying to log in. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabelRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegisterMouseClicked
        Register rgf = new Register();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabelRegisterMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void btnbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnbCancelActionPerformed

    private void jCheckBoxPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPassActionPerformed
        if (jCheckBoxPass.isSelected()) {
        tfPassword.setEchoChar((char)0);  // Show the password (no echo character)
    } else {
        tfPassword.setEchoChar('*');  // Hide the password (show asterisks)
    }
    }//GEN-LAST:event_jCheckBoxPassActionPerformed

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        tfPassword.requestFocus();
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        jComboBoxRole.requestFocus();
    }//GEN-LAST:event_tfPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnbCancel;
    private javax.swing.JCheckBox jCheckBoxPass;
    private javax.swing.JComboBox<String> jComboBoxRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
