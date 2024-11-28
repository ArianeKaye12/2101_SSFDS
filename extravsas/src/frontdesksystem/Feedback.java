/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontdesksystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author User PC
 */
public class Feedback extends javax.swing.JFrame {

    /**
     * Creates new form Feedback
     */
    public Feedback() {
        initComponents();
        Connect();
    }

    Connection con;
    PreparedStatement pst;

        public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/java_user_database","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Feedback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaFeedback = new javax.swing.JTextArea();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Write Your Feedback");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        Feedback.setBackground(new java.awt.Color(51, 0, 0));
        Feedback.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        Feedback.setForeground(new java.awt.Color(255, 255, 255));
        Feedback.setText("Submit Feedback");
        Feedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FeedbackMouseClicked(evt);
            }
        });
        getContentPane().add(Feedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        jTextAreaFeedback.setBackground(new java.awt.Color(51, 0, 0));
        jTextAreaFeedback.setColumns(20);
        jTextAreaFeedback.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaFeedback.setRows(5);
        jScrollPane1.setViewportView(jTextAreaFeedback);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 650, 310));

        Back.setBackground(new java.awt.Color(51, 0, 0));
        Back.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 754, 444));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FeedbackMouseClicked
         // Get the feedback entered by the customer
    String feedback = jTextAreaFeedback.getText().trim();  // Assuming jTextAreaFeedback is the text area for customer feedback
    
    // Validate that the feedback is not empty
    if (feedback.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter your feedback before submitting.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Confirm with the user before submitting the feedback
    int option = JOptionPane.showConfirmDialog(this, 
                                               "Are you sure you want to submit your feedback?", 
                                               "Confirm Feedback Submission", 
                                               JOptionPane.YES_NO_OPTION, 
                                               JOptionPane.WARNING_MESSAGE);
    
    // If the user clicks "No", stop the submission process
    if (option == JOptionPane.NO_OPTION) {
        return;  // Exit the method without saving the feedback
    }
    
    // SQL query to insert the feedback into the feedback table
    String query = "INSERT INTO feedback (message) VALUES (?)";
    
    try {
        // Prepare the SQL statement
        pst = con.prepareStatement(query);
        pst.setString(1, feedback);  // Set the feedback message in the query
        
        // Execute the query
        int rowsAffected = pst.executeUpdate();
        
        // Check if the insertion was successful
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Thank you for your feedback!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            // Clear the feedback text area after saving
            jTextAreaFeedback.setText("");  // Clear the feedback text area after saving
            
      
        } else {
            JOptionPane.showMessageDialog(this, "Failed to submit your feedback. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        // Handle SQLException
        e.printStackTrace();  // Print the exception stack trace for debugging
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_FeedbackMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        User us = new User();
        us.setVisible(true);
        us.pack();
        us.setLocationRelativeTo(null);
        us.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

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
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Feedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Feedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaFeedback;
    // End of variables declaration//GEN-END:variables
}
