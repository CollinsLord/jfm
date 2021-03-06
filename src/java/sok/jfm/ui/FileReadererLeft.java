/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sok.jfm.ui;

import java.awt.Component;
import java.io.File;
import java.io.FileFilter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import javax.swing.filechooser.FileSystemView;

class FileRenderer extends DefaultListCellRenderer {

    private boolean pad;
    private Border padBorder = new EmptyBorder(3, 3, 3, 3);

    FileRenderer(boolean pad) {
        this.pad = pad;
    }

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        JLabel l = (JLabel) c;
        File f = (File) value;
        l.setText(f.getName());
        l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
        if (pad) {
            l.setBorder(padBorder);
        }

        return l;
    }

}

class TextFileFilter implements FileFilter {

    public boolean accept(File file) {
        String name = file.getName().toLowerCase();
        return name.startsWith("downloads") || name.startsWith("documents")
                || name.startsWith("pictures") || name.startsWith("music") || name.startsWith("desktop")
                || name.startsWith("videos");
        
    }

}

