
package frontdesksystem;

public class FrontDeskSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
    }
    
}
