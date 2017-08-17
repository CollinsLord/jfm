package sok.jfm.ui;


import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This class represents the main file manager window.
 */
public class FMWindow extends JFrame {

    // Temporary variables. Remove once we have sidebar and content widgets.
    private File f;
    private JSplitPane splitPane;

    /**
     * Create a new <code>FMWindow</code>.
     */
    public FMWindow() {

        setTitle("Java File Manager");
        setSize(400, 300);
        Dimension minimumSize = new Dimension(100, 60);
        //Provide a preferred size for the split pane.

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(150);
        splitPane.setPreferredSize(new Dimension(400, 300));
        add(splitPane);

        f = new File(System.getProperty("user.home"));
        Component c1 = getGui(f.listFiles(new TextFileFilter()), true);
        splitPane.setTopComponent(c1);
        c1.setMinimumSize(minimumSize);

        getDetailGui(f.listFiles(new FileReadererRight()), true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Component getGui(Object[] all, boolean vertical) {
        // put File objects in the list..
        JList jlist = new JList(all);
        // ..then use a renderer
        jlist.setCellRenderer(new FileRenderer(!vertical));
        jlist.addListSelectionListener(new ListSelectionListener() {
            //Listens to the list
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Object filename = jlist.getSelectedValue();
                    changeGui(filename.toString());

                }
            }

        });
        if (!vertical) {
            jlist.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
            jlist.setVisibleRowCount(-1);
        } else {
            jlist.setVisibleRowCount(9);
        }
        return new JScrollPane(jlist);
    }

    public void getDetailGui(File[] all, boolean vertical) {
        // put File objects in the list..
        JList jlist = new JList(all);
        jlist.setCellRenderer(new FileRenderer(!vertical));
        if (!vertical) {
            jlist.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
            jlist.setVisibleRowCount(-1);
        } else {
            jlist.setVisibleRowCount(9);
        }
        splitPane.setBottomComponent(new JScrollPane(jlist));
    }
    //Method to the change the directory in the right LocationBar
    public void changeGui(String str) {
        File file = new File(str);
        getDetailGui(file.listFiles(new FileReadererRight()), true);
    }
}

