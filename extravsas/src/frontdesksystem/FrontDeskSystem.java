
package frontdesksystem;

public class FrontDeskSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Show the Intro frame (splash screen)
        Intro introFrame = new Intro();
        introFrame.setVisible(true);
        introFrame.startProgressBar(); // Start the progress bar

        // Wait for the splash screen to finish
        try {
            Thread.sleep(4750); // Adjust sleep time based on the duration of the progress bar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After progress bar, hide splash and show Login
        introFrame.dispose();
        new Login().setVisible(true);
    }
}
