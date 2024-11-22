package homepage.design;

/**
 *
 * @author Noreen Grace G
 */
import javax.swing.*;

public class HomepageDesign {

    
    public static void main(String[] args) {
        // Set the look and feel to the system's default look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create an instance of Homepage JFrame and make it visible
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create the homepage and set it to visible
                Homepage homepage = new Homepage();  
                homepage.setVisible(true);
                
            }
        });
    }
}
