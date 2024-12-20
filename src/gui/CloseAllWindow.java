package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Window;
import javax.swing.JFrame;

/**
 *
 * @author Ken Jaya
 */


public class CloseAllWindow {
        
    /**
     * @param args the command line arguments
     */
    public CloseAllWindow(){
        for (Window window : Window.getWindows()) {
            if (window instanceof JFrame) {
                window.dispose(); // Closes the frame
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    
    }
    
}
