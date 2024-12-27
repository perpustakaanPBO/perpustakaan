/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ken Jaya
 */
public class Genre extends DB {
    
    private int id;
    private String name;
    
    public Genre(){
        
    }
    
    public Genre(int _id, String _name){
        
        this.id = _id;
        this.name = _name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(String _name) {
        this.name = _name;
    }
    
    
    public void addGenre(String _name) throws SQLException{
    
        String insertQuery = "INSERT INTO `book_genres` (`nama`) VALUES (?)";
        
        
        
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, _name);
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Genre Added", "Add Genre", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Genre Not Added", "Add Genre", 1);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, e);
        }
            
    }
    
    
    public void editGenre(int _id, String _name) throws SQLException{
    
        String editQuery = "UPDATE `book_genres` SET `nama` = ? WHERE `id` = ?"; 
       
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setInt(2, _id);
            ps.setString(1, _name);
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Genre Updated", "Edit Genre", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Genre Not Updated", "Edit Genre", 1);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, e);
        }
            
    }
}
