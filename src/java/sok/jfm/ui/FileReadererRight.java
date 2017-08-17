package sok.jfm.ui;

import java.io.File;
import java.io.FileFilter;

class FileReadererRight implements FileFilter {

    public boolean accept(File file) {
        
        String name = file.getName().toLowerCase();
        return name.length() > 1;
    }

}