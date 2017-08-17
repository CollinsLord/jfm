package sok.jfm.ui;

import javax.swing.JList;
import java.io.File;


public class LocationBar extends JList  {
    
 public void listFiles(String dir){
        File directory = new File(dir);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }
 
}
