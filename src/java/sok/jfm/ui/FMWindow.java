package sok.jfm.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

/**
 * This class represents the main file manager window.
 */
public class FMWindow extends JFrame {
     private JPanel one = new JPanel();
     private JPanel two = new JPanel();
     private JLabel label1 = new JLabel("File");
     private JLabel label2 = new JLabel("Content");
     private JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
             true, one, two);

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
