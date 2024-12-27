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
    
    public DisplayImage(int width, int height, JLabel label, String image){
        ImageIcon imageIco = new ImageIcon(getClass().getResource(image));
        Image imageRes = imageIco.getImage().getScaledInstance(width, height, Image.SCALE_FAST);
        
        label.setIcon(new ImageIcon(imageRes));
        
    }

    public DisplayImage(int width, int height, JLabel jLabel_Logo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
