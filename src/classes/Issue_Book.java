/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Book;
import static sun.jvm.hotspot.HelloWorld.e;

/**
 *
 * @author kadekbuktiasa
 */
public class Issue_Book {
    
    private int book_id;
    private int member_id;
    private String status;// issue - return - lost
    private String issue_date;
    private String return_date;
    private String none;
    
    Book book = new Book();
    
    // add a new issue 
    public void addIssue(int _book_id, int _member_id, String _status, String _issue_date, String _return_date, String _note){
        
        String insertQuery = "INSERT INTO `issue_book`(`book_id`, `member_id`, `status`, `issue_date`, `return_date`, `note`) VALUES (?,?,?,?,?,?)";
        
        
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setInt(1, _book_id);
            ps.setInt(2, _member_id);
            ps.setString(3, _status);
            ps.setString(4, _issue_date);
            ps.setString(5, _return_date);
            ps.setString(6, _note);
            
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Issue Added", "Issue Book", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Issue Not Added", "Issue Book", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
          
    }
// check if this bool is available 
//    public boolean checkBookAvailability(int _book_id){
//        
//    
//        return true;
//    }  
    public boolean checkBookAvailability(int _book_id){
        
        boolean available  = false;
        try {
            Book selectBook = book.getBookById(_book_id);
            int quantity = selectBook.getQuantity();
            
            //get number of  books (the same book )
            int issue_book_count = count(_book_id); 
            
            if (quantity >issue_book_count){
                
                boolean availability = true;
            
            }
            else 
            {
                
                boolean availability = false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    
    
    
    public int count(int _book_id) throws SQLException{
    
        int total = 0;
        ResultSet rs;
        PreparedStatement ps;

        
      try {
            ps = DB.getConnection().prepareStatement("SELECT COUNT(*) as total FROM `issue_book`  WHERE book_id =? and 'status' = 'issued'");
            ps.setInt(1,_book_id);
            rs = ps.executeQuery();
        
        if(rs.next()){
        
            total = rs.getInt("total");
        }
        
        } catch (SQLException ex) {
            
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return total;
    }
}


    
