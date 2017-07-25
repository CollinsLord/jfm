package sok.jfm.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

/**
 * This class represents the main file manager window.
 */
public class FMWindow extends JFrame {

    /**
     *Create the instance of the JSplitePane to splite the fame.
     *Create the instance of the JPanel.
     *Create label to be added to the JPanel.
     */
     JPanel one = new JPanel();
     JPanel two = new JPanel();
     JLabel label1 = new JLabel("File");
     JLabel label2 = new JLabel("Content");
     JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,one,two);    

    /**
     * Create a new <code>FMWindow</code>.
     */
   
    public FMWindow() {
        setTitle("Java File Manager");
	setSize(400, 300);
        add(splitPane);
        one.add(label1);
        two.add(label2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
    }

}
