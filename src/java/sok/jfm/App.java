package sok.jfm;

import sok.jfm.ui.FMWindow;

/**
 * The application class.
 *
 * This class should only hold the main main method as well as some other
 * utility stuff used required for starting up the application.
 */
public class App {

    /**
     * Application entry point.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        (new FMWindow()).setVisible(true);
    }
}
