/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ken Jaya
 */
public class SelectImage {
    
    
    public String select(JLabel label_path){
        JFileChooser fileChooser = new JFileChooser ();
        fileChooser.setDialogTitle("Select Profile Picture");

        fileChooser.setCurrentDirectory(new File ("C:\\images"));

        FileNameExtensionFilter extentionFilter = new FileNameExtensionFilter("image",".png",".jpg",".jpeg");
        fileChooser.addChoosableFileFilter (extentionFilter);

        int fileState = fileChooser.showSaveDialog(null);
        
        String path = null;

        if(fileState == JFileChooser.APPROVE_OPTION)
        {
            path = fileChooser.getSelectedFile().getAbsolutePath();
            label_path.setText(path);

            new DisplayImage(label_path.getWidth(), label_path.getWidth(), null, label_path, path);
        }

        return path;
    
    }
    
    
    
}
