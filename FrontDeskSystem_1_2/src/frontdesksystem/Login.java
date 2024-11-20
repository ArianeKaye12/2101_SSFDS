
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

        jLabel4 = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabelRegister = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnbCancel = new javax.swing.JButton();
        tfPassword = new javax.swing.JPasswordField();
        tfUsername = new javax.swing.JTextField();
        jComboBoxRole = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login Form");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 20, 30));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 20, 30));

        jLabelRegister.setBackground(new java.awt.Color(204, 204, 204));
        jLabelRegister.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegister.setText("Create an Account. Register Now");
        jLabelRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegisterMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 200, 20));

        btnLogin.setBackground(new java.awt.Color(0, 153, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 80, -1));

        btnbCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnbCancel.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnbCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnbCancel.setText("Cancel");
        btnbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnbCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 90, -1));
        getContentPane().add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 160, 30));
        getContentPane().add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 160, 30));

        jComboBoxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Admin", "Customer" }));
        getContentPane().add(jComboBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 160, 30));

        jLabel5.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Role:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 50, 30));

        jLabel3.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 90, 30));

        jLabel2.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User PC\\Downloads\\back-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(500, 408));
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
                    this.dispose();  
                } else if ("customer".equalsIgnoreCase(selectedRole)) {

                    User userScreen = new User();
                    userScreen.setVisible(true);
                    userScreen.pack();
                    userScreen.setLocationRelativeTo(null);
                    userScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a valid role (Admin or Customer).", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Account not found. Please check your username and password.", "Error", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JComboBox<String> jComboBoxRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
