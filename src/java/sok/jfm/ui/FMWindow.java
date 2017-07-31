package sok.jfm.ui;


import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JList;
import java.io.File;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.DEBUG;


/**
 * This class represents the main file manager window.
 */
public class FMWindow extends JFrame implements TreeSelectionListener{
    
    // Temporary variables. Remove once we have sidebar and content widgets.
    private JSplitPane splitPane;
    
    private JEditorPane DisplayPane;
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
    private JTree tree;
    private DefaultMutableTreeNode root;
    

    /**
     * Create a new <code>FMWindow</code>.
     */
    public FMWindow() {
        setTitle("Java File Manager");
	    setSize(400, 300);
         
        DefaultMutableTreeNode top =new DefaultMutableTreeNode("Home");
        FileReader(top);
         //Create a tree that allows one selection at a time.
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    if (playWithLineStyle) {
        System.out.println("line style = " + lineStyle);
        tree.putClientProperty("JTree.lineStyle", lineStyle);
        }
        //Create the scroll pane and add the tree to it. 
        JScrollPane treeView = new JScrollPane(tree);
        DisplayPane = new JEditorPane();
        DisplayPane.setEditable(true);
        JScrollPane contentView = new JScrollPane(treeView);

         splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
         splitPane.setTopComponent(treeView);
         splitPane.setBottomComponent(contentView);
         add(splitPane);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    }

    /** Required by TreeSelectionListener interface. */
     public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();
 
        if (node == null) return;
 
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            FMWindow files = (FMWindow)nodeInfo;
         
            if (DEBUG) {
               
            }
        } 
        if (DEBUG) {
            System.out.println(nodeInfo.toString());
        }
    }
    //The method to read directory 
     public void FileReader(DefaultMutableTreeNode top) {
     DefaultMutableTreeNode category = null;
     DefaultMutableTreeNode book = null;
     root = new DefaultMutableTreeNode("User", true);
     getList(root, new File("/home/collins/"));
    tree = new JTree(root);
    top.add(root);
 
    }

     public void getList(DefaultMutableTreeNode node, File f) {
     if(!f.isDirectory()) {
         if (f.getName().endsWith("java")) {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(f);
            node.add(child);
            }
         }
     else {
         DefaultMutableTreeNode child = new DefaultMutableTreeNode(f);
         node.add(child);
         File fList[] = f.listFiles();
         for(int i = 0; i  < fList.length; i++)
             getList(child, fList[i]);
         }
    }
    
}
