/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontdesksystem;

/**
 *
 * @author User PC
 */
public class Intro extends javax.swing.JFrame {

    /**
     * Creates new form Intro
     */
    public Intro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Percent = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MyProgress = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Percent.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Percent.setForeground(new java.awt.Color(255, 255, 255));
        Percent.setText("%");
        getContentPane().add(Percent, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 650, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot_2024-11-17_123703-removebg-preview (1).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 910, 370));
        getContentPane().add(MyProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 710, 1380, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundLandscape2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, -40, 1910, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Intro Mysplash = new Intro();
        Mysplash.setVisible(true);
        
        try{
           for (int i = 0; i <=100; i++)
           {
               Thread.sleep (40);
               Mysplash.MyProgress.setValue(i);
               Mysplash.Percent.setText(Integer.toString(i)+"%");
           }
        }catch(Exception e)
        {
            
        }
        
        new Login().setVisible(true);
        Mysplash.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar MyProgress;
    private javax.swing.JLabel Percent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
