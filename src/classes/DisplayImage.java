/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Ken Jaya
 */
public class DisplayImage {
    
    public DisplayImage(JLabel label, String image){
        ImageIcon imageIco = new ImageIcon(getClass().getResource(image));
        Image imageRes = imageIco.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_FAST);
        
        label.setIcon(new ImageIcon(imageRes));
        
    }
    
}
