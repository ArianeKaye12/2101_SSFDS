
package frontdesksystem;


import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_ADD = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField_REPASS = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_UN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_FN = new javax.swing.JTextField();
        jTextField_LN = new javax.swing.JTextField();
        jPasswordFieldPASS = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jButton_Cancel = new javax.swing.JButton();
        jButton_Register_ = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setForeground(new java.awt.Color(51, 0, 0));

        jTextArea_ADD.setBackground(new java.awt.Color(51, 0, 0));
        jTextArea_ADD.setColumns(20);
        jTextArea_ADD.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTextArea_ADD.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea_ADD.setRows(5);
        jScrollPane1.setViewportView(jTextArea_ADD);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, 270, 50));

        jLabel8.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Retype Password: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 170, 40));

        jPasswordField_REPASS.setBackground(new java.awt.Color(51, 0, 0));
        jPasswordField_REPASS.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jPasswordField_REPASS.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField_REPASS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_REPASSActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField_REPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, 270, 40));

        jLabel7.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, 110, 40));

        jTextField_UN.setBackground(new java.awt.Color(51, 0, 0));
        jTextField_UN.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTextField_UN.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_UN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_UNActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_UN, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, 270, 40));

        jLabel5.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 110, 40));

        jLabel3.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 120, 40));

        jLabel6.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, 90, 50));

        jLabel4.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, 100, 40));

        jTextField_FN.setBackground(new java.awt.Color(51, 0, 0));
        jTextField_FN.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTextField_FN.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_FN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FNActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_FN, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 220, 270, 40));

        jTextField_LN.setBackground(new java.awt.Color(51, 0, 0));
        jTextField_LN.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jTextField_LN.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_LN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_LNActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_LN, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 270, 270, 40));

        jPasswordFieldPASS.setBackground(new java.awt.Color(51, 0, 0));
        jPasswordFieldPASS.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jPasswordFieldPASS.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordFieldPASS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPASSActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordFieldPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 370, 270, 40));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Register");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 250, 60));

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 20, 20));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 20, 30));

        jButton_Cancel.setBackground(new java.awt.Color(102, 102, 102));
        jButton_Cancel.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jButton_Cancel.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Cancel.setText("Cancel");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 540, 100, 30));

        jButton_Register_.setBackground(new java.awt.Color(51, 0, 0));
        jButton_Register_.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jButton_Register_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register_.setText("Register");
        jButton_Register_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Register_ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Register_, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 540, 100, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot_2024-11-17_123703-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, 220));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("© 2024 VAN Salon and Spa | All Rights Reserved | Privacy Policy | Terms & Conditions");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        jLabel1.setBackground(new java.awt.Color(51, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundLandscape2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 720));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 590, 440));

        setSize(new java.awt.Dimension(1360, 731));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jButton_Register_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Register_ActionPerformed
        System.out.println("Sign Up btn clicked!");

    String First_Name, Last_Name, Username, Password, Retype_Password, Address, query;
    String SUrl, SUser, SPass;
    SUrl = "jdbc:MySQL://localhost:3306/java_user_database";
    SUser = "root"; 
    SPass = "";     

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

        if ("".equals(jTextField_FN.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "First Name is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(jTextField_LN.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Last Name is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(jTextField_UN.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Username is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(jPasswordFieldPASS.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(jPasswordField_REPASS.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Confirm Password is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("".equals(jTextArea_ADD.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Address is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            First_Name = jTextField_FN.getText();
            Last_Name = jTextField_LN.getText();
            Username = jTextField_UN.getText();
            Password = jPasswordFieldPASS.getText();
            Retype_Password = jPasswordField_REPASS.getText();
            Address = jTextArea_ADD.getText();

            if (!Password.equals(Retype_Password)) {
                JOptionPane.showMessageDialog(new JFrame(), "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }

            String checkUsernameQuery = "SELECT * FROM user WHERE Username = ?";
            PreparedStatement pstCheckUser = con.prepareStatement(checkUsernameQuery);
            pstCheckUser.setString(1, Username);
            ResultSet rs = pstCheckUser.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(new JFrame(), "Username is already taken. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }

            // Confirmation dialog before inserting into the database
            int confirmation = JOptionPane.showConfirmDialog(
                    new JFrame(),
                    "Are you sure you want to register?",
                    "Confirm Registration",
                    JOptionPane.YES_NO_OPTION
            );

            // If the user selects "No", cancel registration
            if (confirmation == JOptionPane.NO_OPTION) {
                return;  // User canceled the registration
            }

            // Proceed with insertion into the database if confirmed
            query = "INSERT INTO user(First_Name, Last_Name, Username, Password, Retype_Password, Address) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, First_Name);
            pst.setString(2, Last_Name);
            pst.setString(3, Username);
            pst.setString(4, Password);
            pst.setString(5, Retype_Password);  
            pst.setString(6, Address);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(new JFrame(), "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Clear form fields
            jTextField_FN.setText("");
            jTextField_LN.setText("");
            jTextField_UN.setText("");
            jPasswordFieldPASS.setText("");
            jPasswordField_REPASS.setText("");
            jTextArea_ADD.setText("");
            
            // Optionally open the login form after successful registration
            Login lgf = new Login();
            lgf.setVisible(true);
            lgf.pack();
            lgf.setLocationRelativeTo(null);
            lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }

    } catch (Exception e) {
        System.out.println("Error!" + e.getMessage());
    }
    }//GEN-LAST:event_jButton_Register_ActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        Login lgf = new Login();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jTextField_FNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FNActionPerformed
        jTextField_LN.requestFocus();
    }//GEN-LAST:event_jTextField_FNActionPerformed

    private void jTextField_LNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_LNActionPerformed
        jTextField_UN.requestFocus();
    }//GEN-LAST:event_jTextField_LNActionPerformed

    private void jTextField_UNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_UNActionPerformed
        jPasswordFieldPASS.requestFocus();
    }//GEN-LAST:event_jTextField_UNActionPerformed

    private void jPasswordFieldPASSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPASSActionPerformed
        jPasswordField_REPASS.requestFocus();
    }//GEN-LAST:event_jPasswordFieldPASSActionPerformed

    private void jPasswordField_REPASSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_REPASSActionPerformed
        jTextArea_ADD.requestFocus();
    }//GEN-LAST:event_jPasswordField_REPASSActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_Register_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldPASS;
    private javax.swing.JPasswordField jPasswordField_REPASS;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_ADD;
    private javax.swing.JTextField jTextField_FN;
    private javax.swing.JTextField jTextField_LN;
    private javax.swing.JTextField jTextField_UN;
    // End of variables declaration//GEN-END:variables
}
