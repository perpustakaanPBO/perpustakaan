
import gui.Template;
import gui.Background;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ken Jaya
 */


public class root {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Template t = new Template();
        
        t.getContentPane().add(new Background("E:/java_project/Perpustakaan/src/assets/background.png"));
        
    }
    
}
