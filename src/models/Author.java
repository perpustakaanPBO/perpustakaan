
package models;

import classes.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Author {
    
    private int id;
    private String firstName;
    private String lastName;
    private String field_Of_Expertise;
    private String about;
    
    
    public Author(){}
    
     public Author(int _id, String _fname, String _lname, String _expertise, String _about)
    {
        this.id = _id;
        this.firstName = _fname;
        this.lastName = _lname;
        this.field_Of_Expertise = _expertise;
        this.about = _about;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setField_Of_Expertise(String field_Of_Expertise) {
        this.field_Of_Expertise = field_Of_Expertise;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getField_Of_Expertise() {
        return field_Of_Expertise;
    }

    public String getAbout() {
        return about;
    }
    
    
      public void addAuthor(String _fname,String _lname,String _expertise,String _about) throws SQLException{
    
        String insertQuery = "INSERT INTO `author`(`firstName`, `lastName`, `expertise`, `about`) VALUES (?,?,?,?)";
        
        
        
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _expertise);
            ps.setString(4, _about);
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Author Added", "Add author", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Author Not Added", "Add author", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, e);
        }
            
    }
      
      public void editAuthor(int _id,String _fname,String _lname,String _expertise,String _about ) throws SQLException{
    
        String editQuery = "UPDATE `author` SET `firstName`=?,`lastName`=?,`expertise`=?,`about`=? WHERE `id`=?"; 
       
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _expertise);
            ps.setString(4, _about);
            ps.setInt(5, _id);
            
           
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Author Updated", "Edit author", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Author Not Updated", "Edit author", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, e);
        }
            
    }
      
      public void removeAuthor(int _id ) {
    
        String removeAuthor = "DELETE FROM `author` WHERE `id` = ?"; 
       
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(removeAuthor);
            
            ps.setInt(1, _id);
           
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Author Deleted", "remove", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Author Not Deleted", "remove", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, e);
        }
            
    }

    public void editGenre(int id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
     
    public ArrayList<Author> AuthorsList(){
        
        ArrayList<Author> aList = new ArrayList<>();
        
        String selectQuery = "SELECT * FROM `author`";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = DB.getConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            Author author;
            
            while(rs.next()){
                
              
                author = new Author(rs.getInt("id"), rs.getString("firstName"),rs.getString("lastName"),rs.getString("expertise"),rs.getString("about"));
                aList.add(author);
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aList;
    }
}
